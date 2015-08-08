/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis35b_assignment04v2;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author davidgudeman
 */
public class ClientGui extends javax.swing.JFrame
{
    private static BufferedReader reader;
    private static FileInputStream fileInputStream;
    public static PrintWriter writer;
    private static OutputStream outputStream;

    public static final int PORT = 9898;
    public static final int BUFFER_SIZE = 100;
    public static String FILE_TO_SEND;
    public static Socket sock;
    public static Socket sock1;
    String message;
    

    
    

    /**
     * Creates new form ClientGuiWrapper
     */
    public ClientGui()
    {
        try
        {
             
      //  connectToServer();
    //    Socket sock = client.getSocket();
     //   InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
     //   reader = new BufferedReader(streamReader);
        
        setUpNetworking2();
        
        initComponents();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e); 
        }
            
    }

    private void setUpNetworking()
    {
        try
        {
            sock = new Socket("127.0.01", 9898); 
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
        
            System.out.println("networking established");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }  
            
    }
    
    private void setUpNetworking2()
    {
       try
        {
            sock1 = new Socket("127.0.01", 9898); 
            
            
            writer = new PrintWriter(sock1.getOutputStream());
            System.out.println("networking established2");
            
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }   
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA_inputContent = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TA_outputContent = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        chooseFileButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TF_inputFilename = new javax.swing.JTextField();
        sendFileButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        TA_inputContent.setBackground(new java.awt.Color(255, 255, 100));
        TA_inputContent.setColumns(20);
        TA_inputContent.setRows(5);
        TA_inputContent.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 102), null));
        jScrollPane1.setViewportView(TA_inputContent);

        TA_outputContent.setBackground(new java.awt.Color(255, 255, 100));
        TA_outputContent.setColumns(20);
        TA_outputContent.setRows(5);
        TA_outputContent.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 51), null));
        jScrollPane2.setViewportView(TA_outputContent);

        jLabel1.setFont(new java.awt.Font("Imprint MT Shadow", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 100));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CLIENT");

        chooseFileButton.setBackground(new java.awt.Color(0, 0, 0));
        chooseFileButton.setFont(new java.awt.Font("Iowan Old Style", 0, 13)); // NOI18N
        chooseFileButton.setForeground(new java.awt.Color(0, 102, 51));
        chooseFileButton.setText("Choose File");
        chooseFileButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                chooseFileButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Iowan Old Style", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 100));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Input Filename");

        TF_inputFilename.setBackground(new java.awt.Color(255, 255, 100));
        TF_inputFilename.setFont(new java.awt.Font("Lucida Grande", 0, 8)); // NOI18N
        TF_inputFilename.setForeground(new java.awt.Color(0, 102, 51));
        TF_inputFilename.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 102), null));

        sendFileButton.setBackground(new java.awt.Color(0, 0, 0));
        sendFileButton.setFont(new java.awt.Font("Iowan Old Style", 0, 13)); // NOI18N
        sendFileButton.setForeground(new java.awt.Color(0, 102, 51));
        sendFileButton.setText("Send File");
        sendFileButton.setMaximumSize(new java.awt.Dimension(113, 29));
        sendFileButton.setMinimumSize(new java.awt.Dimension(113, 29));
        sendFileButton.setPreferredSize(new java.awt.Dimension(113, 29));
        sendFileButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                sendFileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(chooseFileButton)
                        .addComponent(jScrollPane2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(TF_inputFilename)))
                    .addComponent(sendFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chooseFileButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TF_inputFilename, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sendFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseFileButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_chooseFileButtonActionPerformed
    {//GEN-HEADEREND:event_chooseFileButtonActionPerformed
        JFileChooser chooser = new JFileChooser("/Users/davidgudeman/Documents/workspace/CIS35B_assignment04Deux/src/XMLConverter");
       chooser.showOpenDialog(null);
       File f = chooser.getSelectedFile();
       String filename = f.getAbsolutePath();
        TF_inputFilename.setText(filename);
       //  message = "1997,Ford E350, ac-1, abs dsc moon-a2, 3000.00 \n" +
       // "1997,Ford E350, ac-1, abs dsc moon-a2, 3000.00 \n" +
       // "1997,Ford E350, ac-1, abs dsc moon-a2, 3000.00 \n";

        try
        {
            FileReader reader = new FileReader(filename);
            BufferedReader br = new BufferedReader(reader);
            TA_inputContent.read(br, null);
           br.close();
            TA_inputContent.requestFocus();
            //TA_inputContent.setText();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_chooseFileButtonActionPerformed

    private void sendFileButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_sendFileButtonActionPerformed
    {//GEN-HEADEREND:event_sendFileButtonActionPerformed
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                 //   PrintWriter out = new PrintWriter(client.getSocket().getOutputStream(), true);
                    writer.println(TA_inputContent.getText());
                    System.out.println("TA_inputContent.getText() " + TA_inputContent.getText());
                    writer.close();
                    setUpNetworking();
                    Thread readerThread = new Thread(new IncomingReader());
                    readerThread.start();
                }
                catch (Exception e)
                {
                    System.out.println("sendbutton CLientGui");
                    System.out.println(e);
                }
            }
        });
    }//GEN-LAST:event_sendFileButtonActionPerformed
  

    /**
     * @param args the command line arguments
     */
    /*   public static void main(String args[])
     {
        
     new ClientGui().start();
     /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    /*      try
     {
     for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
     {
     if ("Nimbus".equals(info.getName()))
     {
     javax.swing.UIManager.setLookAndFeel(info.getClassName());
     break;
     }
     }
     }
     catch (ClassNotFoundException ex)
     {
     java.util.logging.Logger.getLogger(ClientGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     }
     catch (InstantiationException ex)
     {
     java.util.logging.Logger.getLogger(ClientGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     }
     catch (IllegalAccessException ex)
     {
     java.util.logging.Logger.getLogger(ClientGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     }
     catch (javax.swing.UnsupportedLookAndFeelException ex)
     {
     java.util.logging.Logger.getLogger(ClientGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     }
     //</editor-fold>
     //</editor-fold>

     /* Create and display the form */
    /*      java.awt.EventQueue.invokeLater(new Runnable()
     {
     public void run()
     {
     this.setVisible(true);
     }
     });
     }
     */
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

    public void appendTA_outputContentText(String s)
    {
        this.TA_outputContent.append(s);
    }
  /*  public void connectToServer() throws IOException {
       // Thread thread = Thread.currentThread();
       
        socket = new Socket("localhost", PORT);
        reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("CTSClient SwingUtilities.isEventDispatchThread(): " + SwingUtilities.isEventDispatchThread());
       // System.out.println("RunnableJob is being run by " + thread.getName() + " (" + thread.getId() + ")");
        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();
        }
    public void go()
    {
        
    }
    */
    
    public class IncomingReader implements Runnable 
    {
        public void run()
        {
            String text;
            try
            {
                while ((text = reader.readLine()) != null)
                {
                    System.out.println("read " + text);
                    TA_outputContent.append(text + "\n");
                }
            } catch (Exception e) {
                System.out.println("IncomingReader exception Client class");
                e.printStackTrace();
            }
        }
            
    }
        
    
    static public void getIPHostname() {
            InetAddress ip;
            String hostname;
            try {
                ip = InetAddress.getLocalHost();
                hostname = ip.getHostName();
                System.out.println("Your current IP address : " + ip);
                System.out.println("Your current Hostname : " + hostname);
            } catch (UnknownHostException e) {
                System.out.println("getIPhostName CLient class");
                e.printStackTrace();
            }
        }
     
    public static void main(String[] args) throws Exception {
        ClientGui clientGui = new ClientGui();
       clientGui.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TA_inputContent;
    private javax.swing.JTextArea TA_outputContent;
    private javax.swing.JTextField TF_inputFilename;
    private javax.swing.JButton chooseFileButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton sendFileButton;
    // End of variables declaration//GEN-END:variables
}
