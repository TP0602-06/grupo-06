package ar.fiuba.tdd.tp.nikoligames.engine.model.board.node;

import java.util.List;

/**
 * Created by fedebrasburg on 10/6/16.
 */
public abstract class AbstractNode implements DrawableNode {


    public AbstractNode() {

    }

    public abstract String getValue();

    public abstract void setValue(String value);

    public abstract boolean isEmpty();

    public abstract boolean isEditable();

    public abstract List<AbstractNode> getEdgeList();

    public abstract void addEdge(AbstractNode edge);


}