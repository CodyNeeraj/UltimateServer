package main;

import function.Client;
import function.Method;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import utilities.IpFetcher;

public class ServerMain extends javax.swing.JFrame
{

    private static final long serialVersionUID = 1L;

    private ServerSocket ss;
    private Thread run;
    private boolean isAlreadyEntered;
    private int port = 0;

    public ServerMain ()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //will set the default installed l&F as windows Native
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        portNumber = new javax.swing.JLabel();
        serverStartBtn = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        portField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        serverPass = new javax.swing.JLabel();
        passField = new javax.swing.JTextField();
        activeClientList = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        public_Ip_Port = new javax.swing.JTextField();
        loc_Ip_Port = new javax.swing.JTextField();
        refreshBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        serverStatus = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        serverStopBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CurrStatus = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Central by Neeraj");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Select IP");

        portNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        portNumber.setText("Enter Port");

        serverStartBtn.setBackground(new java.awt.Color(0, 204, 0));
        serverStartBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        serverStartBtn.setText("Start");
        serverStartBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                serverStartBtnActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setText("Localhost (127.0.0.1)");
        jTextField1.setToolTipText("Default");

        portField.setToolTipText("Possibility of non-availability of specified port\\n as being used by some another application at the same time , You are requested \\n to change it to some other value \\n (The common unsused values are from 1000 - 65535 )");
        portField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                portFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel3.setText("(10-65535)");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Configuration");

        serverPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        serverPass.setText("Password");

        activeClientList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        activeClientList.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                activeClientListActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Server");

        public_Ip_Port.setEditable(false);
        public_Ip_Port.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        public_Ip_Port.setText("Loading...");
        public_Ip_Port.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                public_Ip_PortMouseEntered(evt);
            }
        });
        public_Ip_Port.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                public_Ip_PortActionPerformed(evt);
            }
        });

        loc_Ip_Port.setEditable(false);
        loc_Ip_Port.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        loc_Ip_Port.setText("Loading...");
        loc_Ip_Port.addAncestorListener(new javax.swing.event.AncestorListener()
        {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt)
            {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt)
            {
                loc_Ip_PortAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt)
            {
            }
        });
        loc_Ip_Port.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                loc_Ip_PortActionPerformed(evt);
            }
        });

        refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        refreshBtn.setToolTipText("Refresh");
        refreshBtn.setEnabled(false);
        refreshBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                refreshBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("Local IP :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("Public IP :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setText("Current Status");

        serverStatus.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        serverStatus.setForeground(new java.awt.Color(255, 0, 0));
        serverStatus.setText("Offline");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setText("Active Clients");

        serverStopBtn.setBackground(new java.awt.Color(255, 153, 153));
        serverStopBtn.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        serverStopBtn.setText("Stop");
        serverStopBtn.setEnabled(false);
        serverStopBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                serverStopBtnActionPerformed(evt);
            }
        });

        CurrStatus.setEditable(false);
        CurrStatus.setColumns(20);
        CurrStatus.setRows(5);
        jScrollPane1.setViewportView(CurrStatus);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jLabel7)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel5)
                                    .add(jLabel6))
                                .add(5, 5, 5)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(public_Ip_Port, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                    .add(loc_Ip_Port))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(refreshBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jLabel10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(jLabel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 75, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(activeClientList, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(serverStatus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 470, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(0, 12, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(portNumber)
                                    .add(serverPass))
                                .add(24, 24, 24)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(layout.createSequentialGroup()
                                        .add(portField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 88, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(jLabel3))
                                    .add(passField)))
                            .add(layout.createSequentialGroup()
                                .add(jLabel1)
                                .add(35, 35, 35)
                                .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 118, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 118, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, serverStartBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, serverStopBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(21, 21, 21))))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel5)
                                    .add(loc_Ip_Port, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(5, 5, 5)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel6)
                                    .add(public_Ip_Port, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(refreshBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel10)
                                    .add(serverStatus))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel12)
                                    .add(activeClientList, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 12, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jLabel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)))
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(layout.createSequentialGroup()
                                .add(2, 2, 2)
                                .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(serverStartBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(portNumber)
                            .add(layout.createSequentialGroup()
                                .add(2, 2, 2)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(portField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jLabel3))))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(serverPass)
                            .add(passField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(serverStopBtn, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 279, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void serverStartBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_serverStartBtnActionPerformed
    {//GEN-HEADEREND:event_serverStartBtnActionPerformed
        boolean isBindException, isIOException, isIllegalArgument;
        isBindException = isIOException = isIllegalArgument = false;
        try
        {
            port = Integer.parseInt(portField.getText());
            ss = new ServerSocket(port);
            //ServerSocket ss = new ServerSocket(port);
        }
        catch (NumberFormatException e)
        {
            if (portField.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Port cannot be left Empty", "Port Error", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Port can only be a Number", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (BindException b) //for serversocket object
        {
            isBindException = true; //setted flag to true (only if ocurred)
            JOptionPane.showMessageDialog(this, "Port Already being used by some other application", "Port Already Occupied", JOptionPane.WARNING_MESSAGE);
        }
        catch (IOException e)
        {
            isIOException = true;
            JOptionPane.showMessageDialog(this, "Exception ocurred in I/O of the program\nwhile making connection request", "I/O Error", JOptionPane.WARNING_MESSAGE);
            System.out.println("IOException ocurred");
        }
        catch (IllegalArgumentException e)
        {
            isIllegalArgument = true;
            //JOptionPane.showMessageDialog(this, "Port isn't in the range specified", "Value Error", JOptionPane.WARNING_MESSAGE);
        }

        if (port < 10)
        {
            JOptionPane.showMessageDialog(this, "Port isn't in the range specified", "Value Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            if (isBindException | isIOException | isIllegalArgument)
            {
                //DO nothing LOL, just for keeping the fact of executing nothing until user's input
            }
            if (!isBindException && !isIOException && !isIllegalArgument)
            {
                //enabling btn for use now
                refreshBtn.setEnabled(true);
                serverStartBtn.setEnabled(false);
                serverStopBtn.setEnabled(true);
                portField.setEnabled(false);
                serverStatus.setForeground(Color.blue);
                serverStatus.setText("Online");

                //updating fields for useful information
                loc_Ip_Port.setText(new IpFetcher().loc_Ip() + " : " + port);
                public_Ip_Port.setText(new IpFetcher().pub_Ip());

                //Updating status field for Active participants info
                System.out.println("Success, the Server is now listening on the port " + port + ".....");
                CurrStatus.append("Success, the Server is now listening on the port " + port + ".....");

                try
                {
                    //calling the execute method for thread creation
                    execute();
                }
                catch (Exception ex)
                {
                    Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }//GEN-LAST:event_serverStartBtnActionPerformed

    private void activeClientListActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_activeClientListActionPerformed
    {//GEN-HEADEREND:event_activeClientListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_activeClientListActionPerformed

    private void public_Ip_PortMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_public_Ip_PortMouseEntered
    {//GEN-HEADEREND:event_public_Ip_PortMouseEntered
        if (isAlreadyEntered == false)
        {
            isAlreadyEntered = Boolean.TRUE;
            /**
             * @author Codyneeraj Setting below if(2) condition to be true
             * always as above from now on (first entrance of mouse) to utilize
             * the performance improvements by avoiding continuously checking of
             * public IP from external (API of finding IPv4 Address) as
             * mentioned in utilities class, this semantic block will make sure
             * that it should not get executed again and again causing
             * performance overhead and application lagging..
             */
            IpFetcher obj = new IpFetcher();
            obj.setPriority(1);
            obj.start();
            String ip = obj.pub_Ip();
            if (ip.equalsIgnoreCase("Offline"))
            {
                public_Ip_Port.setText("Offline");
            }
            else
            {
                public_Ip_Port.setText(ip + " : " + port);
            }
        }

        if (isAlreadyEntered == true)
        {
            //do nothing if mouse entered next time again from now on
            //(solved the problem of UI hanging if hovered again and again)
        }
    }//GEN-LAST:event_public_Ip_PortMouseEntered

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_refreshBtnActionPerformed
    {//GEN-HEADEREND:event_refreshBtnActionPerformed
        loc_Ip_Port.setText(new IpFetcher().loc_Ip() + " : " + port);
        IpFetcher obj = new IpFetcher();
        obj.start();
        String ip = obj.pub_Ip();
        if (ip.equalsIgnoreCase("Offline"))
        {
            public_Ip_Port.setText("Offline");
        }

        else
        {
            public_Ip_Port.setText(ip + " : " + port);
        }
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void loc_Ip_PortAncestorAdded(javax.swing.event.AncestorEvent evt)//GEN-FIRST:event_loc_Ip_PortAncestorAdded
    {//GEN-HEADEREND:event_loc_Ip_PortAncestorAdded
        loc_Ip_Port.setText(new IpFetcher().loc_Ip());
        IpFetcher obj = new IpFetcher();
        obj.start();
        String ip = obj.pub_Ip();
        if (ip.equalsIgnoreCase("Offline"))
        {
            public_Ip_Port.setText("Offline");
        }

        else
        {
            public_Ip_Port.setText(ip);
        }
    }//GEN-LAST:event_loc_Ip_PortAncestorAdded

    private void serverStopBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_serverStopBtnActionPerformed
    {//GEN-HEADEREND:event_serverStopBtnActionPerformed
        try
        {
            run.interrupt();
            ss.close();
            portField.setEnabled(true);
            serverStartBtn.setEnabled(true);
            serverStatus.setForeground(Color.red);
            serverStatus.setText("Offline");
            serverStopBtn.setEnabled(false);
            System.out.println("ServerSocket Closed Succesfully");
        }
        catch (Exception ex)
        {
            Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
            serverStopBtn.setEnabled(true);
        }
    }//GEN-LAST:event_serverStopBtnActionPerformed

    private void portFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_portFieldActionPerformed
    {//GEN-HEADEREND:event_portFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_portFieldActionPerformed

    private void public_Ip_PortActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_public_Ip_PortActionPerformed
    {//GEN-HEADEREND:event_public_Ip_PortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_public_Ip_PortActionPerformed

    private void loc_Ip_PortActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_loc_Ip_PortActionPerformed
    {//GEN-HEADEREND:event_loc_Ip_PortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loc_Ip_PortActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main (String args[])
    {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            new ServerMain().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea CurrStatus;
    private javax.swing.JComboBox<String> activeClientList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField loc_Ip_Port;
    private javax.swing.JTextField passField;
    private javax.swing.JTextField portField;
    private javax.swing.JLabel portNumber;
    private javax.swing.JTextField public_Ip_Port;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JLabel serverPass;
    private javax.swing.JButton serverStartBtn;
    private javax.swing.JLabel serverStatus;
    private javax.swing.JButton serverStopBtn;
    // End of variables declaration//GEN-END:variables

    private void execute () throws Exception
    {
        //Calling start Method
        Method.setClients(new ArrayList<>());

        /**
         * Code for making new folder named data (will cause the client to freeze if not
         * properly used, as all the data from each other will reside here only !!
         */
        File f = new File("data");//Initialize object to make a new folder named as argument
        f.mkdir();//Execute the above object

        //Failure of creation of above folder in the root path can cause
        //null pointer exception -------!!!
        CurrStatus.setText("Directory named " + f.getPath() + " Created Succesfully");
        /**
         * This above method deletes the old files in the directory named Data(if exists) in
         * the Project's root path or AT the base directory of Main Executable file in a
         * directory named data, and then replaces it with the new Current session's file
         * for keeping a list of data in session for Assessment purposes
         */
        for (File fs : f.listFiles())
        {
            CurrStatus.append("\nDeleting Old  files.... in " + f.getPath() + " directory");
            fs.delete();
            CurrStatus.append("\nDeletion Successfull");
        }
        /**
         * Will Update THe fields and initialize a new Thread (Runnable) for each incoming CLient
         * request by passing it to the this-->Method-->Message-->Client Class.
         * for above details see the Project's Hierarchy.
         */
        run = new Thread(() ->
        {
            try
            {
                Method.setTxt(CurrStatus);
                while (true)
                {
                    new Client(ss.accept());
                }
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(
                        ServerMain.this,
                        "Server Closed forcefully in during mid scanning\nof incoming client requests !!",
                        "Error", JOptionPane.WARNING_MESSAGE);
            }
        });
        run.start();
    }

}
