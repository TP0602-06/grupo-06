package ar.fiuba.tdd.tp.nikoligames.model.board.boardcommandaction;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;

/**
 * Created by Andres on 16/10/2016.
 * Responsibilities:
 * 1.Create a directed edge from position 1 to position 2
 */
public class CreateDirectedEdgeCommand extends BoardCommandAction {
    @Override
    public void execute(Board board, Position position1, Position position2) {
        board.createDirectedEdge(position1, position2);
    }
}
