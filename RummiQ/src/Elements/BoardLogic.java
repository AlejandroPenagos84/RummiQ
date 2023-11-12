/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elements;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;

/**
 *
 * @author Alejandro Penagos
 */
public class BoardLogic implements MouseListener
//Esta logica esta relacionada con el tablero, es decir, arrastrar cartas, colocarlas, etc, 
//la logica de como saber si gana y demás va en otra clase
{

    private ViewBoard boardView;
    private Color highligh = new Color(242, 242, 242);
    private Map<Point, Color> pModificados = new HashMap();
    Point startPoint;

    public BoardLogic( ViewBoard boardView) {
        this.boardView = boardView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JComponent jc = (JComponent) e.getSource();
        TransferHandler th = jc.getTransferHandler();

        // Obtener el punto de inicio del arrastre
        startPoint = e.getPoint();

        // Resaltar la carta para indicar que está siendo arrastrada
        jc.setBackground(highligh);

        // Configurar el TransferHandler para la carta en el punto de inicio
        th.exportAsDrag(jc, e, TransferHandler.COPY);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JComponent jc = (JComponent) e.getSource();

        // Restablecer el color de fondo de la carta
        jc.setBackground(boardView.getBackground());

        // Realizar acciones adicionales después de soltar la carta si es necesario
        // ...
        // Limpiar el punto de inicio después de soltar la carta
        startPoint = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
