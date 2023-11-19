package Elements;

import Board.Board;
import Player.Player;

public class Client
{

    private PrincipalView PRINCIPAL;
    private ViewBoard VIEW_BOARD;
    private Board BOARD;
    private Player PLAYER;



    public Client() {
        PRINCIPAL = new PrincipalView();
        VIEW_BOARD = new ViewBoard();
        PRINCIPAL.add(VIEW_BOARD);
        PRINCIPAL.pack();
    }
}
