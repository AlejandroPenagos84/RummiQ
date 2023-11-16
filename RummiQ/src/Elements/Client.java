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
            BOARD = Board.getBoardSingleton();
        }
        return BOARD;
    }

    public void init() {
        getBoard();
        getPrincipalView().add(getViewBoard());
        getPrincipalView().pack();
    }

    //Con la instancia De Board modifico la posicion inicial que le de el viewBoard
    //Creeria que se reiniciaría cuando termina de poner una carta
    public void initPos(int x, int y) {
        BOARD.setIniPos(BOARD.createPostion(x, y));

    }

    //Con la instancia De Board modifico la posicion final que le de el viewBoard
    //Creeria que se reiniciaría cuando termina de poner una carta
    public void finalPos(int x, int y) {
        BOARD.setFinalPos(BOARD.createPostion(x, y));
    }
}
