package ar.fiuba.tdd.tp.nikoligames.model.board.boardcommandaction;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;

/**
 * Created by Andres on 16/10/2016.
 */
public class RemoveUndirectedEdgeCommand extends BoardCommandAction {
    @Override
    public void execute(Board board, Position position1, Position position2) {
        board.removeUndirectedEdge(position1,position2);
    }
}
