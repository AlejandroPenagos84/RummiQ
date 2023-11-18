package Launcher;

import Cards.Deck;
import Elements.Client;

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
        Launcher l = new Launcher();
    }
}
