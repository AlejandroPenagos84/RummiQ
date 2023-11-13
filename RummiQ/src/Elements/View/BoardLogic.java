/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elements.View;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;

public class BoardLogic implements MouseListener, MouseMotionListener
{

    private ViewBoard boardView;
    private Color highligh = new Color(242, 242, 242);
    Point startPoint;

    public BoardLogic(ViewBoard boardView) {
        this.boardView = boardView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = new Point(e.getPoint());

        JLabel clickedLabel = (JLabel) e.getSource();

        for (int col = 0; col < 9; ++col) {
            for (int rows = 0; rows < 5; ++rows) {
                if (boardView.getLabelContainer()[rows][col] == clickedLabel) {
                    boardView.setJLabel(boardView.getLabelContainer()[rows][col]);
                }
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int auxAncho = 85;
        int auxLargo = 65;

        // Obtiene la posición actual del JLabel
        Point currentLocation = boardView.getJLabel().getLocation();

        // Calcula las nuevas coordenadas basadas en el movimiento del ratón
        int x = e.getXOnScreen() - startPoint.x;
        int y = e.getYOnScreen() - startPoint.y;

        // Calcula las coordenadas en el sistema de coordenadas del ViewBoard
        int boardX = x - boardView.getLocationOnScreen().x;
        int boardY = y - boardView.getLocationOnScreen().y;

        for (int i = 0; i < 8; i++) {
            int ini = auxAncho * i + 20;
            int fin = auxAncho * (i + 1) + 20;

            for (int k = 0; k < 13; k++) {
                int iniK = auxLargo * k + 10;
                int finK = auxLargo * (k + 1) + 10;
                //System.out.print(boardX > ini && boardX < fin && boardY > iniK && boardY < finK);
                if (boardX > ini && boardX < fin && boardY > iniK && boardY < finK) {
                    // Actualiza la posición del JLabel en el panel original
                    System.out.print("SIIII");
                    System.out.print("I: "+i);
                    System.out.print("K: "+k);
                    boardView.getJLabel().setLocation(currentLocation);
                    boardView.getJLabel().setVisible(false);

                    // Actualiza el texto en el panel de destino
                    boardView.getLabelBoard()[i][k].setIcon(boardView.getJLabel().getIcon());

                    // Vuelve a mostrar el JLabel en el nuevo panel
                    //boardView.getJLabel().setLocation(boardX, boardY);
                    //boardView.getJLabel().setVisible(true);

                    // Reinicia la referencia al JLabel seleccionado en ViewBoard
                    boardView.setJLabel(null);

                    return; // Sale del bucle si se ha colocado el JLabel
                }
            }
        }

        // Si no se ha colocado en el tablero general, restablece la posición original
        boardView.getJLabel().setLocation(currentLocation);
        boardView.repaint();
        boardView.revalidate();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = boardView.getJLabel().getLocation().x + e.getX() - startPoint.x;
        int y = boardView.getJLabel().getLocation().y + e.getY() - startPoint.y;

        boardView.getJLabel().setLocation(x, y);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}
