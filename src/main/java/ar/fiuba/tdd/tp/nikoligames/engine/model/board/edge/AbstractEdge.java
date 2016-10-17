package ar.fiuba.tdd.tp.nikoligames.engine.model.board.edge;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;

/**
 * Created by Andres on 16/10/2016.
 */
public abstract class AbstractEdge implements EdgeInterface {
    protected AbstractNode node1;
    protected AbstractNode node2;

    public AbstractEdge(AbstractNode node1, AbstractNode node2) {
        this.node1 = node1;
        this.node2 = node2;
        this.create();
    }

    public AbstractEdge(Board board, Position position1, Position position2) {
        node1 = board.getNode(position1);
        node2 = board.getNode(position2);
        this.create();

    }

    protected abstract void create();
}
