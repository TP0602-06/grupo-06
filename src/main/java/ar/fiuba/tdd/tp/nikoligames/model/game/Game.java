package ar.fiuba.tdd.tp.nikoligames.model.game;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.model.board.EdgeAlreadyExistsExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.EdgeNotExistsExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.NotEditableExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.play.NoPlaysException;
import ar.fiuba.tdd.tp.nikoligames.model.play.implemented.DrawablePlay;

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

    void changeNodeValue(Position position, String value) throws NotEditableExpection;

    void createDirectedEdge(Position position1, Position position2) throws EdgeAlreadyExistsExpection;

    void createUndirectedEdge(Position position1, Position position2) throws EdgeAlreadyExistsExpection;

    void removeUndirectedEdge(Position position1, Position position2) throws EdgeNotExistsExpection;

    void removeDirectedEdge(Position position1, Position position2) throws EdgeNotExistsExpection;

    DrawablePlay undoLastPlayMade() throws NoPlaysException;

    DrawableBoard getDrawableBoard();

    Board getBoard();
}
