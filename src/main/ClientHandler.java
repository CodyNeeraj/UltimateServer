package main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ClientHandler extends Thread
{

    /**
     * Stores the list of currently used handles as to keep them unique.
     */
    private static CopyOnWriteArrayList<String> handles = new CopyOnWriteArrayList<String>();

    /**
     * Stores the list of all currently active ClientHandler instances.
     */
    private static CopyOnWriteArrayList<ClientHandler> clients = new CopyOnWriteArrayList<ClientHandler>();

    /**
     * Stores the network socket used to interact with the client.
     */
    private Socket socket;

    /**
     * Stores the input stream reader used to receive network messages.
     */
    private DataInputStream incoming;

    /**
     * Stores the output stream writer used to send network messages.
     */
    private DataOutputStream outgoing;

    /**
     * Stores the handle currently being used by the client.
     */
    String handle;

    /**
     * Broadcasts the specified message to all connected clients.
     *
     * @param message the message to broadcast
     */
    protected static synchronized void broadcast (String message)
    {
        synchronized (clients)
        {
            ListIterator<ClientHandler> itr = clients.listIterator();
            ClientHandler current;

            while (itr.hasNext())
            {
                try
                {
                    current = itr.next();
                    current.outgoing.writeUTF(message);
                    current.outgoing.flush();
                }
                catch (Exception e)
                {
                    System.err.println("Rut roh...");
                }
            }
        }
    }

    /**
     * Checks if the specified handle is valid.
     */
    private static boolean isValidHandle (String handle)
    {
        for (int i = 0; i < handle.length(); i++)
        {
            if (!Character.isLetterOrDigit(handle.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Constructs a new client handler to service the specified client.
     *
     * @param socket
     * @throws java.io.IOException
     */
    public ClientHandler (Socket socket) throws IOException
    {
        this.socket = socket;
        incoming = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        outgoing = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        handle = null;
    }

    /**
     * Listens for messages from the client and broadcasts them to all connected clients.
     */
    @Override
    public void run ()
    {
        try
        {
            clients.add(this);

            String message;

            while (true)
            {
                message = incoming.readUTF();

                if (message.startsWith("/handle"))
                {
                    String[] parts = message.split(" ");

                    if (parts.length == 1)
                    {
                        outgoing.writeUTF("You must specify a handle!");
                    }
                    else if (!isValidHandle(parts[1]) || parts.length > 2)
                    {
                        outgoing.writeUTF("Your handle contains invalid characters!");
                    }
                    else
                    {
                        if (handles.contains(parts[1]))
                        {
                            outgoing.writeUTF("That handle is already in use!");
                        }
                        else
                        {
                            handle = parts[1];
                            handles.add(handle);
                            outgoing.writeUTF("You are now known as " + handle + "!");
                        }
                    }

                    outgoing.flush();
                }
                else
                {
                    if (handle == null)
                    {
                        outgoing.writeUTF("You must set a handle using the command /handle <handle>!");
                        outgoing.flush();
                    }
                    else
                    {
                        broadcast("[" + handle + "] says: " + message);
                    }
                }
            }

        }
        catch (IOException e)
        {
            //e.printStackTrace();
        }
        finally
        {
            clients.remove(this);
            handles.remove(handle);
            if (handle != null)
            {
                broadcast("[" + handle + "] has left the room!");
            }

            try
            {
                socket.close();
            }
            catch (IOException e)
            {
                //e.printStackTrace();
            }
        }
    }
}
