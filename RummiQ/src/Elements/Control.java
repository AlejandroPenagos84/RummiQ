package Elements;

import Board.Board;
import Board.CardStack;
import Cards.Card;
import Cards.Deck;
import Player.Player;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JLabel;

/**
 *
 * @author Alejandro Penagos
 */
public class Control implements MouseListener, MouseMotionListener, ActionListener
{

    private ViewBoard viewBoard;
    ArrayList<Integer> insertions;
    private int auxID;

    private int rowI;
    private int colI;
    private boolean state;

    private Point ini;

    //VARIABLES DE ESTADO
    private PrincipalView boardFrame;
    private Board board;
    private Deck mainDeck = Deck.getInstance();
    private Player player1, player2, current;
    private final int pDeckRows = 5, pDeckCols = 9;

    public Control() {
        player1 = new Player();
        player2 = new Player();
        board = Board.getBoard();
        board.saveState();
        boardFrame = new PrincipalView();
        board.setView(board.getState(), player1, player2, this);
        current = player1;
        viewBoard = board.getView();
        boardFrame.add(board.getView());
        boardFrame.pack();
        System.out.println("Control()");
    }

    /*
    public Control(ViewBoard viewBoard, Player player1, Player player2) {
        this.viewBoard = viewBoard;
        insertions = new ArrayList<>();
    }*/
    private void endTurn() {
       /*if (!board.validState(viewBoard.IDSBoard)) {
            board.restore();
            if (current == player1) {
                current = player2;
            } else if (current == player2) {
                current = player1;
            }

            ArrayList<Integer> nextPlayerIDS = new ArrayList<>();
            for (int i = 0; i < current.cardCount(); ++i) {
                nextPlayerIDS.add(current.getCardInPos(i).id());
            }

            viewBoard.UpdateState(nextPlayerIDS, board.getState());
			System.out.println("endTurn() A");
            return;
        }*/

        ArrayList<Card> newDeck = new ArrayList<>();
        for (int row = 0; row < pDeckRows; ++row) {
            for (int col = 0; col < pDeckCols; ++col) {
                newDeck.add(mainDeck.card(viewBoard.IDSPlayerDeck[row][col]));
				System.out.print(viewBoard.IDSPlayerDeck[row][col] + "\t");
            }
			System.out.println();
        }

        current.setDeck(newDeck);
        if (current == player1) {
            current = player2;
        } else if (current == player2) {
            current = player1;
        }
        board.saveState();

        ArrayList<Integer> nextPlayerIDS = new ArrayList<>();
        for (int i = 0; i < current.cardCount(); ++i) {
            nextPlayerIDS.add(current.getCardInPos(i).id());
        }

        viewBoard.UpdateState(nextPlayerIDS, board.getState());
		System.out.println("endTurn() B");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        ini = new Point(e.getPoint());
        Point initialPoint = new Point(e.getLocationOnScreen());
        rowI = 0;
        colI = 0;
        if (initialPoint.x >= 920) {
            int auxAncho = viewBoard.widthBoard / 13; // un ancho provisional y un largo provicional
            int auxLargo = viewBoard.heightBoard / 8;

            int x = e.getLocationOnScreen().x + -ini.x;
            int y = e.getLocationOnScreen().y + -ini.y;
            state = true;
            for (int i = 0; i < 9; i++) {//Columnas
                int ini = 900 + (auxAncho * i) - 10; // este ini y fin es para poder ubicarlos en la cuadricula, es decir, menor a 80 mayor a 20 y se repite con el otro, mator a 80 y menor a 140
                int fin = 900 + (auxAncho * (i + 1)) - 10;

                for (int k = 0; k < 5; k++) {//Filas
                    int iniK = auxLargo * k - 25;
                    int finK = auxLargo * (k + 1) - 25;
                    if (x > ini && x < fin && y > iniK && y < finK) {
                        rowI = k;
                        colI = i;

                        auxID = viewBoard.getPanelsPlayerDeck()[k][i].id;//Cojo el id de la carta que tenia en la baraja
                        //Aqui es donde realmente le estoy pasando a board la posicion
                    }
                }
            }
        } else {
            //En caso de que coja en el lado del tablero

            // un ancho provisional y un largo provicional
            int auxAncho = viewBoard.widthBoard / 13;
            int auxLargo = viewBoard.heightBoard / 8;

            int x = e.getLocationOnScreen().x + -ini.x;
            int y = e.getLocationOnScreen().y + -ini.y;
            state = false;
            for (int i = 0; i < 13; i++) {//Columnas

                // este ini y fin es para poder ubicarlos en la cuadricula, es decir, menor a 80 mayor a 20 y 
                // se repite con el otro, mator a 80 y menor a 140
                int ini = (auxAncho * i) - 10;
                int fin = (auxAncho * (i + 1)) - 10;

                for (int k = 0; k < 8; k++) {//Filas
                    int iniK = auxLargo * k - 25;
                    int finK = auxLargo * (k + 1) - 25;
                    if (x > ini && x < fin && y > iniK && y < finK) {
                        rowI = k;
                        colI = i;

                        auxID = viewBoard.getBoard()[k][i].id;////Coge el ID de ese punto del tablero
                    }
                }
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (state) {
            for (int fila = 0; fila < 5; fila++) {
                for (int columna = 0; columna < 9; columna++) {
                    JLabel aux = viewBoard.getPlayerDeck()[fila][columna];
                    if (e.getSource().equals(aux)) {
                        render(e, aux);
                    }
                }
            }
        } else {
            for (int fila = 0; fila < 8; fila++) {
                for (int columna = 0; columna < 13; columna++) {
                    JLabel aux = viewBoard.getBoardLabel()[fila][columna];
                    if (e.getSource().equals(aux)) {
                        render(e, aux);
                    }
                }
            }
        }
/*
        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                System.out.print(viewBoard.IDSPlayerDeck[fila][columna] + "\t");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        System.out.print("\n");

        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 13; columna++) {
                System.out.print(viewBoard.IDSBoard[fila][columna] + "\t");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        System.out.print("\n");*/
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (state) {
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 9; col++) {
                    JLabel aux = viewBoard.getPlayerDeck()[row][col];
                    if (e.getSource().equals(aux)) {
                        int x = aux.getLocation().x + e.getX() - ini.x; // añadimos algo del aux, position
                        int y = aux.getLocation().y + e.getY() - ini.y;

                        aux.setLocation(x, y);
                    }
                }
            }
        } else {
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 13; col++) {
                    JLabel aux = viewBoard.getBoardLabel()[row][col];
                    if (e.getSource().equals(aux)) {
                        int x = aux.getLocation().x + e.getX() - ini.x; // añadimos algo del aux, position
                        int y = aux.getLocation().y + e.getY() - ini.y;

                        aux.setLocation(x, y);
                    }
                }
            }
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public void render(MouseEvent e, JLabel aux) {

        int auxAncho = viewBoard.widthBoard / 13; // un ancho provisional y un largo provicional
        int auxLargo = viewBoard.heightBoard / 8;

        boolean validId = true;
        int x = aux.getLocation().x + e.getX() - ini.x;
        int y = aux.getLocation().y + e.getY() - ini.y;

        for (int i = 0; i < 13; i++) {//Columnas
            int ini = (auxAncho * i) - 10; // este ini y fin es para poder ubicarlos en la cuadricula, es decir, menor a 80 mayor a 20 y se repite con el otro, mator a 80 y menor a 140
            int fin = (auxAncho * (i + 1)) - 10;

            for (int k = 0; k < 8; k++) {//Filas
                int iniK = auxLargo * k - 25;
                int finK = auxLargo * (k + 1) - 25;
                if (x > ini && x < fin && y > iniK && y < finK) {

                    int mitadX = ini + (auxAncho / 2); // este es el auxAncho /2
                    int mitadY = iniK + (auxLargo / 2);
                    aux.setLocation(mitadX, mitadY);

                    if (state) {
                        int id = viewBoard.IDSPlayerDeck[rowI][colI];
                        viewBoard.IDSPlayerDeck[rowI][colI] = viewBoard.IDSBoard[k][i];
                        viewBoard.IDSBoard[k][i] = id;
                        // Coge la imagen transparente donde se supone ue se colocarála cara
                        Icon transparent = viewBoard.getBoardLabel()[k][i].getIcon();

                        // Asigna la imagen de la carta que se está arrastrando en el JLabel asignado
                        viewBoard.getBoardLabel()[k][i].setIcon(aux.getIcon());

                        //El label de donde partio se asigna la imagen transparente
                        aux.setIcon(transparent);

                        //Devuelve la posicion del label que se estaba moviendo a su posición original
                        RestorePosition(aux, auxAncho, auxLargo);
                    } else {
                        int id = viewBoard.IDSBoard[rowI][colI];
                        viewBoard.IDSBoard[rowI][colI] = viewBoard.IDSBoard[k][i];
                        viewBoard.IDSBoard[k][i] = id;

                        Icon transparent = viewBoard.getBoardLabel()[k][i].getIcon();

                        viewBoard.getBoardLabel()[k][i].setIcon(aux.getIcon());

                        aux.setIcon(transparent);

                        RestorePosition(aux, auxAncho, auxLargo);
                    }
                    return;

                } else {
                    RestorePosition(aux, auxAncho, auxLargo);
                }
            }
        }
    }

    public void RestorePosition(JLabel aux, int auxAncho, int auxLargo) {
        if (state) {
            aux.setLocation(900 + (auxAncho * colI - 32) + (auxAncho / 2), (auxLargo * rowI - 24) + (auxLargo / 2));
        } else {
            aux.setLocation((auxAncho * colI - 10) + (auxAncho / 2), (auxLargo * rowI - 25) + (auxLargo / 2));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewBoard.buttonEndGame) {
            //viewBoard.UpdateState(insertions, viewBoard.IDSBoard);
            System.out.println("ActionPerformed: endGame");
            endTurn();
        }

        if (e.getSource() == viewBoard.buttonRequestCard) {
            CardStack cardStack = CardStack.getStack();
            Card newCard = cardStack.pop();

            int auxW = 900;
            int auxH = 20;
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 9; col++) {
                    if (viewBoard.IDSPlayerDeck[row][col] == 0) {
                        viewBoard.playerDeck[row][col].setIcon(new ImageIcon(getClass()
                            .getResource("/Sprites/" + newCard.cardPic()))
                        );
                        viewBoard.IDSPlayerDeck[row][col] = newCard.id;
                        System.out.println("ID:" + newCard.id);
                        viewBoard.playerDeck[row][col].addMouseMotionListener(this);
                        viewBoard.playerDeck[row][col].addMouseListener(this);
                        endTurn();
                        return;
                    }
                }
            }
        }
    }
}
