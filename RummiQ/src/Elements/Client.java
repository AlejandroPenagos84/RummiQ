package Elements;

import Board.Board;

public class Client
{

    private PrincipalView PRINCIPAL;
    private ViewBoard VIEW_BOARD;
    private Board BOARD;

    public PrincipalView getPrincipalView() {
        if (PRINCIPAL == null) {
            PRINCIPAL = new PrincipalView(this);
        }
        return PRINCIPAL;
    }

    public ViewBoard getViewBoard() {
        if (VIEW_BOARD == null) {
            VIEW_BOARD = new ViewBoard(this);
        }
        return VIEW_BOARD;
    }

    public Board getBoard() {
        if (BOARD == null) {
            BOARD = Board.getBoard(this);
        }
        return BOARD;
    }

    public void init() {
        getBoard();
        getPrincipalView().add(getViewBoard());
        getPrincipalView().pack();
    }
 
    public void setBoardID(int[][] board)
    {
        BOARD.setBoardID(board);
    }
    
    public void setPlayerDeckID(int[][] playerDeck)
    {
        BOARD.setPlayerDeckID(playerDeck);
    }
    
    public void UpdateMatrix()
    {
        VIEW_BOARD.UpdateMatrix();
    }
}
