/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elements;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Alejandro Penagos
 */
public class LabelCell extends JLabel
{
    private int row;
    private int col;
    private int PosIFilas;
    private int PosFFilas;
    private int PosICol;
    private int PosFCol;
    
    public LabelCell(int x, int y){
        this.row = x;
        this.col = y;
    }
    
    public void setImage(String URL){
        setIcon(new ImageIcon(URL));
    }
    
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getPosIFilas() {
        return PosIFilas;
    }

    public void setPosIFilas(int PosIFilas) {
        this.PosIFilas = PosIFilas;
    }

    public int getPosFFilas() {
        return PosFFilas;
    }

    public void setPosFFilas(int PosFFilas) {
        this.PosFFilas = PosFFilas;
    }

    public int getPosICol() {
        return PosICol;
    }

    public void setPosICol(int PosICol) {
        this.PosICol = PosICol;
    }

    public int getPosFCol() {
        return PosFCol;
    }

    public void setPosFCol(int PosFCol) {
        this.PosFCol = PosFCol;
    }


    
    
}
