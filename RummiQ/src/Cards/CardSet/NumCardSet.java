package Cards.CardSet;

import Cards.Card;
import java.util.ArrayList;

public class NumCardSet extends CardSet
{
	public NumCardSet(ArrayList<Card> sequence) { super(sequence); }

	@Override
	public boolean validState()
	{
		if (this.sequence.size() < 3) return false;
		
		for (int i=0; i < this.sequence.size()-1; ++i)
		{
			Card cur = this.sequence.get(i);
			Card nxt = this.sequence.get(i+1);
			if ((nxt.cardNum - cur.cardNum != 1) && 
				!(cur.cardNum == 13 && nxt.cardNum == 1)) 
				return false;
			
			if (nxt.symbol != this.sequence.get(0).symbol) return false;
		}
		
		return true;
	}
	
}
