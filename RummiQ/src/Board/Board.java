package Board;

import Cards.Card;
import Elements.Client;
import java.util.HashMap;

public class Board
{

    private Client client;
    private Card[][] boardCards = new Card[8][13]; // Creo la Matriz De Las Cartas      
    private Card cards;
    private HashMap<Position, Integer> boardState;
    private static Board instance;
    private int[][] playerDeckID; // Cambiado de deckID a playerDeckID
    private int[][] boardID;
    private Position iniPos;
    private Position finalPos;

    private Board(Client c) {
        this.client = c;
        iniPos = null;
        finalPos = null;
    }

    public static Board getBoard(Client c) {
        if (instance == null) {
            instance = new Board(c);
            instance.initCard();
        }
        return instance;
    }

    private void initCard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 13; col++) {
                boardCards[row][col] = Card.nullcard; // Inicializado explícitamente a la carta nula
            }
        }
    }

    public boolean validState(HashMap<Position, Integer> boardState) {
        return false; // TODO: IMPLEMENTAR FUNCIÓN Y ELIMINAR ESTE RETURN
    }

    public class Position
    {

        public final int row;
        public final int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] getBoardID() {
        return boardID;
    }

    public void setBoardID(int[][] boardID) {
        this.boardID = boardID;
    }

    public Position getIniPos() {
        return iniPos;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int[][] getPlayerDeckID() {
        return playerDeckID;
    }

    public void setPlayerDeckID(int[][] playerDeckID) {
        this.playerDeckID = playerDeckID;
    }
}
