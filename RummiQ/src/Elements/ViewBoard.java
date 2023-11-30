package Elements;

import Cards.Card;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Cards.Deck;
import Player.Player;
import java.util.ArrayList;
import javax.swing.JButton;

public class ViewBoard extends javax.swing.JPanel
{
    private final Color primColor = new Color(247, 249, 249); // no se deberia cambiar 175, 96, 26 
    private final Color secColor = new Color(45, 85, 69); // 235, 152, 78 192, 57, 43

    private Cell panelsBoard[][];
    private Cell panelsContainer[][];
    private Deck deck = Deck.getInstance();

    protected CardLabel playerDeck[][];
    private CardLabel boardLabel[][];

    private BoardLogicController controller;

    public final int widthBoard = 845,
        heightBoard = 696,
        widthC = 585,
        heightC = 435;

    public JButton buttonEndGame;
    public JButton buttonRequestCard;

    //ArrayList<Integer> insertions = new ArrayList<Integer>();
    public int IDSBoard[][];
    public int IDSPlayerDeck[][];

    private JLabel cartaMover;

    public ViewBoard(int[][] state, Player player) {
        // Inyeccion de Dependencias

        // Inicializacion de las matrices
        this.panelsBoard = new Cell[8][13];
        this.panelsContainer = new Cell[5][9];
        this.playerDeck = new CardLabel[5][9];
        this.boardLabel = new CardLabel[8][13];

        setLayout(null);
        setPreferredSize(new java.awt.Dimension(1600, 800));
        setBackground(new Color(209, 209, 209));

        this.buttonEndGame = new JButton();
        this.buttonEndGame.setText("Finalizar Jugada");
        this.buttonEndGame.setBounds(1000, 500, 150, 30);

        this.add(buttonEndGame);

        this.IDSBoard = state;
        this.IDSPlayerDeck = new int[5][9];

        this.buttonRequestCard = new JButton();
        this.buttonRequestCard.setText("Pedir Carta");
        this.buttonRequestCard.setBounds(1200, 500, 150, 30);
        this.add(buttonRequestCard);

        initCards(player);
        initBoard();
        addListeners();
        initContainer();
        IDPlayerDeck();
        System.out.println("ViewBoard()");
    }

    /**
     * Se inicializa el tablero con los paneles
     */
    public void initBoard() {
        //Metodo que posicionaran la matriz
        // Comienzan ambos en (20,20)
        // Width ancho - Horizontal
        // Heigth alto - Vertical
        int auxW = 20;
        int auxH = 20;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 13; col++) {
                boardLabel[row][col] = new CardLabel();
                boardLabel[row][col].setSize(widthBoard / 13, heightBoard / 8);
                boardLabel[row][col].setIcon(new ImageIcon(getClass().getResource("/Sprites/Transparent.png")));
                boardLabel[row][col].setLocation(auxW, auxH);
                this.add(boardLabel[row][col]);
                auxW += widthBoard / 13;
            }
            auxW = 20;
            auxH += heightBoard / 8;
        }

        System.out.println("ViewBoard.initBoard() a");
        auxH = 20;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 13; col++) {
                panelsBoard[row][col] = new Cell(IDSBoard[row][col]);
                panelsBoard[row][col].setSize(widthBoard / 13, heightBoard / 8);
                panelsBoard[row][col].setLocation(auxW, auxH);

                auxW += widthBoard / 13;
                this.add(panelsBoard[row][col]);
            }
            auxW = 20;
            auxH += heightBoard / 8;
        }

        System.out.println("ViewBoard.initBoard() b");

        paintBoard();
    }

    /**
     * Se pinta el tablero
     */
    private void paintBoard() { // pintamos normal
        for (int col = 0; col < 13; col++) {
            for (int row = 0; row < 8; row++) {
                // PINTAR CON PATRON DE MESA DE AJEDREZ
                panelsBoard[row][col].setBackground((row + col) % 2 == 0 ? primColor : secColor);

                // PINTAR CON PATRON UNIFORME
                //panelsBoard[row][col].setBackground(secColor);
            }
        }
    }

    private void initContainer() {
        int auxW = 900;
        int auxH = 20;

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 9; col++) {
                panelsContainer[row][col] = new Cell(IDSPlayerDeck[row][col]);
                panelsContainer[row][col].setSize(widthC / 9, heightC / 5);
                panelsContainer[row][col].setLocation(auxW, auxH);
                this.add(panelsContainer[row][col]);
                auxW += widthC / 9;
            }
            auxW = 900;
            auxH += heightC / 5;
        }
        paintContainer();
        System.out.println("initContainer()");
    }

    private void paintContainer() { // pintamos normal
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 5; row++) {
                panelsContainer[row][col].setBackground(new Color(0, 0, 0));
            }
        }
    }

    /**
     * Aqui se inicia el label de Cartas
     */
    private void initCards(Player player) {
        //Metodo que posicionaran la matriz
        // Comienzan ambos en (20,20)
        // Width ancho - Horizontal
        // Heigth alto - Vertical
        int auxW = 900;
        int auxH = 20;
        int id = 0;

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 9; col++, ++id) {
                playerDeck[row][col] = new CardLabel(player.getCardInPos(id));
                playerDeck[row][col].setSize(widthC / 9, heightC / 5);
                playerDeck[row][col].setIcon(new ImageIcon(getClass()
                    .getResource("/Sprites/" + player.cardPicInPos(id)))
                );
                playerDeck[row][col].setLocation(auxW, auxH);
                this.add(playerDeck[row][col]);
                auxW += widthC / 9;
            }
            auxW = 900;
            auxH += heightC / 5;
        }
    }

    private void addListeners() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 9; col++) {
                if (playerDeck[row][col] != null) {
                    playerDeck[row][col].addMouseListener(getControl());
                    playerDeck[row][col].addMouseMotionListener(getControl());
                    if (playerDeck[row][col].getIcon().toString().contains("Transparent.png")) {
                        playerDeck[row][col].removeMouseListener(getControl());
                        playerDeck[row][col].removeMouseMotionListener(getControl());
                    }
                }
            }
        }
        buttonEndGame.addActionListener(getControl());
        buttonRequestCard.addActionListener(getControl());
        this.addMouseListener(getControl());

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 13; col++) {
                boardLabel[row][col].addMouseListener(getControl());
                boardLabel[row][col].addMouseMotionListener(getControl());
            }
        }
        System.out.println("addListeners()");
    }

    public BoardLogicController getControl() {
        if (controller == null) {
            controller = new BoardLogicController(this);
        }
        return controller;
    }

    private void IDPlayerDeck() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 9; col++) {
                IDSPlayerDeck[row][col] = playerDeck[row][col].getId();
            }
        }
    }

    /*
    public void UpdateListeners() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 9; col++) {
                if (playerDeck[row][col] != null) {
                    if (playerDeck[row][col].getIcon().toString().contains("Transparent.png")) {
                        playerDeck[row][col].removeMouseListener(getControl());
                        playerDeck[row][col].removeMouseMotionListener(getControl());
                    } else {
                        playerDeck[row][col].addMouseListener(getControl());
                        playerDeck[row][col].addMouseMotionListener(getControl());
                    }
                }
            }
        }

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 13; col++) {
                if (boardLabel[row][col] != null) {
                    if (boardLabel[row][col].getIcon().toString().contains("Transparent.png")) {
                        boardLabel[row][col].removeMouseListener(getControl());
                        boardLabel[row][col].removeMouseMotionListener(getControl());
                    } else {
                        boardLabel[row][col].addMouseListener(getControl());
                        boardLabel[row][col].addMouseMotionListener(getControl());
                    }
                }
            }
        }
    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public JLabel[][] getPlayerDeck() {
        return playerDeck;
    }

    public JLabel[][] getBoardLabel() {
        return boardLabel;
    }

    public Cell[][] getBoard() {
        return panelsBoard;
    }

    public Cell[][] getPanelsPlayerDeck() {
        return panelsContainer;
    }

    public void UpdateState(ArrayList<Integer> playerCards, int[][] board) {
        IDSBoard = board;
        ArrayList<Card> nonNull = new ArrayList<Card>();

        for (int row = 0, idx = 0; row < 5; ++row) {
            for (int col = 0; col < 9 && idx < playerCards.size(); ++col, ++idx) {
                IDSPlayerDeck[row][col] = playerCards.get(idx);
            }
        }

        for (int row = 0; row < 8; ++row) {
            for (int col = 0; col < 13; ++col) {
                if (board[row][col] != 0) {
                    nonNull.add(deck.card(board[row][col]));
                }
            }
        }
    }

    
    
    /*
    private void UpdateSingleCard(JLabel card, int row, int col, boolean option) {
        int auxAncho = widthBoard / 13;// Debido a que tanto el board como el deck miden lo mismo, se puede usar esta misma variable
        int auxLargo = heightBoard / 8;//

        if (option) {
            card.setLocation((auxAncho * col - 10) + (auxAncho / 2), (auxLargo * row - 25) + (auxLargo / 2));
        } else {
            card.setLocation(900 + (auxAncho * col - 32) + (auxAncho / 2), (auxLargo * row - 25) + (auxLargo / 2));
        }
    }*/

    public void UpdateInterface() {
        // Actualizar Tablero
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 13; col++) {
                if (panelsBoard[row][col].id != IDSBoard[row][col]) {
                    //UpdateSingleCard(playerDeck[row][col], row, col, true);
                    panelsBoard[row][col].id = IDSBoard[row][col];
                }

            }
        }

        //Actualizar Matriz jugador
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 13; col++) {
                if (panelsContainer[row][col].id != IDSPlayerDeck[row][col]) {
                    //UpdateSingleCard(boardLabel[row][col], row, col, false);
                    panelsContainer[row][col].id = IDSPlayerDeck[row][col];
                }
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
