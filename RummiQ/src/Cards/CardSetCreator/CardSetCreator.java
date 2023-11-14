package Cards.CardSetCreator;
import Cards.Card;
import Cards.CardSet.*;
import java.util.ArrayList;

public class CardSetCreator
{
	public static CardSet createCardSet(ArrayList<Card> cards)
	{
		ColorCardSet colorSet = new ColorCardSet(cards);
		NumCardSet numSet = new NumCardSet(cards);
		if (colorSet.validState()) return colorSet;
		if (numSet.validState()) return numSet;
		
		// Oliver: Retorno en caso de que la lista de cartas no califique
			// como un juego valido: VVVVVVVVVVV
		return new ColorCardSet(new ArrayList<>(1));
	}
}
