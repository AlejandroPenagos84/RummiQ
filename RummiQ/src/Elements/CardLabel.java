package Elements;

import Cards.Card;
import javax.swing.JLabel;

public class CardLabel extends JLabel
{
	private int id;
	private int col;
	private int row;
	private String picStr;
	
	public CardLabel(int id, int col, int row, String picStr)
	{
		this.id = id;
		this.col = col;
		this.row = row;
		this.picStr = picStr;
	}
	
	public CardLabel(Card card)
	{
		this.id = card.id;
		this.picStr = card.cardPic();
		this.row=0;
		this.col=0;
	}
	
	public CardLabel(Card card, int col, int row)
	{
		this.id = card.id;
		this.picStr = card.cardPic();
		this.col = col;
		this.row = row;
	}
	
	public CardLabel()
	{
		super();
		this.id = 0;
		this.col = 0;
		this.row = 0;
		this.picStr = Card.nullcard.cardPic();
	}

	
	public int getId() { return id; }
}
