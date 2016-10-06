package ar.fiuba.tdd.tp.nikoligames.engine.model.board.node;

import java.util.List;

/**
 * Created by fedebrasburg on 10/6/16.
 */
public abstract class Node implements DrawableNode {


    public Node() {

    }

    public abstract String getValue();

    public abstract void setValue(String value);

    public abstract boolean isEmpty();

    public abstract boolean isEditable();

    public abstract List<Node> getEdgeList();

    public abstract void addEdge(Node edge);

}
