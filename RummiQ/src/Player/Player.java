package Player;

import Cards.Card;
import Board.Board;
import Board.CardStack;
import java.util.ArrayList;

public class Player
{

    private ArrayList<Card> cards;
    private CardStack stack;

    public Player() {
        stack = CardStack.getStack();
        System.out.println("Player()");
        cards = stack.deal(14);
    }

    public void pop() {
        cards.add(stack.pop());
    } // Toma una carta del tope
    // de la pila.

    public Card getCard(int id) // Obtiene una carta a partir de su identificador
    {
        for (Card card : cards) {
            if (id == card.id) {
                return card;
            }
        }
        return Card.nullcard; // 
    }

    public Card getCardInPos(int index) {
        if (index>=cards.size()){
            return Card.nullcard;
        }
        return cards.get(index);
    }

    public String cardPicInPos(int index) {
        return getCardInPos(index).cardPic();
    }

    public String cardPic(int id) {
        return getCard(id).cardPic();
    }

    public int cardCount() { return cards.size(); }

    private boolean inDeck(Card card) {
        for (Card c : cards) {
            if (card == c) {
                return true;
            }
        }
        return false;
    }
	
	public void setDeck(ArrayList<Card> cards)
	{
		for (int i=0; i < cards.size(); ++i)
		{
			if (cards.get(i) == Card.nullcard) continue;
			if (i >= this.cards.size()) this.cards.add(cards.get(i));
			this.cards.set(i, cards.get(i));
		}
	}
	
	public ArrayList<Card> getDeck() { return cards; }

    public void alterBoard(ArrayList<Card> insertions, int[][] boardAlteration) {
        for (Card ins : insertions) {
            if (!inDeck(ins)) {
                return;
            }
        }

        if (!Board.getBoard().validState(boardAlteration)) {
            return;
        }

        for (Card ins : insertions) {
            cards.remove(ins);
        }

        Board.getBoard().setState(insertions, boardAlteration);
    }
}
