package Cards;

public class Deck
{
	private final Card[] cards;
	private static Deck instance;
	
	private int initCards(int idStart, String sym)
	{
		for (int i=1; i <= 13; ++i)
			cards[i+idStart] = new Card(i+idStart, i, i+idStart, sym);
		return idStart + 13;
	}
	
	private Deck()
	{
		cards = new Card[105];
		cards[0] = Card.nullcard;
		int id=0;

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
	
	public Card card(int id) { return cards[id]; }
}