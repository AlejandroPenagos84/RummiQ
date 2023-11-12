package Cards;

public class Card
{
	private int cardNum; // Guarda el número de la carta
	private int picID; // Guarda el número con el cual se identificará la imagen
	//private Image image; Aqui se pondrá el atributo para que coloqué la imagen que necesite
	private int ownerID;
	private Symbol symbol;

	public Card(int cardNum, int picID, Symbol symbol)
	{
		this.cardNum = cardNum;
		this.picID = picID;
		this.symbol = symbol;
	}

	public Symbol getSymbol() { return symbol; }
	public int getNumCard() { return cardNum; }
	public int getImageNum() { return picID; }
}
