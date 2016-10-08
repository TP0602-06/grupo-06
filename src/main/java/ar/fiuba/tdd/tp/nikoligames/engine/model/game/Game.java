package ar.fiuba.tdd.tp.nikoligames.engine.model.game;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;

/**
 * Created by german on 10/1/2016.
 */
public interface Game {

    void changeNodeValue(Position position, String value);

    boolean checkWin();

    boolean checkActualBoard();


    DrawableBoard getDrawableBoard();

    void createEdge(Position position1, Position position2);
}
