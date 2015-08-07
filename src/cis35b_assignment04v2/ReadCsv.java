/*

package cis35b_assignment04v2;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/*
 c class ReadCsv
{

    Server server = new Server();

    public ReadCsv(Server server)
    {
        this.server = server;
    }

    public void readCsv()
    {
        String line = "";

        try
        {

            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            List<String> responseData = new ArrayList<String>();
            while ((line = in.readLine()) != null)
            {
                responseData.add(line);
            }
            System.out.println("responseData.size() " + responseData.size());
            String s = null;
            for (String l : responseData)
            {
                s = serverGui.getTA_inputContentText();
                s = s + 1;
                System.out.println(l);
                System.out.println("THIS FIRED");
            }
            serverGui.setTA_inputContentText(s);

        }
        catch (IOException e)
        {
            System.out.println("ERROR");
        }
        finally
        {
            try
            {
                server.getSocket.close();
            }
            catch (IOException e)
            {
                log("Couldn't close a socket, what's going on?");
            }
            log("Connection with client# " + " closed");
        }
    }

    public void convertXML()
    {
        try
        {
            String[] words;
            String[] lines = new String[9];
            String[][] master = new String[9][5];
            String str = null;
            System.out.println("lines.length " + lines.length);
            lines = (serverGui.getTA_inputContentText().split("\n"));
            System.out.println("lines.length " + lines.length);
            for (int j = 0; j < lines.length; j++)
            {
                words = (lines[j].split(","));
                master[j] = words;
            }

            for (int i = 0; i < master.length; i++)
            {
                String s = ("<car>" + "\n\t<year>" + master[i][0] + "</year>\n\t<make>"
                    + master[i][1] + "</make>\n\t<model>" + master[i][2] + "</model>\n\t<description>"
                    + master[i][3] + "</description>\n\t<price>" + master[i][4] + "</price>\n</car>\n");
                str = str + s;
            }
            serverGui.setTA_outputContentText(str);
            System.out.println(str);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    */
    /**
     * Logs a simple message. In this case we just write the message to the
     * server applications standard output.
     */
 /*   private void log(String message)
    {
        System.out.println(message);
    }
}
*/
