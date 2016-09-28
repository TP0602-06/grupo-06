package ar.fiuba.tdd.tp.nikoligames.engine.model.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;

/**
 * Created by Andres on 24/09/2016.
 */
public class BoardFactory {
    private static BoardFactory instance = null;

    private BoardFactory() {
    }


    //Singleton
    public static BoardFactory getInstance() {
        if (instance == null) {
            instance = new BoardFactory();
        }
        return instance;
    }

    public Board createBoard(int width, int length) {
        Board board = new Board(width, length);
        return board;
    }
}
