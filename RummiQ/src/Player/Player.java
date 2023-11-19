package Player;
import Cards.Card;
import Board.Board;
import Board.CardStack;
import java.util.ArrayList;

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
	
	private boolean inDeck(Card card)
	{
		for (Card c : cards) if (card == c) return true;
		return false;
	}
	
	public void alterBoard(ArrayList<Card> insertions, int[][] boardAlteration)
	{
		for (Card ins : insertions)
			if (!inDeck(ins)) return;
		
		if (!board.validState(boardAlteration)) return;
		
		for (Card ins : insertions) cards.remove(ins);
		
		board.setState(insertions, boardAlteration);
	}
}
