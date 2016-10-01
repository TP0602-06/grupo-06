package ar.fiuba.tdd.tp.nikoligames.engine.model;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;

/**
 * Created by german on 10/1/2016.
 */
public interface Game {

    void playMove(Coordinates position, String value) throws Exception;
    String getGameName();
    boolean checkRules();
    DrawableBoard getDrawableBoard();
}
