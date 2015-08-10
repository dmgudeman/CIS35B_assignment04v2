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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * This creates the client GUI and provides the business logic for it.
 * @author davidgudeman
 */
public class Client extends javax.swing.JFrame
{
 //  public static void main(String[] args) throws Exception
 //  {
//      Client clientGui = new Client();
 //      clientGui.setVisible(true);
//    }

    private BufferedReader reader;
    private static FileInputStream fileInputStream;
    public  PrintWriter writer;
    private OutputStream outputStream;
    public static final int PORT = 9898;
    public static Socket sock;
    public static Socket sock2;

    public Client()
    {
        try
        { 
            initComponents();
         //    this.setUpNetworking2();
           
            
        }
        catch (Exception e)
        {
            System.out.println("Exception in Client constructor");
            e.printStackTrace();
        }
    }

    public void setUpNetworking()
    {
        try
        {
            sock = new Socket("127.0.01", PORT);
            InputStreamReader streamReader
                = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            System.out.println("networking established");
            Thread readerThread = new Thread(new IncomingReader());
                   readerThread.start();
        }
        catch (IOException ex)
        {
            System.out.println("IOException in Client setUpNetworking");
            ex.printStackTrace();
        }
    }

    public void setUpNetworking2()
    {
        try
        {
            sock2 = new Socket("127.0.01", PORT);
            writer = new PrintWriter(sock2.getOutputStream());
            System.out.println("networking established2");
        }
        catch (IOException ex)
        {
            System.out.println("IOException in Client setUpNetworking2");
            ex.printStackTrace();
        }
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

    /**
     * Button activates the chooser pattern to allow the user to choose
     * which file they want to convert. A explorer like GUI is generated 
     */
    private void chooseFileButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_chooseFileButtonActionPerformed
    {//GEN-HEADEREND:event_chooseFileButtonActionPerformed
        JFileChooser chooser = new JFileChooser(
            "/Users/davidgudeman/NetBeansProjects/CIS35B_assignment04v2/"
                + "src/cis35b_assignment04v2/");
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        TF_inputFilename.setText(filename);
        try
        {
            FileReader reader = new FileReader(filename);
            BufferedReader br = new BufferedReader(reader);
            TA_inputContent.read(br, null);
            br.close();
            TA_inputContent.requestFocus();
        }
        catch (Exception e)
        {
            System.out.println("Exception in Client Choose Button");
             e.printStackTrace();
        }
    }//GEN-LAST:event_chooseFileButtonActionPerformed
    /**
     * The send file button sends the text from the Input text area to 
     * the server's Input text area
     */
    private void sendFileButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_sendFileButtonActionPerformed
    {//GEN-HEADEREND:event_sendFileButtonActionPerformed
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    setUpNetworking2();
                    writer.println(TA_inputContent.getText());
                    writer.close();
                  
                   
                }
                catch (Exception e)
                {
                    System.out.println("Exception Client send button");
                    e.printStackTrace();
                }
            }
        });
    }//GEN-LAST:event_sendFileButtonActionPerformed

    /**
     * This method runs the thread uses a BufferedReader "reader" to
     * accept the input from the server. It appends it to the text in
     * the outputContent text area
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
                    TA_outputContent.append(text + "\n");
                }
                
            }
            catch (Exception e)
            {
                System.out.println("Exception in Client IncomingReader ");
                e.printStackTrace();
            }
            
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

    public void appendTA_outputContentText(String s)
    {
        this.TA_outputContent.append(s);
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
