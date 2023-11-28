package Elements;

import Board.Board;
import Player.Player;

public class Client
{
    private PrincipalView PRINCIPAL;
    private ViewBoard VIEW_BOARD;
    private Board BOARD;
    private Player PLAYER1;

    public Client() {
		PLAYER1 = new Player();
		BOARD = Board.getBoard();
        PRINCIPAL = new PrincipalView();
		VIEW_BOARD = new ViewBoard(PLAYER1);
		
		BOARD.setViewBoard(VIEW_BOARD);
        PRINCIPAL.add(VIEW_BOARD);
        PRINCIPAL.pack();
    }
}
