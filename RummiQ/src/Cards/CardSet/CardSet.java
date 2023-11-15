package Cards.CardSet;

import Cards.Card;
import java.util.ArrayList;

public abstract class CardSet
{
	protected ArrayList<Card> sequence;
	
	public CardSet(ArrayList<Card> sequence) { this.sequence = sequence; }
	public abstract boolean validState();
}