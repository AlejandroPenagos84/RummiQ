/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elements.View;

/**
 *
 * @author Alejandro Penagos
 */
public class Model
{

    private ViewBoard Ventana_Tablero;
    private PrincipalBoard Ventana_Principal;

    public ViewBoard getVentanaTablero() {
        if(Ventana_Tablero == null){
            Ventana_Tablero = new ViewBoard(this);
        }
        return Ventana_Tablero;
    }
    
    public PrincipalBoard getVentanaPrincipal(){
        if(Ventana_Principal == null){
            Ventana_Principal = new PrincipalBoard(this);
        }
        return Ventana_Principal;
    }
    
    public void Iniciar(){
        getVentanaPrincipal().add(getVentanaTablero());
        getVentanaPrincipal().pack();
    }
    

}
