/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Launcher;

import Elements.Client;

/**
 *
 * @author Alejandro Penagos
 */
public class Launcher
{

    private Client client;

    public Launcher() {
        if(client==null){
            client = new Client();
        }
        
        client.init();
    }

    public static void main(String[]args)
    {
        new Launcher();
    }
}
