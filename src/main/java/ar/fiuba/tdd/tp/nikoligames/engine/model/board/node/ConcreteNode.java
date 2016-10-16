package ar.fiuba.tdd.tp.nikoligames.engine.model.board.node;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.value.AbstractNodeValue;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.value.NodeValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsabilidades: contiene los aspectos generales de cualquier nodo de cualquier juego.
 */
public class ConcreteNode extends AbstractNode {

    protected AbstractNodeValue value;

    protected boolean editable = false;

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

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        ConcreteNode that = (ConcreteNode) obj;

        if (editable != that.editable) {
            return false;
        }
        if (value != null ? !value.equals(that.value) : that.value != null) {
            return false;
        }
        return edgeList != null ? edgeList.equals(that.edgeList) : that.edgeList == null;

    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (editable ? 1 : 0);
        result = 31 * result + (edgeList != null ? edgeList.hashCode() : 0);
        return result;
    }
}
