package ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteNode contiene los aspectos generales de cualquier celda de cualquier juego.
 */
public class ConcreteNode extends Node {

    protected String value = "";

    protected boolean editable;
    protected List<Node> edgeList = new ArrayList<Node>();

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

    public List<Node> getEdgeList() {
        return edgeList;
    }

    public void addEdge(Node edge) {
        edgeList.add(edge);
    }

    public boolean isReadOnly() {
        return (!editable);
    }


}
