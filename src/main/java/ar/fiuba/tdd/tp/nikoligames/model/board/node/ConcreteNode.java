package ar.fiuba.tdd.tp.nikoligames.model.board.node;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsibilities:
 * 1. It is the implementation of an abstract node and haas the same resposabilites.
 */
public class ConcreteNode extends AbstractNode {

    public static final boolean DEFAULT_EDITABLE = true;
    protected AbstractNodeValue value;

    protected boolean editable = DEFAULT_EDITABLE;

    protected List<AbstractNode> edgeList = new ArrayList<AbstractNode>();

    public ConcreteNode(String value, boolean editable) {
        this.value = new NodeValue(value);
        this.editable = editable;
    }

    public ConcreteNode() {
        this.value = new NodeValue();
    }

    public String getValue() {
        return value.getValue();
    }

    @Override
    public int getIntValue() {
        return value.getIntValue();
    }

    public void changeValue(String newValue) throws NotEditableExpection {
        checkEditable();
        value.setValue(newValue);
    }

    public void checkEditable() throws NotEditableExpection {
        if (!this.isEditable()) {
            throw new NotEditableExpection();
        }
    }

    @Override
    public void clearValue() throws NotEditableExpection {
        checkEditable();
        this.value.clearValue();
    }

    @Override
    public boolean isInvalid() {
        return (!isEditable() && (isEmpty()));
    }

    public boolean isEmpty() {
        return value.isEmpty();
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public List<AbstractNode> getEdgeList() {
        return edgeList;
    }

    public void addEdge(AbstractNode edge) {
        edgeList.add(edge);
    }

    @Override
    public void removeEdge(AbstractNode node) {
        edgeList.remove(node);
    }

}
