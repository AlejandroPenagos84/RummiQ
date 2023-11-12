package Elements;
import Cards.Card;
import java.util.ArrayList;

public class CardStack
{
	private ArrayList<Card> cards;
	
	public Card pop()
	{
		return cards.remove(cards.size()-1);
	}
}
