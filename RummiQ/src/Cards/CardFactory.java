/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cards;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alejandro Penagos
 */
public class CardFactory
{
    static Map<String, Symbol> symbolCards = new HashMap<>();
    
    public static Symbol getSymbol(String name, String color){
        Symbol result = symbolCards.get(name);
        if(result == null){
            result = new Symbol(name,color);
            symbolCards.put(name, result);
        }
        return result;
    }
}
