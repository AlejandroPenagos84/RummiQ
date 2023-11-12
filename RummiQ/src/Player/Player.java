package Player;
import Cards.Card;
import Elements.Board;
import Elements.CardStack;
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
		return new Card();
	}
	
	public void alterBoard(HashMap<Board.Position, Integer> insertions,
		HashMap<Board.Position, Integer> alterations)
	{
		// TODO verificar integridad del juego
		// Sección 2: Remover las del jugador
		{
			//for (Board.Position key : alterations)
		}
	}
}
