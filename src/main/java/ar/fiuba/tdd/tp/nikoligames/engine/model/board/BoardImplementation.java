package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.DrawableNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.MatrixPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Tablero del juego. Representar la disposicion de celdas.
 * Patron de diseno:
 * 1. Template Method, la clase que implemente la abstracción debe definir la forma de crear una arista de forma dirigida o no dirigida
 */

public abstract class BoardImplementation implements DrawableBoard, Board {
    private int rows;
    private int cols;
    private AbstractNode[][] nodes;

    public BoardImplementation(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.nodes = new ConcreteNode[this.rows][this.cols];
    }

    abstract void createEdge(AbstractNode node1, AbstractNode node2);

    public void createEdge(Position position1, Position position2) {
        AbstractNode node1 = this.getNode(position1);
        AbstractNode node2 = this.getNode(position2);

        createEdge(node1, node2);
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void setNode(Position position, AbstractNode node) {
        checkRange(position);
        nodes[position.getRow()][position.getColumn()] = node;
    }

    public boolean changeNodeValue(Position position, String value) {
        checkRange(position);
        AbstractNode node = nodes[position.getRow()][position.getColumn()];
        if (node.isEditable()) {
            node.setValue(value);
            return true;
        }
        return false;
    }

    public AbstractNode getNode(Position position) {
        checkRange(position);
        return nodes[position.getRow()][position.getColumn()];
    }

    public List<AbstractNode> getAllNodes() {
        List<AbstractNode> allNodes = new ArrayList<AbstractNode>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Position position = new MatrixPosition(i, j);
                AbstractNode node = this.getNode(position);
                allNodes.add(node);
            }
        }
        return allNodes;
    }

    public DrawableNode getDrawableNode(Position position) {
        return getNode(position);
    }

    public Iterator getPositionIterator() {
        return new BoardPositionIterator(this);
    }

    private boolean outOfRange(Position position) {
        int row = position.getRow();
        int col = position.getColumn();
        return !((0 <= col) && (col < cols) && (0 <= row) && (row < rows));
    }

    private void checkRange(Position position) {
        if (outOfRange(position)) {
            throw new UnsupportedOperationException();
        }
    }


}



