package ar.fiuba.tdd.tp.nikoligames.engine.model.board.node;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteNode contiene los aspectos generales de cualquier celda de cualquier juego.
 */
public class ConcreteNode extends AbstractNode {

    protected String value = "";

    protected boolean editable;
    protected List<AbstractNode> edgeList = new ArrayList<AbstractNode>();

    public ConcreteNode(String value, boolean editable) {
        this.value = value;
        this.editable = editable;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return (this.value.equals(""));
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

    public boolean isReadOnly() {
        return (!editable);
    }
}
