package Cards;

import java.util.Map;

public class Card
{
	public final int id;
	public final int cardNum; // Guarda el número de la carta
	public final int picID; // Guarda el número con el cual se identificará la imagen
	public final Symbol symbol;
	public static final Card nullcard = new Card(); // Oliver: Carta de uso
		// especial para casos donde alguna estructura no contiene cartas en
		// algun espacio.
	private static final Map<Integer, String> specials = Map.of(
		0, "",
		1, "As",
		11, "Jota",
		12, "Reina",
		13, "Rey"
	);
	
	public Card()
	{
		this.id = 0;
		this.cardNum = 0;
		this.picID = 0;
		this.symbol = new Symbol();
	}
	
	public Card(int id, int cardNum, int picID, Symbol symbol)
	{
		this.id = id;
		this.cardNum = cardNum;
		this.picID = picID;
		this.symbol = symbol;
	}
	
	public Card(int id, int cardNum, int picID, String symbol)
	{ this(id, cardNum, picID, new Symbol(symbol)); }
	
	public int id() { return id; }
	
	public String cardName()
	{
		if (id==0) return "Nulo.";
		
		switch (cardNum)
		{
		case 1: case 11: case 12: case 13:
			return specials.get(cardNum) + " de " + symbol.nameStr();
		default:
			return "" + cardNum + " de " + symbol.nameStr();
		}
	}
	
	public String getSymbol() { return symbol.nameStr(); }
	
	public String cardPic()
	{
		switch (cardNum)
		{
		case 0: case 1: case 11: case 12: case 13:
			return symbol.nameStr() + specials.get(cardNum) 
				+ symbol.symbolPic();
		default:
			return symbol.nameStr() + "/" + cardNum + symbol.symbolPic();
		}
	}
}
