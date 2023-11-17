package Elements;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewBoard extends javax.swing.JPanel
{

    private final Color uno = new Color(247, 249, 249); // no se deberia cambiar 175, 96, 26 
    private final Color dos = new Color(45, 85, 69); // 235, 152, 78 192, 57, 43

    private Client client;
    private Cells panelsBoard[][];
    private Cells panelsContainer[][];
    private JLabel cards[][];
    private BoardLogicController controller;
    private final int widthBoard, heightBoard, widthC, heightC;
    private int IDSBoard[][];
    private int IDSPlayerDeck[][];

    public ViewBoard(Client c) {
        this.client = c; // Inyeccion de Dependencias

        this.widthBoard = 845;
        this.heightBoard = 696;
        this.widthC = 585;
        this.heightC = 435;

        // Inicializacion de las matrices
        this.panelsBoard = new Cells[8][13];
        this.panelsContainer = new Cells[5][9];
        this.cards = new JLabel[5][9];
        this.IDSBoard = new int[8][13];
        this.IDSPlayerDeck = new int[5][9];

        setLayout(null);
        setPreferredSize(new java.awt.Dimension(1600, 800));
        setBackground(new Color(209,209,209));
        
        initCards();
        addListeners();
        initContainer();
        initBoard();
        initIDS();
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
                panelsBoard[row][col] = new Cells(-1);
                panelsBoard[row][col].setSize(widthBoard / 13, heightBoard / 8);
                panelsBoard[row][col].setLocation(auxW, auxH);

                auxW += widthBoard / 13;
                this.add(panelsBoard[row][col]);
            }
            auxW = 20;
            auxH += heightBoard / 8;
        }
        paintBoard();
    }

    /**
     * Se pinta el tablero
     */
    private void paintBoard() { // pintamos normal
        for (int col = 0; col < 13; col++) {
            for (int row = 0; row < 8; row++) {
                panelsBoard[row][col].setBackground((row + col) % 2 == 0 ? dos : dos);
            }
        }
    }

    /**
     *
     */
    private void initContainer() {
        int auxW = 900;
        int auxH = 20;

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 9; col++) {
                panelsContainer[row][col] = new Cells(2);
                panelsContainer[row][col].setSize(widthC / 9, heightC / 5);
                panelsContainer[row][col].setLocation(auxW, auxH);
                this.add(panelsContainer[row][col]);
                auxW += widthC / 9;
            }
            auxW = 900;
            auxH += heightC / 5;
        }
        paintContainer();
    }

    /**
     *
     */

    private void paintContainer() { // pintamos normal
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 5; row++) {
                panelsContainer[row][col].setBackground(new Color(0,0,0));
            }
        }
    }

    /**
     * Aqui se inicia el label de Cartas
     */
    public void initCards() {
        //Metodo que posicionaran la matriz
        // Comienzan ambos en (20,20)
        // Width ancho - Horizontal
        // Heigth alto - Vertical
        int auxW = 900;
        int auxH = 20;

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 9; col++) {
                cards[row][col] = new JLabel();
                cards[row][col].setSize(widthC / 9, heightC / 5);
                //cards[row][col].setText("HOLA");
                cards[row][col].setIcon(new ImageIcon(getClass().getResource("/Sprites/Corazones/2Corazon.png")));
                cards[row][col].setLocation(auxW, auxH);
                this.add(cards[row][col]);
                auxW += widthC / 9;
            }
            auxW = 900;
            auxH += heightC / 5;
        }
    }

    public void addListeners() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 9; col++) {
                cards[row][col].addMouseListener(getControl());
                cards[row][col].addMouseMotionListener(getControl());
            }
        }
        this.addMouseListener(getControl());
    }

    public BoardLogicController getControl() {
        if (controller == null) {
            controller = new BoardLogicController(this);
        }
        return controller;
    }
    
    public void initIDS()
    {
        for (int col = 0; col < 13; col++) {
            for (int row = 0; row < 8; row++) {
                IDSBoard[row][col] = panelsBoard[row][col].id;
            }
        }
        
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 5; row++) {
                IDSPlayerDeck[row][col] = panelsContainer[row][col].id;
            }
        }
        
    }
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

    public int getWidthBoard() {
        return widthBoard;
    }

    public int getHeightBoard() {
        return heightBoard;
    }

    public JLabel[][] getCards() {
        return cards;
    }

    public Cells[][] getBoard() {
        return panelsBoard;
    }

    public Cells[][] getPanelsPlayerDeck() {
        return panelsContainer;
    }

    public void setPanelsPlayerDeck(Cells[][] panelsPlayerDeck) {
        this.panelsContainer = panelsPlayerDeck;
    }

    public Client getClient() {
        return client;
    }
    
    public int[][] PlayerDeckID()
    {
        return IDSPlayerDeck;
    }
    
    public int[][] BoardID()
    {
        return IDSBoard;
    }
    
    public void UpdateMatrix()
    {
        getClient().setBoardID(BoardID());
        getClient().setPlayerDeckID(PlayerDeckID());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
