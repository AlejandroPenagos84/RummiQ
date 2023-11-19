package Board;

import Cards.Card;
import Cards.CardSet.CardSet;
import Cards.CardSetCreator.CardSetCreator;
import Cards.Deck;
import Elements.Client;
import java.util.ArrayList;

public class Board
{

    private Client client;
    private Deck mainDeck = Deck.getInstance();
    private Card[][] boardCards = new Card[8][13]; // Creo la Matriz De Las Cartas
    //private HashMap<Position, Integer> boardState;
    private static Board instance;
    private int[][] playerDeckID; // Cambiado de deckID a playerDeckID
    private int[][] boardID;


    public static Board getBoard() {
        if (instance == null) {
            instance = new Board();
            instance.initCards();
        }
        return instance;
    }

    private void initCards() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 13; col++) {
                boardCards[row][col] = Card.nullcard; // Inicializando el
            }					// tablero explicitamente con cartas nulas.
        }
    }

    public boolean validState(int[][] boardState) // Dado un estado de la mesa
    // (esto es, una matriz con identificadores de cartas), el metodo
    // determina si todas las jugadas sobre la mesa son validas.
    {
        for (int row = 0; row < 8; ++row) {
            ArrayList<Card> testSequence = new ArrayList<>(); // Oliver:
            // testSequence es una secuencia de cartas no nulas que se
            // construye dentro del proximo for-loop

            for (int col = 0; col < 13; ++col) {
                if (boardState[row][col] != 0) {
                    testSequence.add(mainDeck.card(boardState[row][col]));

                    if (boardState[row][col + 1] == 0) {
                        CardSet testSet = CardSetCreator
                                .createCardSet(testSequence); // Oliver:
                        // se usa el CardSetCreator, aplicando a su vez
                        // el factory method, para clasificar el tipo de
                        // jugada que genera 'testSequence'
                        if (testSet.size() == 1) {
                            return false; // Como se
                        }							// definio en el factory method, una lista de
                        // tamaño 1 se entiende como una jugada invalida.
                        testSequence = new ArrayList<>();
                    }
                }
            }
        }

        return true;
    }

    public void setState(int[][] boardState) {
        for (int row = 0; row < 8; ++row) {
            for (int col = 0; col < 13; ++col) {
                boardCards[row][col] = mainDeck.card(boardState[row][col]);
            }
        }
    }


    public int[][] getBoardID() {
        return boardID;
    }

    //Este set
    public void setBoardID(int[][] boardID) {
        this.boardID = boardID;
    }
    
    //Este set
    public void setPlayerDeckID(int[][] playerDeckID) {
        this.playerDeckID = playerDeckID;
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
    
 
}
