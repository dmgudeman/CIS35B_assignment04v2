/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis35b_assignment04v2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author davidgudeman
 */
public class SimpleServer
{
    static ServerGui serverGui; 
    private static InetAddress ip;
    private static String ipAddress;
    private static String hostname;
    ServerSocket listener;
    ArrayList clientOutputStreams;
    List<String> responseData;

 public SimpleServer()
    {
         makeGui();
    }

    private void makeGui()
    {
        try
        {
            
          //  getIPHostname();
            ServerGui serverGui = new ServerGui();
            serverGui.setVisible(true);
            serverGui.setTF_statusText("The server is running.");
            ip = InetAddress.getLocalHost();
            ipAddress = ip.getHostAddress();
            hostname = ip.getHostName();
            serverGui.setTF_portText("" + 9898);
            serverGui.setTF_hostnameText(hostname);
            serverGui.setTF_ipAddressText(ipAddress);
             
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
    public class ClientHandler implements Runnable
    {

        BufferedReader reader;
        Socket sock;

        public ClientHandler(Socket clientSocket)
        {
            try
            {
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);

            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

        public void run()
        {    String line;
            String text = null;
             responseData = new ArrayList<String>();
            try
            {
              //  while ((message = reader.readLine()) != null)
             //   {
             //       System.out.println("read " + message);
            //        tellEveryone(message);
              //  }
                while ((line = reader.readLine()) != null)
                    if (!line.equals(null))
                {
                    serverGui.setTA_inputContentText(line);
                    //responseData.add(line);
                }
                System.out.println("responseData.size() " + responseData.size());
                
                for (int i = 0; i < responseData.size(); i++)
                {
                    System.out.println("responseData.get(i)" + responseData.get(i) + "\n");
                    text = (text + responseData.get(i) + "\n");
                    System.out.println("THIS FIRED");
                    
                }
                System.out.println(text);
                serverGui.setTF_inputContentText(text);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {
        System.out.println("The SIMPLE server is runninggggg.");
      //  SimpleServer server = new SimpleServer();
        new SimpleServer().go();

    }

    public void go()
    {
        clientOutputStreams = new ArrayList();
        try
        {  
            System.out.println("Inside the go method");
            ServerSocket serverSock = new ServerSocket(9898);
            while (true)
            {
                Socket clientSocket = serverSock.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);
                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
                System.out.println("got a connection");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    public void tellEveryone(String message)
    {
        Iterator it = clientOutputStreams.iterator();
        while (it.hasNext())
        {
            try
            {
                PrintWriter writer = (PrintWriter) it.next();
                writer.println(message);
                writer.flush();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        serverGui.setTF_inputContentText(message);
    }
}

/*System.out.println("INSIDE THREAD RUN");

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
*/