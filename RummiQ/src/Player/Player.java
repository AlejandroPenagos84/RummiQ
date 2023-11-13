package Player;
import Cards.Card;
import Elements.Board;
import Elements.CardStack;
import Elements.ViewBoard;
import java.util.ArrayList;
import java.util.HashMap;

public class Player
{
	private ArrayList<Card> cards;
	private CardStack stack;
	private Board board;
	
	public Player(ArrayList<Card> cards, CardStack stack, Board board)
	{
		this.cards = cards;
		this.stack = stack;
		this.board = board;
	}
	
	public void pop() { cards.add(stack.pop()); } // Toma una carta del tope
		// de la pila.
	
	public Card getCard(int id) // Obtiene una carta a partir de su identificador
	{
		for (Card card : cards)
			if (id == card.id) return card;
		return Card.nullcard; // 
	}
	
	public void alterBoard(HashMap<Board.Position, Integer> insertions,
		HashMap<Board.Position, Integer> alterations)
	{
		// TODO verificar integridad del juego
		{
		boolean exists = false;
		
		for (int cardId : insertions.values())
		{
			for (Card card : cards)
			{
				if (cardId == card.id)
					exists = true;
			}
		}
		
		if (!exists)
		{
			ViewBoard.log("Error de codigo: el jugador no puede agregar al "
				+ "tablero cartas que no están en su baraja.\n");
			return;
		}
		}
		
		// Sección 2: Remover las cartas usadas por el jugador
		{
		for (int cardId : insertions.values())
			for (Card card : cards)
				if (cardId == card.id) cards.remove(card);
		}
		
		
	}
}
