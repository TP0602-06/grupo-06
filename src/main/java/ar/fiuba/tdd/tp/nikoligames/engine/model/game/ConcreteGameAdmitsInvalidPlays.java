package ar.fiuba.tdd.tp.nikoligames.engine.model.game;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.List;

/**
 * Created by german on 10/16/2016.
 */
public class ConcreteGameAdmitsInvalidPlays extends GameImplementation {
    public ConcreteGameAdmitsInvalidPlays(Board board, List<Rule> rules) {
        super(board, rules);
    }

    public void changeNodeValue(Position position, String value) {
        board.changeNodeValue(position, value);
    }

    @Override
    public boolean createDirectedEdge(Position position1, Position position2) {
        board.createDirectedEdge(position1, position2);
        return true;
    }

    @Override
    public boolean createUndirectedEdge(Position position1, Position position2) {
        board.createUndirectedEdge(position1, position2);
        return true;
    }

    @Override
    public boolean removeUndirectedEdge(Position position1, Position position2) {
        board.removeUndirectedEdge(position1, position2);
        return true;
    }

    @Override
    public boolean removeDirectedEdge(Position position1, Position position2) {
        board.removeDirectedEdge(position1, position2);
        return true;
    }
}
