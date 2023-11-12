package Elements;
import Cards.Card;
import java.util.HashMap;

public class Board
{
	private int[][] boardCells = new int[13][8];
	private Card cards;
	private HashMap<Position, Integer> cardPos;
	private static Board instance;
	
	public static Board getBoard()
	{
		if (instance == null) instance = new Board();
		return instance;
	}
	
	public class Position
	{
		public final int row;
		public final int col;
		
		Position (int row, int col)
		{
			this.row = row;
			this.col = col;
		}
	}
}
