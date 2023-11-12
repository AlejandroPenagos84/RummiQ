package Cards;

import java.util.HashMap;
import java.util.Map;

public class CardFactory
{
	static Map<String, Symbol> symbolCards = new HashMap<>();

	public static Symbol getSymbol(String name, String color)
	{
		Symbol result = symbolCards.get(name);
		if (result == null)
		{
			result = new Symbol(name, color);
			symbolCards.put(name, result);
		}
		return result;
	}
}
