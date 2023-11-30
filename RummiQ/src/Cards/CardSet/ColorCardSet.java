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
		System.out.println("ColorCardSet.validState() a");
		for (int i=1; i < sequence.size(); ++i)
		{
			System.out.println("ColorCardSet.validState(): " + sequence.get(i).getSymbol()
				+ " " + sequence.get(0).getSymbol());
			if ((sequence.get(i).symbol == sequence.get(0).symbol) || 
				(sequence.get(i).cardNum != sequence.get(0).cardNum))
				return false;
		}
		System.out.println("ColorCardSet.validState() b");
		
		return true;
	}
}
