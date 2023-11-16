/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author Alejandro Penagos
 */
public class BoardLogicController implements MouseListener, MouseMotionListener
{

    private ViewBoard viewBoard;
    private int auxID;
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
        
        int auxAncho = viewBoard.getWidthBoard() / 13; // un ancho provisional y un largo provicional
        int auxLargo = viewBoard.getHeightBoard() / 8;

        int x = e.getLocationOnScreen().x +  - ini.x;
        int y =  e.getLocationOnScreen().y +  - ini.y;
        
        for (int i = 0; i < 9; i++) 
        {//Columnas
            int ini = 900 + (auxAncho * i)-10; // este ini y fin es para poder ubicarlos en la cuadricula, es decir, menor a 80 mayor a 20 y se repite con el otro, mator a 80 y menor a 140
            int fin = 900 + (auxAncho * (i + 1))-10;
            
            for (int k = 0; k < 5; k++)
            {//Filas
                int iniK = auxLargo * k-25;
                int finK = auxLargo * (k + 1)-25;
                if (x > ini && x < fin && y > iniK && y < finK)
                {
                    auxID = viewBoard.getPanelsContainer()[k][i].id ;//Cojo el id de la carta que tenia en la baraja
                    viewBoard.getPanelsContainer()[k][i].id = -1;//Cambio el ID  a -1 de la baraja de cartas del jugador
                    viewBoard.DeckID()[k][i] = -1;// Actualizo el id
                    //Aqui es donde realmente le estoy pasando a board la posicion
                    // al haber muchas cartas, hay que verificar que carta cogimos para ponerle el Text, en el Ajedres esta esa validacion , me parece , entonces aja, toca mriar
                }
            }
        }
        viewBoard.getClient().setDeckID(viewBoard.DeckID());//Actualizo la matriz que está en Board
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (int  fila = 0;  fila < 5;  fila++) {
            for (int columna = 0; columna < 9; columna++) {
                JLabel aux = viewBoard.getCards()[fila][columna];
                if (e.getSource().equals(aux)) {
                    auxLocation(e, aux);
                }
            }
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
        int auxAncho = viewBoard.getWidthBoard() / 13; // un ancho provisional y un largo provicional
        int auxLargo = viewBoard.getHeightBoard() / 8;

        int x = aux.getLocation().x + e.getX() - ini.x;
        int y = aux.getLocation().y + e.getY() - ini.y;

        for (int i = 0; i < 13; i++) 
        {//Columnas
            int ini = (auxAncho * i)-10; // este ini y fin es para poder ubicarlos en la cuadricula, es decir, menor a 80 mayor a 20 y se repite con el otro, mator a 80 y menor a 140
            int fin = (auxAncho * (i + 1))-10;
            
            for (int k = 0; k < 8; k++)
            {//Filas
                int iniK = auxLargo * k-25;
                int finK = auxLargo * (k + 1)-25;
                if (x > ini && x < fin && y > iniK && y < finK)
                {
                    int mitadX = ini + (auxAncho/2); // este es el auxAncho /2
                    int mitadY = iniK + (auxLargo/2);
                    aux.setLocation(mitadX, mitadY);
                    
                    viewBoard.getBoard()[k][i].id = auxID;//El ID que tenia en la baraja lo guardé en el tablero
                    viewBoard.BoardID()[k][i] = auxID;//Actualizo el ID en la matriz de IDS
                    // al haber muchas cartas, hay que verificar que carta cogimos para ponerle el Text, en el Ajedres esta esa validacion , me parece , entonces aja, toca mriar
                }
            }
        }
        viewBoard.getClient().setBoardID(viewBoard.BoardID());//Actualizo la matriz de ID que está en la clase Board
    }

}
