package Board;
import Cards.Card;
import java.util.ArrayList;

public class CardStack
{
	private ArrayList<Card> cards;
	private static CardStack instance;
	
	public static CardStack getStack()
	{
		if (instance == null) instance = new CardStack();
		return instance;
	}
	
	public Card pop() { return cards.remove(cards.size()-1); }
	public void setCards(ArrayList<Card> cards) { this.cards = cards; }
}
