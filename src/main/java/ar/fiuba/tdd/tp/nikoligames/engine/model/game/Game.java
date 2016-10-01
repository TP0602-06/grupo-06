package ar.fiuba.tdd.tp.nikoligames.engine.model.game;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;

import java.util.HashSet;

/**
 * Created by german on 10/1/2016.
 */
public interface Game {

    void playMove(Position position, String value) throws Exception;

    String getGameName();

    boolean checkRules();

    DrawableBoard getDrawableBoard();

    HashSet<String> getValidInputs();
}
