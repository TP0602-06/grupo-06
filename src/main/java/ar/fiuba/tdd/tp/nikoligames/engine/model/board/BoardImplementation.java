package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.edge.AbstractEdge;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.edge.UndirectedEdge;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.DrawableNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;

import java.util.*;

/**
 * Tablero del juego. Representar la disposicion de celdas.
 * Patron de diseno:
 * 1. Template Method, la clase que implemente la abstracción debe definir la forma de crear una arista de forma dirigida o no dirigida
 */

public class BoardImplementation implements DrawableBoard, Board {
    private Size boardSize;

    private Map<Position, AbstractNode> nodeMap = new HashMap<Position, AbstractNode>();

    private Map<EdgePosition, AbstractEdge> edges = new HashMap<EdgePosition, AbstractEdge>();

    public BoardImplementation(int rows, int cols) {
        boardSize = new Size(rows, cols);
        initializeNodes();
    }

    public boolean createEdge(Position position1, Position position2) {
        EdgePosition edgePosition = new EdgePosition(position1, position2);
        if (edges.containsKey(edgePosition)) {
            return true;
        }
        AbstractEdge edge = new UndirectedEdge(this, position1, position2);
        edges.put(edgePosition, edge);
        return true;
    }

    public boolean removeEdge(Position position1, Position position2) {
        EdgePosition edgePosition = new EdgePosition(position1, position2);
        if (edges.containsKey(edgePosition)) {
            AbstractEdge edge = edges.get(edgePosition);
            edge.erase();
        }
        return true;
    }

    public int getRows() {
        return boardSize.getRows();
    }

    public int getCols() {
        return boardSize.getCols();
    }

    @Override
    public void setEditable(Position position, boolean editable) {
        checkRange(position);
        AbstractNode node = this.nodeMap.get(position);
        node.setEditable(editable);
    }

    public boolean changeNodeValue(Position position, String value) {
        checkRange(position);
        AbstractNode node = nodeMap.get(position);
        if (node.isEditable()) {
            node.changeValue(value);
            return true;
        }
        return false;
    }

    public AbstractNode getNode(Position position) {
        checkRange(position);
        return this.nodeMap.get(position);
    }

    public List<AbstractNode> getAllNodes() {
        Collection<AbstractNode> nodes = this.nodeMap.values();
        List<AbstractNode> nodeList = new ArrayList(nodes);
        return nodeList;
    }

    public DrawableNode getDrawableNode(Position position) {
        return getNode(position);
    }

    public Iterator getPositionIterator() {
        return new BoardPositionIterator(this);
    }

    private void checkRange(Position position) {
        if (!this.nodeMap.containsKey(position)) {
            throw new UnsupportedOperationException();
        }
    }

    private void initializeNodes() {
        for (int row = 1; row <= this.boardSize.getRows(); row++) {
            for (int col = 1; col <= this.boardSize.getCols(); col++) {
                Position newPosition = new ClassicPosition(row, col);
                this.nodeMap.put(newPosition, new ConcreteNode());
            }
        }
    }
}



