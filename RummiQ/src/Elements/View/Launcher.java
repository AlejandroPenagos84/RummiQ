/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elements.View;

/**
 *
 * @author Alejandro Penagos
 */
public class Launcher
{

    private Model m;

    public Launcher() {
        if (m == null) {
            m = new Model();
        }
        m.Iniciar();// iniciamos el modelo
    }

    public static void main(String[] args) {

        new Launcher(); // usamos el launcher

    }

}
