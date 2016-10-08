package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;

import java.util.List;

/**
 * Created by german on 9/30/2016.
 */
public interface Board extends DrawableBoard {
    int getRows();

    int getCols();

    void setNode(Position position, AbstractNode cell);

    boolean changeNodeValue(Position position, String value);

    void createEdge(Position position1, Position position2);

    AbstractNode getNode(Position position);

    List<AbstractNode> getAllNodes();
}
