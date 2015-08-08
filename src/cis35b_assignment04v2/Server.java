package cis35b_assignment04v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 */
public class Server
{

   
    ArrayList<String> responseData;
    static ServerGui serverGui;
    private static InetAddress ip;
    private static String ipAddress;
    private static String hostname;
    ServerSocket listener;
    Socket clientSocket;
    PrintWriter out;

    /**
     * Application method to run the server runs in an infinite loop listening
     * on port 9898. When a connection is requested, it spawns a new thread to
     * do the servicing and immediately returns to listening. The server keeps a
     * unique client number for each client that connects just to show
     * interesting logging messages. It is certainly not necessary to do this.
     */
    public Server()
    {
        makeGui();
    }

    public static void main(String[] args) throws Exception
    {
        System.out.println("The server is runninggggg.");
        Server server = new Server();
    }

    private void makeGui()
    {
        try
        {
            ServerSocket listener = new ServerSocket(9898);
            getIPHostname();
            serverGui = new ServerGui(this);
            serverGui.setVisible(true);
            serverGui.setTF_statusText("The server is running.");
            ip = InetAddress.getLocalHost();
            ipAddress = ip.getHostAddress();
            hostname = ip.getHostName();
            serverGui.setTF_portText("" + 9898);
            serverGui.setTF_hostnameText(hostname);
            serverGui.setTF_ipAddressText(ipAddress);
            clientSocket = listener.accept();
            new ServerThread(clientSocket).start();
        }
        catch (UnknownHostException e)
        {
            System.out.println("Unknown host in Server.makeGui()");
        }
        catch (IOException io)
        {
            System.out.println("IOException in Server.makeGui()");
        }
    }

    public void go()
    {
        try
        {
            ServerSocket serverSock = new ServerSocket(9898);
            while (true)
            {
                Socket clientSocket = serverSock.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());

                Thread t = new Thread(new ServerThread(clientSocket));
                t.start();
                System.out.println("got a connection thread " + t.getName() + "socket " + t.getId());
            }
        }
        catch (Exception ex)
        {
            System.out.println("Exception in go()in Server ");
            ex.printStackTrace();
        }
    }

    /**
     * A private thread to handle capitalization requests on a particular
     * socket. The client terminates the dialogue by sending a single line
     * containing only a period.
     */
    public class ServerThread extends Thread
    {

        BufferedReader reader;
        Socket sock;

        public ServerThread(Socket clientSocket)
        {
            try
            {
                sock = clientSocket;
                out = new PrintWriter(sock.getOutputStream(), true);

                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
                System.out.println("IN SERVERTHREADCONSTRUCTOR New connection at " + clientSocket);
            }
            catch (Exception ex)
            {
                System.out.println("Exception in ServerThread constructor in Server ");
                ex.printStackTrace();
            }
        }

        /**
         * Services this thread's client by first sending the client a welcome
         * message then repeatedly reading strings and sending back the
         * capitalized version of the string.
         */
        public void run()
        {
            try
            {
                String line;
                responseData = new ArrayList<String>();
                System.out.println("In the run method on the server, responseData.size():" + responseData.size());
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
                    System.out.println("Error ServerThread.run() inner loop  " + e);
                }

            }
            catch (Exception e)
            {
                System.out.println("Error ServerThread.run() outer loop " + e);
            }

        }

        public void writeToServerInputContent(ArrayList<String> list)
        {
            for(int i= 0; i <list.size(); i++)
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

        /**
         * Logs a simple message. In this case we just write the message to the
         * server applications standard output.
         */
        private void log(String message)
        {
            System.out.println(message);
        }
    }

    static public void getIPHostname()
    {
        InetAddress ip;
        String hostname;
        try
        {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
    }
    public Socket getClientSocket()
        {
            return this.clientSocket;
        }

}
