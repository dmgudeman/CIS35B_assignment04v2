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

    private static BufferedReader reader;
    private static FileInputStream fileInputStream;
    public static PrintWriter out;
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
            System.out.println(" Client constructor, no connection");
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
    public void connectToServer() throws IOException {
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
    
    public class IncomingReader implements Runnable 
    {
        public void run()
        {
            String message;
            try
            {
                while ((message = reader.readLine()) != null)
                {
                    System.out.println("read " + message);
                    clientGui.appendTA_outputContentText(message + "\n");
                }
            } catch (Exception e) {
                System.out.println("IncomingReader exception Client class");
                e.printStackTrace();
            }
        }
            
    }
        
    public static Socket getSocket()
    {
        return socket;
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
    
    /**
     * Runs the client application.
     */
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.go();

       

    }
}