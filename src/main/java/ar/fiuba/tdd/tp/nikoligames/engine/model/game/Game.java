package ar.fiuba.tdd.tp.nikoligames.engine.model.game;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;

/**
 * Created by fedebrasburg on 9/23/16.
 */
public abstract  class Game {
    private Board board;

    public Game(Board board) {
        this.board = board;
    }

    public DrawableBoard getDrawableBoard() {
        DrawableBoard drawableBoard = (DrawableBoard) this.board;
        return drawableBoard;
    }

}
