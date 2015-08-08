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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This is the business logic for the server.
 * @author davidmgudeman
 */
public class Server
{
    ArrayList clientOutputStreams;
    ArrayList<String> responseData;
    static ServerGui serverGui;
    private InetAddress ip;
    private String ipAddress;
    private String hostname;
    ServerSocket listener;
    Socket clientSocket;
    PrintWriter out;
    BufferedReader reader;
    int PORT = 9898;

    // constructor
    public Server()
    {
        makeGui();
    }

    //driver
    public static void main(String[] args) throws Exception
    {
        Server server = new Server();
        server.go();
    }

    private void makeGui()
    {
        serverGui = new ServerGui(this);
        serverGui.setVisible(true);
    }

    public void go()
    {
        clientOutputStreams = new ArrayList();
        try
        {
            ServerSocket serverSock = new ServerSocket(PORT);
            while (true)
            {
                Socket clientSocket = serverSock.accept();
                PrintWriter writer
                    = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);

                // mmakes a new thread of the Serverthread class
                Thread t = new Thread(new ServerThread(clientSocket));
                t.start();
                System.out.println("got a connection thread "
                    + t.getName() + "socket " + t.getId());
            }
        }
        catch (Exception ex)
        {
            System.out.println("Exception in go()in Server ");
            ex.printStackTrace();
        }
    }
    /**
     * Inner class to manage multiple thread requests. The threads are
     * managed in an ArrayList "clientOutputStreams". I found this was needed
     * because text does not show up unless you close the stream and closing
     * the stream closes the port. So multiple threads were necessary.
     */
    public class ServerThread extends Thread
    {
        Socket sock;

        public ServerThread(Socket clientSocket)
        {
            try
            {
                sock = clientSocket;
                out = new PrintWriter(sock.getOutputStream(), true);
                InputStreamReader isReader
                    = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
            }
            catch (Exception ex)
            {
                System.out.println("Exception in ServerThread "
                    + "constructor in Server ");
                ex.printStackTrace();
            }
        }

        // runs the ServerThreads
        public void run()
        {
            String line;
            String message;
            responseData = new ArrayList<String>();

            try
            {
                while ((line = reader.readLine()) != null)
                {
                    System.out.println("read " + line);
                    responseData.add(line);
                }
                writeToServerInputContent(responseData);
            }
            catch (Exception e)
            {
                System.out.println("Error ServerThread.run() inner loop  ");
                e.printStackTrace();
            }
        }

        public void writeToServerInputContent(ArrayList<String> list)
        {
            for (int i = 0; i < list.size(); i++)
            {
                try
                {
                    serverGui.appendTA_inputContent(list.get(i) + "\n");
                }
                catch (Exception ex)
                {
                    System.out.println("writeTOServerInputCOntent");
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * This method iterates through an ArrayList of threads to find 
     * a viable one to sent text to the Client.
     * @param message 
     */
    public void sendToClient(String message)
    {
        Iterator it = clientOutputStreams.iterator();

        while (it.hasNext())
        {
            try
            {
                PrintWriter writer = (PrintWriter) it.next();
                writer.println(message);
                writer.close();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
