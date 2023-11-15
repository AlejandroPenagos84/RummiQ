package Cards.CardSet;

import Cards.Card;
import java.util.ArrayList;

public class ColorCardSet extends CardSet
{
	public ColorCardSet(ArrayList<Card> sequence) { super(sequence); }
	
	@Override
	public boolean validState()
	{
		if (this.sequence.size() > 4 || this.sequence.size() < 3) return false;
		for (Card c : sequence) if (c == sequence.get(0)) return false;
		
		return true;
	}
}
