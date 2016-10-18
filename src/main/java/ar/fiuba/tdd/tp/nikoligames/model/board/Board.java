package ar.fiuba.tdd.tp.nikoligames.model.board;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;

import java.util.List;

/**
 * Created by german on 9/30/2016.
 */
public interface Board extends DrawableBoard {
    int getRows();

    int getCols();

    void setEditable(Position position, boolean editable);

    void setInitialNodeValue(Position position,String value);

    boolean changeNodeValue(Position position, String value);

    void createDirectedEdge(Position position1, Position position2);

    void createUndirectedEdge(Position position1, Position position2);

    void removeUndirectedEdge(Position position1, Position position2);

    void removeDirectedEdge(Position position1, Position position2);

    AbstractNode getNode(Position position);

    String getNodeValue(Position position);


    List<AbstractNode> getAllNodes();

}
