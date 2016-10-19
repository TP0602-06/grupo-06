package ar.fiuba.tdd.tp.nikoligames.model.game;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.boardcommandaction.*;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.rules.Rule;

import java.util.List;

/**
 * Created by german on 10/16/2016.
 * Resposabilities:
 * 1. Game implementation that does not admit invalids plays.
 */
public class ConcreteGameAdmitsNoInvalidPlays extends GameImplementation {
    public ConcreteGameAdmitsNoInvalidPlays(Board board, List<Rule> rules) {
        super(board, rules);
    }

    @Override
    public boolean changeNodeValue(Position position, String value) {
        String oldValue = board.getNodeValue(position);
        board.changeNodeValue(position, value);
        if (!super.getBoardStatus()) {
            board.changeNodeValue(position, oldValue);
            return false;
        }
        return true;
    }

    @Override
    public boolean createDirectedEdge(Position position1, Position position2) {
        return this.boardAction(position1, position2, new CreateDirectedEdgeCommand(), new RemoveDirectedEdgeCommand());
    }

    @Override
    public boolean createUndirectedEdge(Position position1, Position position2) {
        return this.boardAction(position1, position2, new CreateUndirectedEdgeCommand(), new RemoveUndirectedEdgeCommand());
    }

    @Override
    public boolean removeUndirectedEdge(Position position1, Position position2) {
        return this.boardAction(position1, position2, new RemoveUndirectedEdgeCommand(), new CreateUndirectedEdgeCommand());
    }

    @Override
    public boolean removeDirectedEdge(Position position1, Position position2) {
        return this.boardAction(position1, position2, new RemoveDirectedEdgeCommand(), new CreateDirectedEdgeCommand());
    }

    protected boolean boardAction(Position pos1, Position pos2, BoardCommandAction boardAction, BoardCommandAction reverseAction) {
        boardAction.execute(board, pos1, pos2);
        if (!super.getBoardStatus()) {
            reverseAction.execute(board, pos1, pos2);
            return false;
        }
        return true;
    }
}

