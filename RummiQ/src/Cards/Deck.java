package Cards;

public class Deck
{
	private static Card[] cards;
	
	public Deck getInstance()
	{
		if (cards == null)
		{
			cards = new Card[109];
			cards[0] = Card.nullcard;
			for (int sym=0, id=1; sym<4; ++sym)
			{
				for (int num=1; num <= 13; ++num)
				{
					
				}
			}
		}
		
		return this; // TODO: QUITAR ESTE RETURN, LO PUSE PARA SALIR DEL PASO XD
	}
}
