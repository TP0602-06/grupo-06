package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.edge.EdgeInterface;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.edge.DirectedEdge;
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

public class ConcreteBoard implements DrawableBoard, Board {
    private Size boardSize;

    private Map<Position, AbstractNode> nodeMap = new HashMap<Position, AbstractNode>();

    private Map<EdgePosition, EdgeInterface> edges = new HashMap<EdgePosition, EdgeInterface>();

    public ConcreteBoard(int rows, int cols) throws Exception {
        validateSize(rows, cols);
        boardSize = new Size(rows, cols);
        initializeNodes();
    }

    private void validateSize(int rows, int cols) throws Exception {
        if ((rows <= 0) && (cols <= 0)) {
            throw new Exception("not a valid size");
        }
    }

    public void createUndirectedEdge(Position position1, Position position2) {
        createDirectedEdge(position1, position2);
        createDirectedEdge(position2, position1);
    }

    public void createDirectedEdge(Position position1, Position position2) {
        checkBothPositions(position1, position2);
        EdgePosition edgePosition = new EdgePosition(position1, position2);
        if (edges.containsKey(edgePosition)) {
            return;
        }
        EdgeInterface edge1 = new DirectedEdge(this, position1, position2);
        edges.put(edgePosition, edge1);
    }

    public void checkBothPositions(Position position1, Position position2) {
        checkRange(position1);
        checkRange(position2);
    }

    public void removeUndirectedEdge(Position pos1, Position pos2) {
        removeDirectedEdge(pos2, pos1);
        removeDirectedEdge(pos1, pos2);
    }

    public void removeDirectedEdge(Position position1, Position position2) {
        checkBothPositions(position1, position2);
        EdgePosition edgePosition = new EdgePosition(position1, position2);
        if (edges.containsKey(edgePosition)) {
            EdgeInterface edge = edges.get(edgePosition);
            edge.erase();
        }
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

    @Override
    public String getNodeValue(Position position) {
        AbstractNode node = this.getNode(position);
        return node.getValue();
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



