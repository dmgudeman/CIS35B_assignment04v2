/**
 * CIS35B assignment 04
 * DeAnza College
 * Professor Grant Larkin
 * 
 * August 7, 2015
 * Author: David M Gudeman
 * 
 * Project:
 * A server/client dyad. The client chooses a comma delimited file, sends it
 * to the server.  The server converts it to XML and sends it back. The program
 * uses ports, GUI and multiple threads.
 */

package cis35b_assignment04v2;

import java.awt.EventQueue;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * The server GUI
 * @author davidmgudeman
 */

public class ServerGui extends javax.swing.JFrame
{
    public static void main(String args[])
    {
        Server server = new Server();
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ServerGui(server).setVisible(true);
            }
        });
    }
    
    Server server;

    // constructor
    public ServerGui(Server server)
    {
        this.server = server;
        initComponents();
        setIPHostname();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA_inputContent = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TA_outputContent = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        JL_status = new javax.swing.JLabel();
        TF_ipAddress = new javax.swing.JTextField();
        TF_hostname = new javax.swing.JTextField();
        TF_port = new javax.swing.JTextField();
        TF_status = new javax.swing.JTextField();
        JL_port = new javax.swing.JLabel();
        JL_hostname = new javax.swing.JLabel();
        JL_ipAddress = new javax.swing.JLabel();
        JB_sendButton = new javax.swing.JButton();
        JB_convertButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        TA_inputContent.setBackground(new java.awt.Color(255, 204, 51));
        TA_inputContent.setColumns(20);
        TA_inputContent.setRows(5);
        TA_inputContent.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 102), null));
        jScrollPane1.setViewportView(TA_inputContent);

        TA_outputContent.setBackground(new java.awt.Color(255, 204, 51));
        TA_outputContent.setColumns(20);
        TA_outputContent.setRows(5);
        TA_outputContent.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 51), null));
        jScrollPane2.setViewportView(TA_outputContent);

        jLabel1.setFont(new java.awt.Font("Imprint MT Shadow", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SERVER");

        JL_status.setFont(new java.awt.Font("Iowan Old Style", 1, 13)); // NOI18N
        JL_status.setForeground(new java.awt.Color(255, 204, 51));
        JL_status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_status.setText("Server Status");

        TF_ipAddress.setBackground(new java.awt.Color(255, 204, 51));
        TF_ipAddress.setForeground(new java.awt.Color(0, 102, 51));
        TF_ipAddress.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 102), null));

        TF_hostname.setBackground(new java.awt.Color(255, 204, 51));
        TF_hostname.setForeground(new java.awt.Color(0, 102, 51));
        TF_hostname.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 102), null));

        TF_port.setBackground(new java.awt.Color(255, 204, 51));
        TF_port.setForeground(new java.awt.Color(0, 102, 51));
        TF_port.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 102), null));

        TF_status.setBackground(new java.awt.Color(255, 204, 51));
        TF_status.setForeground(new java.awt.Color(0, 102, 51));
        TF_status.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 102), null));

        JL_port.setFont(new java.awt.Font("Iowan Old Style", 1, 13)); // NOI18N
        JL_port.setForeground(new java.awt.Color(255, 204, 51));
        JL_port.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_port.setText("Port");

        JL_hostname.setFont(new java.awt.Font("Iowan Old Style", 1, 13)); // NOI18N
        JL_hostname.setForeground(new java.awt.Color(255, 204, 51));
        JL_hostname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_hostname.setText("Hostname");

        JL_ipAddress.setFont(new java.awt.Font("Iowan Old Style", 1, 13)); // NOI18N
        JL_ipAddress.setForeground(new java.awt.Color(255, 204, 51));
        JL_ipAddress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_ipAddress.setText("ip Address");

        JB_sendButton.setBackground(new java.awt.Color(0, 0, 0));
        JB_sendButton.setFont(new java.awt.Font("Iowan Old Style", 0, 13)); // NOI18N
        JB_sendButton.setForeground(new java.awt.Color(0, 153, 204));
        JB_sendButton.setText("Send File");
        JB_sendButton.setMaximumSize(new java.awt.Dimension(113, 29));
        JB_sendButton.setMinimumSize(new java.awt.Dimension(113, 29));
        JB_sendButton.setPreferredSize(new java.awt.Dimension(113, 29));
        JB_sendButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                JB_sendButtonActionPerformed(evt);
            }
        });

        JB_convertButton.setBackground(new java.awt.Color(0, 0, 0));
        JB_convertButton.setFont(new java.awt.Font("Iowan Old Style", 0, 13)); // NOI18N
        JB_convertButton.setForeground(new java.awt.Color(0, 153, 204));
        JB_convertButton.setLabel("Convert");
        JB_convertButton.setMaximumSize(new java.awt.Dimension(113, 29));
        JB_convertButton.setMinimumSize(new java.awt.Dimension(113, 29));
        JB_convertButton.setPreferredSize(new java.awt.Dimension(113, 29));
        JB_convertButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                JB_convertButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JB_sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_convertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JL_status, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JL_port, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JL_hostname, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JL_ipAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TF_hostname, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TF_port, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TF_status)
                                .addComponent(TF_ipAddress, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_status)
                    .addComponent(TF_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_port, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_hostname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_hostname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_ipAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_ipAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JB_convertButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JB_sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Convert button
    private void JB_convertButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_JB_convertButtonActionPerformed
    {//GEN-HEADEREND:event_JB_convertButtonActionPerformed
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                convertXML();
            }
        });
    }//GEN-LAST:event_JB_convertButtonActionPerformed

    // send button
    private void JB_sendButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_JB_sendButtonActionPerformed
    {//GEN-HEADEREND:event_JB_sendButtonActionPerformed
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                String message;
                try
                {
                    message = TA_outputContent.getText();
                    server.sendToClient(message);
                }
                catch (Exception ex)
                {
                    System.out.println("EXCEPTION SERVERGUI SEND BUTTOn");
                    ex.printStackTrace();
                }
            }
        });
    }//GEN-LAST:event_JB_sendButtonActionPerformed

    /**
     * This converts comma limited text into XML. I spent so much time on 
     * the graphics (a 2 day grudgematch with GridBagLayout that was verily 
     * futile, before switching to netBeans IDE) and threading issues, I did npt 
     * have time to use a XML parsing strategy. Hence I wrote this little thing.
     */
    public void convertXML()
    {
        try
        {
            String[] words;
            String[] lines = new String[9];
            String[][] master = new String[9][5];
            String str = "";
            System.out.println("lines.length " + lines.length);
            lines = (this.getTA_inputContentText().split("\n"));
            System.out.println("lines.length " + lines.length);
            for (int j = 0; j < lines.length; j++)
            {
                words = (lines[j].split(","));
                master[j] = words;
            }

            for (int i = 0; i < master.length; i++)
            {
                String s = ("<car>" + "\n\t<year>" + master[i][0] 
                    + "</year>\n\t<make>" + master[i][1] 
                    + "</make>\n\t<model>" + master[i][2] 
                    + "</model>\n\t<description>"
                    + master[i][3] + "</description>\n\t<price>" 
                    + master[i][4] + "</price>\n</car>\n");
                str = str + s;
            }
            this.setTA_outputContentText(str);
            System.out.println(str);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setIPHostname()
    {
        InetAddress ip;
        String hostname;
        int port;
        String status = "Server is running";
        try
        {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            port = server.PORT;
            TF_status.setText(status);
            TF_ipAddress.setText(ip.toString());
            TF_port.setText("" + port);
            TF_hostname.setText(hostname);

            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
    }
    
    // getters and setters
    public String getTA_inputContentText()
    {
        return this.TA_inputContent.getText();
    }

    public void setTA_inputContentText(String s)
    {
        this.TA_inputContent.setText(s);
    }

    public String getTA_outputContentText()
    {
        return this.TA_outputContent.getText();
    }

    public void setTA_outputContentText(String s)
    {
        this.TA_outputContent.setText(s);
    }

    public String getTF_statusText()
    {
        return this.TF_status.getText();
    }

    public void setTF_statusText(String s)
    {
        this.TF_status.setText(s);
    }

    public String getTF_portText()
    {
        return this.TF_port.getText();
    }

    public void setTF_portText(String s)
    {
        this.TF_port.setText(s);
    }

    public String getTF_hostnameText()
    {
        return this.TF_hostname.getText();
    }

    public void setTF_hostnameText(String s)
    {
        this.TF_hostname.setText(s);
    }

    public String getTF_ipAdressText()
    {
        return this.TF_ipAddress.getText();
    }

    public void setTF_ipAddressText(String s)
    {
        this.TF_ipAddress.setText(s);
    }

    public void appendTA_inputContent(String s)
    {
        this.TA_inputContent.append(s);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_convertButton;
    private javax.swing.JButton JB_sendButton;
    private javax.swing.JLabel JL_hostname;
    private javax.swing.JLabel JL_ipAddress;
    private javax.swing.JLabel JL_port;
    private javax.swing.JLabel JL_status;
    private javax.swing.JTextArea TA_inputContent;
    private javax.swing.JTextArea TA_outputContent;
    private javax.swing.JTextField TF_hostname;
    private javax.swing.JTextField TF_ipAddress;
    private javax.swing.JTextField TF_port;
    private javax.swing.JTextField TF_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
