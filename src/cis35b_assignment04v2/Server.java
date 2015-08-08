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

    ArrayList clientOutputStreams;
    ArrayList<String> responseData;
    static ServerGui serverGui;
    private static InetAddress ip;
    private static String ipAddress;
    private static String hostname;
    ServerSocket listener;
    Socket clientSocket;
    PrintWriter out;
    BufferedReader reader;

    public Server()
    {
        makeGui();
    }

    public static void main(String[] args) throws Exception
    {
        System.out.println("The server is runninggggg.");
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
            ServerSocket serverSock = new ServerSocket(9898);
            while (true)
            {
                Socket clientSocket = serverSock.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);

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

        Socket sock;

        public ServerThread(Socket clientSocket)
        {
            try
            {
                sock = clientSocket;
                out = new PrintWriter(sock.getOutputStream(), true);
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
            }
            catch (Exception ex)
            {
                System.out.println("Exception in ServerThread constructor in Server ");
                ex.printStackTrace();
            }
        }

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
                System.out.println("Error ServerThread.run() inner loop  " + e);
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

    public void tellEveryone(String message)
    {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        //     System.out.println(message)
        try
        {

            System.out.println("clientoutputstreams sizeeeeeeeeee" + clientOutputStreams.size());
        }
        catch (Exception e)
        {
            System.out.println("IN TELLEVERYONE");
        }

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


/*
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
 */
