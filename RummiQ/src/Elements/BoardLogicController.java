/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elements;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JLabel;

/**
 *
 * @author Alejandro Penagos
 */
public class BoardLogicController implements MouseListener, MouseMotionListener, ActionListener
{

    private ViewBoard viewBoard;
    private int auxID;

    private int rowI;
    private int colI;
    private boolean state;

    private Point ini;

    public BoardLogicController(ViewBoard viewBoard) {
        this.viewBoard = viewBoard;
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
                        // al haber muchas cartas, hay que verificar que carta cogimos para ponerle el Text, en el Ajedres esta esa validacion , me parece , entonces aja, toca mriar
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
        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                JLabel aux = viewBoard.getCards()[fila][columna];
                if (e.getSource().equals(aux)) {
                    auxLocation(e, aux);
                }
            }
        }

        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                System.out.print(viewBoard.IDSPlayerDeck[fila][columna] + " ");
            }
            System.out.println();
        }

        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 13; columna++) {
                System.out.print(viewBoard.IDSBoard[fila][columna] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 9; col++) {
                JLabel aux = viewBoard.getCards()[row][col];
                if (e.getSource().equals(aux)) {
                    int x = aux.getLocation().x + e.getX() - ini.x; // añadimos algo del aux, position
                    int y = aux.getLocation().y + e.getY() - ini.y;

                    aux.setLocation(x, y);
                }
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public void auxLocation(MouseEvent e, JLabel aux) {
        ArrayList<Integer> insertions = new ArrayList<Integer>();
        
        
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

                    if (viewBoard.getBoard()[k][i].id == 0) {
                        int mitadX = ini + (auxAncho / 2); // este es el auxAncho /2
                        int mitadY = iniK + (auxLargo / 2);
                        aux.setLocation(mitadX, mitadY);

                        if (state) {
                            viewBoard.getPanelsPlayerDeck()[rowI][colI].id = 0;//Cambio el ID  a -1 de la baraja de cartas del jugador
                            viewBoard.IDSPlayerDeck[rowI][colI] = 0;
                        } else {
                            viewBoard.getBoard()[rowI][colI].id = 0;//Cambio el ID  a -1 de la posicion del Tablero
                            viewBoard.IDSBoard[rowI][colI] = 0;
                        }
                        viewBoard.getBoard()[k][i].id = auxID;//El ID que tenia en la baraja lo guardé en el tablero
                        viewBoard.IDSBoard[k][i] = auxID;//Actualizo el ID en la matriz de IDS}
                        insertions.add(auxID);
                        return;
                    } else {
                        RestorePosition(aux,auxAncho,auxLargo);
                    }

                    // al haber muchas cartas, hay que verificar que carta cogimos para ponerle el Text, en el Ajedres esta esa validacion , me parece , entonces aja, toca mriar
                } else {
                    RestorePosition(aux,auxAncho,auxLargo);
                }
            }
        }
    }

    public void RestorePosition(JLabel aux, int auxAncho, int auxLargo) {
        if (state) {
            viewBoard.getPanelsPlayerDeck()[rowI][colI].id = auxID;
            viewBoard.IDSPlayerDeck[rowI][colI] = auxID;
            aux.setLocation(900 + (auxAncho * colI - 32) + (auxAncho / 2), (auxLargo * rowI - 24) + (auxLargo / 2));
        } else {
            viewBoard.getBoard()[rowI][colI].id = auxID;
            viewBoard.IDSBoard[rowI][colI] = auxID;
            aux.setLocation((auxAncho * colI - 10) + (auxAncho / 2), (auxLargo * rowI - 25) + (auxLargo / 2));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == viewBoard.button)
        {
            //viewBoard.UpdateMatrix();
        }
    }
}
