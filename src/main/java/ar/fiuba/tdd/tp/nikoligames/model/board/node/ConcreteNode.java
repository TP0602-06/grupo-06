package ar.fiuba.tdd.tp.nikoligames.model.board.node;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.value.AbstractNodeValue;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.value.NodeValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsabilidades: contiene los aspectos generales de cualquier nodo de cualquier juego.
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

    public void changeValue(String newValue) {
        value.setValue(newValue);
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
