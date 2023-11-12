/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cards;

/**
 *
 * @author Alejandro Penagos
 */
public class Symbol
{
    // Flyweigth, estos dos son los atributos que se repetirán muchas veces
    private String nombre; // Nombre de la carta
    private String color; // Esto es para que el flyweigth tenga sentido xd (Este comentario se quitará después)

    public Symbol(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
