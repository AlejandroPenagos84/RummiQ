package Cards;

public class Card
{
	public final int id;
	private int cardNum; // Guarda el número de la carta
	private int picID; // Guarda el número con el cual se identificará la imagen
	//private Image image; Aqui se pondrá el atributo para que coloqué la imagen que necesite
	private Symbol symbol;
	
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

	public Symbol getSymbol() { return symbol; }
	public int getNumCard() { return cardNum; }
	public int getImageNum() { return picID; }
}
