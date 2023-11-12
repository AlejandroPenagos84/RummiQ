/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Elements;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

/**
 *
 * @author Alejandro Penagos
 */
public class ViewBoard extends javax.swing.JFrame
{

    BoardLogic boardLogic;//Logica Del Tablero

    private JPanel panelsBoard[][];
    private LabelCell labelsBoard[][];
    private JPanel cardPanelsContainer[][];
    private LabelCell cardLabelsContainer[][];
    private JPanel cardContainer;

    private final int widthBoard, heigthBoard, widthContainer, heigthContainer;
    private final Color uno = new Color(247, 249, 249); // no se deberia cambiar 175, 96, 26 
    private final Color dos = new Color(86, 125, 24); // 235, 152, 78

    public ViewBoard() {
        this.panelsBoard = new JPanel[13][8];
        this.labelsBoard = new LabelCell[13][8];
        this.cardPanelsContainer = new JPanel[9][5];
        this.cardLabelsContainer = new LabelCell[9][5];

        this.widthContainer = 625;
        this.heigthContainer = 437;

        this.widthBoard = 865;
        this.heigthBoard = 700;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setLayout(null); // aqui lo hacemos null para poder dibujar

        setPreferredSize(new java.awt.Dimension(1700, 1100));
        this.setBackground(dos);
        initBoard();
        initContainer();
        setLabels();
        pack();
    }

    private void initBoard() {
        int auxW = 20;
        int auxH = 20;

        for (int rows = 0; rows < 13; ++rows) {
            for (int col = 0; col < 8; ++col) {
                panelsBoard[rows][col] = new JPanel();//Crear Paneles
                labelsBoard[rows][col] = new LabelCell(rows, col);//Crear Labels
                panelsBoard[rows][col].add(labelsBoard[rows][col]);//Añade el label dentro del panel creador
                panelsBoard[rows][col].setSize((widthBoard) / 13, (heigthBoard) / 8);//Acomoda el tamaño del panel
                panelsBoard[rows][col].setLocation(auxW, auxH);//Acomoda al panel en la posición dada

                //labelsBoard[rows][col].setPosICol(auxH+10);
                //labelsBoard[rows][col].setPosIFilas(auxW+10);
                
                int auxA = auxW + (widthBoard) / 9;
                auxH += (heigthBoard) / 8;//Aumenta auxH para colocar el sigueinte label en la siguiente columna
                
                //labelsBoard[rows][col].setPosFCol(auxH - 10);
                //labelsBoard[rows][col].setPosFFilas(auxA-10);
                
                this.add(panelsBoard[rows][col]);//Añade el panel en el Frame
            }
            auxW += (widthBoard) / 13; // Aumenta AuxW para colocarlo posicionarse en la nueva Fila
            auxH = 20; // Reinicia auxH para colocar toda la nueva fila desde la primera columna
        }
        paintBoard();//Pinta todo el tablero
    }

    private void paintBoard() {
        for (int rows = 0; rows < 13; ++rows) {
            for (int col = 0; col < 8; ++col) {
                panelsBoard[rows][col].setBackground((rows + col) % 2 == 0 ? uno : dos);//Pinta los JLabel con un color verde
            }
        }
    }

    private void initContainer() {
        int auxW = 900;
        int auxH = 20;
        int rows;
        int col;
        for (rows = 0; rows < 9; ++rows) {
            for (col = 0; col < 5; ++col) {
                cardPanelsContainer[rows][col] = new JPanel();//Crear Paneles
                cardLabelsContainer[rows][col] = new LabelCell(rows, col);//Crear Labels
                cardPanelsContainer[rows][col].add(cardLabelsContainer[rows][col]);//Añade el label dentro del panel creador
                cardPanelsContainer[rows][col].setSize((widthContainer) / 9, (heigthContainer) / 5);//Acomoda el tamaño del panel
                cardPanelsContainer[rows][col].setLocation(auxW, auxH);//Acomoda al panel en la posición dada

               // cardLabelsContainer[rows][col].setPosICol(auxH+10);
                //cardLabelsContainer[rows][col].setPosIFilas(auxW+10);

                int auxA = auxW + (widthContainer) / 9;
                auxH += (heigthContainer) / 5;//Aumenta auxH para colocar el sigueinte label en la siguiente fila

                //cardLabelsContainer[rows][col].setPosFCol(auxH - 10);
                //cardLabelsContainer[rows][col].setPosFFilas(auxA-10);

                this.add(cardPanelsContainer[rows][col]);//Añade el panel en el Frame
            }

            auxW += (widthContainer) / 9;

// Aumenta AuxW para colocarlo posicionarse en la nueva Fila
            auxH = 20; // Reinicia auxH para colocar toda la nueva fila desde la primera columna
        }
        paintContainer();//Pinta todo el tablero
    }

    private void paintContainer() {
        for (int rows = 0; rows < 9; ++rows) {
            for (int col = 0; col < 5; ++col) {
                cardPanelsContainer[rows][col].setBackground(uno);
            }
        }
    }

    private void setLabels() {
        MouseListener ml = new MouseListener()
        {
            LabelCell jc;
            TransferHandler th;
            LabelCell origin;

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                int sourceX = e.getLocationOnScreen().x; // Almacena la posición inicial x
                int sourceY = e.getLocationOnScreen().y;
                jc = (LabelCell) e.getSource();
                
                System.out.println("Pos Inicial"+jc.getPosIFilas());
                System.out.println("Pos Final"+jc.getPosFFilas());
                
                System.out.println(sourceX);
                System.out.println(sourceY + "\n");
                
                //origin = getCell(jc.getPosICol(),jc.getPosFCol(),jc.getPosIFilas(),jc.getPosFFilas());
                
                th = jc.getTransferHandler();
                // No realiza el drag en el mousePressed
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int destinationX = e.getLocationOnScreen().x; // Obtiene la posición x donde se soltó el mouse
                int destinationY = e.getLocationOnScreen().y;

                System.out.println(destinationX);
                System.out.println(destinationY + "\n");
                // Verifica si la posición x de destino es menor o igual a 920
                if (destinationX <= 920) {
                    origin.setImage("C:\\\\Users\\\\Alejandro Penagos\\\\Desktop\\\\RummiQ\\\\RummiQ\\\\src\\\\Sprites\\\\Transparent.png");
                    th.exportAsDrag(jc, e, TransferHandler.COPY);
                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };

        for (LabelCell[] row : labelsBoard) {
            for (LabelCell label : row) {
                label.setImage("C:\\\\Users\\\\Alejandro Penagos\\\\Desktop\\\\RummiQ\\\\RummiQ\\\\src\\\\Sprites\\\\Transparent.png");
                label.addMouseListener(ml);
                label.setTransferHandler(new TransferHandler("icon"));
            }
        }

        for (LabelCell[] row : cardLabelsContainer) {
            for (LabelCell label : row) {
                label.setImage("C:\\\\Users\\\\Alejandro Penagos\\\\Desktop\\\\RummiQ\\\\RummiQ\\\\src\\\\Sprites\\\\Corazones\\\\2Corazon.png");
                label.addMouseListener(ml);
                label.setTransferHandler(new TransferHandler("icon"));
            }
        }
    }
    
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(192, 57, 43));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() {
                new ViewBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
