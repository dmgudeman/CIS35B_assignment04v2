/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis35b_assignment04v2;

/**
 *
 * @author davidgudeman
 */
public class Main
{
    public static void main(String[] args)
    {
        startServer();
        System.out.println("this made it ");
    }
    
    public static  void startServer()
    {
        Server server = new Server();
       
    }
    
    public static void startClient()
    {
        Client clientGui = new Client();
        clientGui.setVisible(true);
    }
}
