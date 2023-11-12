/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cards;

/**
 *
 * @author Alejandro Penagos
 */
public class Symbol // Oliver: Cambié nombre y color de private a public final,
	// puesto que, además de que deben ser accesibles, no se espera que se
	// modifiquen durante todo el programa.
{
    public final String nombre; // Nombre de la carta
    public final String color; // Esto es para que el flyweigth tenga sentido xd 
		// (Este comentario se quitará después) (mentira, aquí se va a quedar)

    public Symbol(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }
}
