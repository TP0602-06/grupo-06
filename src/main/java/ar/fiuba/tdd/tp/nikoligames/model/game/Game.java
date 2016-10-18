package ar.fiuba.tdd.tp.nikoligames.model.game;

import ar.fiuba.tdd.tp.nikoligames.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;

/**
 * Created by german on 10/1/2016.
 * Responsabilites:
 * 1. Interface from a generic game
 * 2. Get board Status gives you the actual state if you are breaking any rules
 * 3. Check win tells you if yo won the game (or not)
 * 4. Gives you the board as seen by the view.
 * 5. Gives you the ability to change the state of the board.
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
