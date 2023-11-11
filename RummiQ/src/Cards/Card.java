/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cards;

/**
 *
 * @author Alejandro Penagos
 */
public class Card
{
    private int numCard;// Guarda el número de la carta
    private int imageNum;// Guarda el número con el cual se identificará la imagen
    //private Image image; Aqui se pondrá el atributo para que coloqué la imagen que necesite
    private Symbol symbol;
    
    public Card(int numCard, int imageNum, Symbol symbol) {
        this.numCard = numCard;
        this.imageNum = imageNum;
        this.symbol = symbol;
    }

    
    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
    
    
    public int getNumCard() {
        return numCard;
    }

    public void setNumCard(int numCard) {
        this.numCard = numCard;
    }

    public int getImageNum() {
        return imageNum;
    }

    public void setImageNum(int imageNum) {
        this.imageNum = imageNum;
    }
    
    
}
