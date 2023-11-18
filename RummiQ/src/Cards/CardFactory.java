package Cards;

import Cards.Deck;
import java.util.HashMap;
import java.util.Map;

public class CardFactory
{
	static Map<Integer, Symbol> symbolCards = new HashMap<>();

	public static Symbol getSymbol(int id)
	{
		Symbol result = symbolCards.get(id);
		if (result == null)
		{
			// TODO: refactor.
			//result = Deck.getInstance().getFromId(id).symbol;
			symbolCards.put(id, result);
		}
		return result;
	}
}
