package ar.fiuba.tdd.tp.nikoligames.model.board.node;

import java.util.List;

/**

 * Responsibilities:
 * 1. Represents a node or a cell from the board
 * 2. It saves a value
 * 3. It can also be connected by edges to any other node. Knows to which nodes, it is connected.
 * 4. Knows his state if it is invalid, empty or editable.
 *
 * */
public abstract class AbstractNode implements DrawableNode {

    public abstract String getValue();

    public abstract int getIntValue();

    public abstract void changeValue(String value);

    public abstract boolean isInvalid();

    public abstract boolean isEmpty();

    public abstract boolean isEditable();

    public abstract void setEditable(boolean editable);

    public abstract List<AbstractNode> getEdgeList();

    public abstract void addEdge(AbstractNode edge);

    public abstract void removeEdge(AbstractNode node);


}
