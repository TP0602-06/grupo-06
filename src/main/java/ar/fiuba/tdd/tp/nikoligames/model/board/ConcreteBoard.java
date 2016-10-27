package ar.fiuba.tdd.tp.nikoligames.model.board;

import ar.fiuba.tdd.tp.nikoligames.model.board.edge.DirectedEdge;
import ar.fiuba.tdd.tp.nikoligames.model.board.edge.EdgeInterface;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.DrawableNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.NotEditableExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;

import java.util.*;

/**
 * Responsabilities:
 * 1. It is the actual implementation for the model of the board , has the same responsabilities as his interface.
 */

public class ConcreteBoard implements DrawableBoard, Board {
    private Size boardSize;

    private Map<Position, AbstractNode> nodeMap = new HashMap<Position, AbstractNode>();

    private Map<EdgePosition, EdgeInterface> edges = new HashMap<EdgePosition, EdgeInterface>();

    public ConcreteBoard(int rows, int cols) throws SizeExpection {
        validateSize(rows, cols);
        boardSize = new Size(rows, cols);
        initializeNodes();
    }

    private void validateSize(int rows, int cols) throws SizeExpection {
        if ((rows <= 0) && (cols <= 0)) {
            throw new SizeExpection();
        }
    }

    public void createUndirectedEdge(Position position1, Position position2) throws EdgeAlreadyExistsExpection {
        createDirectedEdge(position1, position2);
        createDirectedEdge(position2, position1);
    }

    public void removeUndirectedEdge(Position pos1, Position pos2) throws EdgeNotExistsExpection {
        removeDirectedEdge(pos2, pos1);
        removeDirectedEdge(pos1, pos2);
    }

    public void createDirectedEdge(Position position1, Position position2) throws EdgeAlreadyExistsExpection {
        checkBothPositions(position1, position2);
        EdgePosition edgePosition = new EdgePosition(position1, position2);
        if (edges.containsKey(edgePosition)) {
            throw new EdgeAlreadyExistsExpection();
        }
        EdgeInterface edge1 = new DirectedEdge(this, position1, position2);
        edges.put(edgePosition, edge1);
    }

    public void checkBothPositions(Position position1, Position position2) {
        checkRange(position1);
        checkRange(position2);
    }

    public void removeDirectedEdge(Position position1, Position position2) throws EdgeNotExistsExpection {
        checkBothPositions(position1, position2);
        EdgePosition edgePosition = new EdgePosition(position1, position2);
        if (!edges.containsKey(edgePosition)) {
            throw new EdgeNotExistsExpection();
        }
        EdgeInterface edge = edges.get(edgePosition);
        edge.erase();
        edges.remove(edgePosition);

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

    public void setInitialNodeValue(Position position, String value) {
        AbstractNode node = getNodeFromMap(position);
        boolean isEditable = node.isEditable();
        node.setEditable(true);
        try {
            node.changeValue(value);
        } catch (NotEditableExpection notEditableExpection) {
            notEditableExpection.printStackTrace();
        }
        node.setEditable(isEditable);
    }

    public void changeNodeValue(Position position, String value) throws NotEditableExpection {
        AbstractNode node = getNodeFromMap(position);
        node.changeValue(value);
    }

    @Override
    public void clearNodeValue(Position position) throws NotEditableExpection {
        AbstractNode node = getNodeFromMap(position);
        node.clearValue();
    }

    public AbstractNode getNodeFromMap(Position position) {
        checkRange(position);
        return nodeMap.get(position);
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

    @Override
    public Set<EdgePosition> getDrawableEdges() {
        return edges.keySet();
    }

    @Override
    public Map<Position, DrawableNode> getDrawableNodes() {
        Map<Position, DrawableNode> newmap = new HashMap<Position, DrawableNode>();
        nodeMap.forEach((position, drawableNode) -> {
                newmap.put(position, getDrawableNode(position));
            });
        return newmap;
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



