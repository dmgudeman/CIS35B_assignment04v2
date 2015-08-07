

package cis35b_assignment04v2;

/*
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
/*public class Server
{
    static ServerGui serverGui; 
    private static InetAddress ip;
    private static String ipAddress;
    private static String hostname;
    ServerSocket listener;
     ArrayList clientOutputStreams;
    /**
     * Application method to run the server runs in an infinite loop listening
     * on port 9898. When a connection is requested, it spawns a new thread to
     * do the servicing and immediately returns to listening. The server keeps a
     * unique client number for each client that connects just to show
     * interesting logging messages. It is certainly not necessary to do this.
     */
   /* public Server()
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
             new ServerThread(listener.accept()).start();
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

    /**
     * A private thread to handle capitalization requests on a particular
     * socket. The client terminates the dialogue by sending a single line
     * containing only a period.
     */
   /* private static class ServerThread extends Thread
    {

        private Socket socket;

        public ServerThread(Socket socket)
        {
            this.socket = socket;

            System.out.println("IN SERVERTHREADCONSTRUCTOR New connection at " + socket);

        }

        /**
         * Services this thread's client by first sending the client a welcome
         * message then repeatedly reading strings and sending back the
         * capitalized version of the string.
         */
    /*    public void run()
        {
            try
            {
                System.out.println("INSIDE THREAD RUN");

                BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                String line;

                List<String> responseData = new ArrayList<String>();
                System.out.println("In the run method on the server, responseData.size():" + responseData.size());
                while ((line = in.readLine()) != null)
                {
                    responseData.add(line);
                }
                System.out.println("responseData.size() " + responseData.size());
                String s = null;
                for (String l : responseData)
                {
                   serverGui.appendTA_inputContent(l + "\n");
                   System.out.println("THIS FIRED");
                }
            }
            catch (Exception e)
            {
                System.out.println("Error handling client# " + e);
            }
           
        }
*/