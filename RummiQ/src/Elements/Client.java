/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Elements;

/**
 *
 * @author Alejandro Penagos
 */
public class Client
{

    private PrincipalView PRINCIPAL;
    private ViewBoard VIEW_BOARD;
    
    public PrincipalView getPrincipalView()
    {
         if(PRINCIPAL == null)
         {
             PRINCIPAL = new PrincipalView(this);
         }
         return PRINCIPAL;
    }
    
    public ViewBoard getViewBoard()
    {
         if(VIEW_BOARD == null)
         {
             VIEW_BOARD = new ViewBoard(this);
         }
         return VIEW_BOARD;
    }
    
    public void init()
    {
        getPrincipalView().add(getViewBoard());
        getPrincipalView().pack();
    }
}
