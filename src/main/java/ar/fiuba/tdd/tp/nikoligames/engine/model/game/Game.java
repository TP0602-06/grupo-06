package ar.fiuba.tdd.tp.nikoligames.engine.model.game;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;

/**
 * Created by german on 10/1/2016.
 */
public interface Game {



    boolean checkWin();

    boolean getBoardStatus();

    DrawableBoard getDrawableBoard();

    boolean changeNodeValue(Position position, String value);

    boolean createDirectedEdge(Position position1, Position position2);

    boolean createUndirectedEdge(Position position1, Position position2);

    boolean removeUndirectedEdge(Position position1, Position position2);

    boolean removeDirectedEdge(Position position1, Position position2);
}
