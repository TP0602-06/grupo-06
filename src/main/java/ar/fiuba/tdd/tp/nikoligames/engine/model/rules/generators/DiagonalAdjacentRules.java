package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.generators;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 10/8/2016.
 */
public class DiagonalAdjacentRules extends BoardAdjacentRules {

    public DiagonalAdjacentRules(Board board) {
        super(board);
    }

    List<AbstractNode> getAjacentListForNode(int i, int j) {
        List<AbstractNode> adjacentList = new ArrayList<AbstractNode>();

        if (((i - 1) > 0) && ((j - 1)) > 0) {
            ClassicPosition positionAdjacentTopLeft = new ClassicPosition(i - 1, j - 1);
            AbstractNode nodeTopLeft = board.getNode(positionAdjacentTopLeft);
            adjacentList.add(nodeTopLeft);
        }
        if (((i + 1) > 0) && ((j - 1)) > 0) {
            ClassicPosition positionAdjacentBottomLeft = new ClassicPosition(i + 1, j - 1);
            AbstractNode nodeBottomLeft = board.getNode(positionAdjacentBottomLeft);
            adjacentList.add(nodeBottomLeft);
        }
        if (((i - 1) > 0) && ((j + 1)) > 0) {
            ClassicPosition positionAdjacentTopRight = new ClassicPosition(i - 1, j + 1);
            AbstractNode nodeTopRight = board.getNode(positionAdjacentTopRight);
            adjacentList.add(nodeTopRight);
        }
        if (((i + 1) > 0) && ((j + 1)) > 0) {
            ClassicPosition positionAdjacentBottomRight = new ClassicPosition(i + 1, j + 1);
            AbstractNode nodeBottomRight = board.getNode(positionAdjacentBottomRight);
            adjacentList.add(nodeBottomRight);
        }
        return adjacentList;
    }
}
