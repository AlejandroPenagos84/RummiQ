package Board;
import Cards.Card;
import java.util.HashMap;

public class Board
{
	private Card[][] boardCards = new Card[13][8];//Creo la Matriz De Las Cartas
        
	private Card cards;
	private HashMap<Position, Integer> boardState;
	private static Board instance;
	
	public static Board getBoardSingleton()
	{
		if (instance == null) instance = new Board();
		return instance;
	}
	
        private void initCard()
        {
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 13; col++) 
                {
                    boardCards[row][col] = null;// Se inicializa todo el tablero NULL
                }
            }
        }
        
	public boolean validState(HashMap<Position, Integer> boardState)
	{
	
		
		return false; // TODO: IMPLEMENTAR FUNCIÓN Y ELIMINAR ÉSTE RETURN
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
