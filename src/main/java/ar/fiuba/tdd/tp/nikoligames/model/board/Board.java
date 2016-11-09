package ar.fiuba.tdd.tp.nikoligames.model.board;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.NotEditableExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;

import java.util.List;

/**
 * Responsibilities:
 * 1.Its the interface of a squared Board for the model.
 * 2. It contains the nodes
 * 3. Can do operations with the nodes like change their value or create or remove edges from them.
 */
public interface Board extends DrawableBoard {
    int getRows();

    int getCols();

    void setEditable(Position position, boolean editable);

    void setInitialNodeValue(Position position,String value);

    void changeNodeValue(Position position, String value) throws NotEditableExpection;

    void clearNodeValue(Position position) throws NotEditableExpection;

    void createDirectedEdge(Position position1, Position position2) throws EdgeAlreadyExistsExpection;

    AbstractNode getNode(Position position);

    List<AbstractNode> getAllNodes();

    void createUndirectedEdge(Position position1, Position position2) throws EdgeAlreadyExistsExpection;

    void removeUndirectedEdge(Position position1, Position position2) throws EdgeNotExistsExpection;

    void removeDirectedEdge(Position position1, Position position2) throws EdgeNotExistsExpection;



}
