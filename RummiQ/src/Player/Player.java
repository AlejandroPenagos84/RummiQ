package Player;
import Cards.Card;
import Elements.Board;
import Elements.CardStack;
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
	
	public void pop() { cards.add(stack.pop()); }
	
	public void alterBoard(ArrayList<Card> insertions /*probablemente requiere
		mas parametros*/)
	{
		// TODO definir metodos de alteracion de tabla
	}
}
