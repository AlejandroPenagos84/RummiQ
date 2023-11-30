package Cards.CardSetCreator;
import Cards.Card;
import Cards.CardSet.*;
import java.util.ArrayList;

public class CardSetCreator
{
	public static CardSet createCardSet(ArrayList<Card> cards)
	{
		if (cards.size() < 3) return new ColorCardSet(new ArrayList<Card>()
			{{add(Card.nullcard);}});
		
		ColorCardSet colorSet = new ColorCardSet(cards);
		NumCardSet numSet = new NumCardSet(cards);
		if (colorSet.validState())
		{
			System.out.println("CardSet.createCardSet() A");
			return colorSet;
		}
		if (numSet.validState())
		{
			System.out.println("CardSet.createCardSet() B");
			return numSet;
		}
		
		// Oliver: Retorno en caso de que la lista de cartas no califique
			// como un juego valido: VVVVVVVVVVV
		System.out.println("CardSet.createCardSet() C");
		return new ColorCardSet(new ArrayList<Card>(){{add(Card.nullcard);}});
	}
}
