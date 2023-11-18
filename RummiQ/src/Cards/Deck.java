package Cards;

public class Deck
{
	private Card[] cards;
	private static Deck instance;
	
	private int initCards(int idStart, String sym)
	{
		for (int i=0; i < 13; ++i)
			cards[i+idStart] = new Card(i+idStart, i, i+idStart, sym);
		
		return idStart + 13;
	}
	
	private Deck()
	{
		cards = new Card[109];
		cards[0] = Card.nullcard;
		int id=1;

		id = initCards(id, "spades");
		id = initCards(id, "spades");
		id = initCards(id, "clovers");
		id = initCards(id, "clovers");
		id = initCards(id, "diamonds");
		id = initCards(id, "diamonds");
		id = initCards(id, "hearts");
		initCards(id, "hearts");
	}
	
	public static Deck getInstance()
	{
		if (instance == null) instance = new Deck();
		return instance;
	}
	
	public Card getFromId(int id) { return cards[id]; }
}