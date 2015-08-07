package cis35b_assignment04v2;


import java.io.*;
import java.net.Socket;

import javax.swing.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple Swing-based client for the capitalization server.
 * It has a main frame window with a text field for entering
 * strings and a textarea to see the results of capitalizing
 * them.
 */
public class Client {

    private static BufferedReader in;
    private static FileInputStream fileInputStream;

    private static PrintWriter out;
    private static OutputStream outputStream;

    public static final int PORT = 9898;
    public static final int BUFFER_SIZE = 100;
    public static String FILE_TO_SEND;
    public static Socket socket;
    ClientGui clientGui;

    public Client()
    {
        try
        {
            this.connectToServer();
        }
        catch (Exception e)
        {     
            System.out.println("no connection");
            }
        new ClientGui(this).setVisible(true);
    }

    /**
     * Implements the connection logic by prompting the end user for
     * the server's IP address, connecting, setting up streams, and
     * consuming the welcome messages from the server.  The Capitalizer
     * protocol says that the server sends three lines of text to the
     * client immediately after establishing a connection.
     */
    public static void connectToServer() throws IOException {
        
      //  Thread thread = Thread.currentThread();
          Thread thread = new Thread();
        // Get the server address from a dialog box.
       // String serverAddress = clientGui.TF_inputFilename.getText();

        // Make connection and initialize streams
        socket = new Socket("localhost", PORT);
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
      //  out = new PrintWriter(socket.getOutputStream(), true);
     //   System.out.println("CTSClient SwingUtilities.isEventDispatchThread(): " + SwingUtilities.isEventDispatchThread());
     //   System.out.println("RunnableJob is being run by " + thread.getName() + " (" + thread.getId() + ")");
        }
    public static Socket getSocket()
    {
        return socket;
    }
    
  
    /**
     * Runs the client application.
     */
    public static void main(String[] args) throws Exception {
        Client client = new Client();

       

    }
}