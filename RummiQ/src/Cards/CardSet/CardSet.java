package Cards.CardSet;

import Cards.Card;
import Cards.Deck;
import java.util.ArrayList;

public abstract class CardSet
{
	protected ArrayList<Card> sequence;
	
	public CardSet(ArrayList<Card> sequence) { this.sequence = sequence; }
	public int size() { return sequence.size(); }
	public abstract boolean validState();
}