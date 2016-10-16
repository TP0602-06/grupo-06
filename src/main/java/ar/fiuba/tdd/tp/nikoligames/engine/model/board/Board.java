package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;

import java.util.List;

/**
 * Created by german on 9/30/2016.
 */
public interface Board extends DrawableBoard {
    int getRows();

    int getCols();

    void setEditable(Position position, boolean editable);

    boolean changeNodeValue(Position position, String value);

    boolean createEdge(Position position1, Position position2);

    boolean removeEdge(Position position1, Position position2);

    AbstractNode getNode(Position position);

    List<AbstractNode> getAllNodes();

}
