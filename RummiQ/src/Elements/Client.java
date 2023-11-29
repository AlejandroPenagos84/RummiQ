package Elements;

import Board.Board;
import Player.Player;

public class Client
{

    private PrincipalView PRINCIPAL;
    private Board BOARD;
    private Player PLAYER1;

    public Client() {
        PLAYER1 = new Player();
        BOARD = Board.getBoard();
        PRINCIPAL = new PrincipalView();
        BOARD.setView(BOARD.getState(), PLAYER1);
        PRINCIPAL.add(BOARD.getView());
        PRINCIPAL.pack();

    }
}
