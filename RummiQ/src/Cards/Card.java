package Cards;

public class Card
{
	public final int id;
	public final int cardNum; // Guarda el número de la carta
	public final int picID; // Guarda el número con el cual se identificará la imagen
	//private Image image; Aqui se pondrá el atributo para que coloqué la imagen que necesite
	public final Symbol symbol;
	public static final Card nullcard = new Card(); // Oliver: Carta de uso
		// especial para casos donde alguna estructura no contiene cartas en
		// algun espacio.
	
	public Card()
	{
		this.id = 0;
		this.cardNum = 0;
		this.picID = 0;
		this.symbol = new Symbol("", "");
	}
	
	public Card(int id, int cardNum, int picID, Symbol symbol)
	{
		this.id = id;
		this.cardNum = cardNum;
		this.picID = picID;
		this.symbol = symbol;
	}
}
