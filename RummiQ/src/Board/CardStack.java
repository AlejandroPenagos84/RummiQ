package Board;
import Cards.Card;
import static Cards.Card.nullcard;
import Cards.Deck;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class CardStack
{
	private ArrayList<Card> cards;
	private static CardStack instance;
	public static CardStack getStack()
	{
		if (instance == null)
			instance = new CardStack();
		
		return instance;
	}
	
	private void shuffle()
	{
		Collections.shuffle(cards);
	}
	
	private CardStack()
	{
		System.out.println("CardStack()");
		Deck deck = Deck.getInstance();
		cards = new ArrayList<>();
		for (int i=1; i < deck.size; ++i)
		{
			cards.add(deck.card(i));
		}
		
		shuffle();
	}
	
	public ArrayList<Card> deal(int cardCount) // ADVERTENCIA: LAS CARTAS
		// BARAJADAS POR ESTE METODO SE ELIMINAN DE LA PILA
	{
		ArrayList<Card> out = new ArrayList<>();
		if (cardCount < 0) return deal(-cardCount);
		if (cardCount >= cards.size() || cardCount == 0)
			return new ArrayList<Card>(Arrays.asList(nullcard));
		
		for (int i=0; i < cardCount; ++i) out.add(pop());
		
		/* 
		System.out.println("CardStack.deal()");
		for (int i=0; i < cardCount; ++i)
		{
			Card rand = randSelect();
			out.add(rand);
			cards.remove(rand);
		}*/
		
		return out;
		
		
	}
	
	private Card randSelect()
	{
		Random rand = new Random();
		return cards.get(rand.nextInt(cards.size()));
	}
	
	public Card pop() { return cards.remove(cards.size()-1); }
	public void setCards(ArrayList<Card> cards) { this.cards = cards; }
}
