package ar.fiuba.tdd.tp.nikoligames.model.game;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.model.board.boardcommandaction.*;

import java.util.List;

/**
 * Created by german on 10/16/2016.
 */
public class ConcreteGameAdmitsInvalidPlays extends GameImplementation {
    public ConcreteGameAdmitsInvalidPlays(Board board, List<Rule> rules) {
        super(board, rules);
    }

    @Override
    public boolean changeNodeValue(Position position, String value) {
        board.changeNodeValue(position, value);
        return true;
    }

    @Override
    public boolean createDirectedEdge(Position position1, Position position2) {
        return this.boardAction(position1, position2, new CreateDirectedEdgeCommand());
    }

    @Override
    public boolean createUndirectedEdge(Position position1, Position position2) {
        return this.boardAction(position1, position2, new CreateUndirectedEdgeCommand());

    }

    @Override
    public boolean removeUndirectedEdge(Position position1, Position position2) {
        return this.boardAction(position1, position2, new RemoveUndirectedEdgeCommand());
    }


    @Override
    public boolean removeDirectedEdge(Position position1, Position position2) {
        return this.boardAction(position1, position2, new RemoveDirectedEdgeCommand());
    }

    protected boolean boardAction(Position pos1, Position pos2, BoardCommandAction boardAction) {
        boardAction.execute(board, pos1, pos2);
        return true;
    }


}
