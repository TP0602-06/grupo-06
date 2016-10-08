package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.generators;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 10/7/2016.
 */
public class HorizontalVerticalAdjacentRules extends BoardAdjacentRules {

    public HorizontalVerticalAdjacentRules(Board board) {
        super(board);
    }
    List<AbstractNode> getAjacentListForNode(int i, int j) {
        List<AbstractNode> adjacentList = new ArrayList<AbstractNode>();

        if( (j-1) > 0 ){
            ClassicPosition positionAdjacentLeft = new ClassicPosition(i, j - 1);
            AbstractNode nodeHorizontalLeft = board.getNode(positionAdjacentLeft);
            adjacentList.add(nodeHorizontalLeft);
        }
        if( (j + 1) < board.getRows() ){
            ClassicPosition positionAdjacentRight = new ClassicPosition(i, j + 1);
            AbstractNode nodeHorizontalRight = board.getNode(positionAdjacentRight);
            adjacentList.add(nodeHorizontalRight);
        }
        if( (i-1) > 0 ){
            ClassicPosition positionAdjacentTop = new ClassicPosition(i - 1, j);
            AbstractNode nodeVerticalTop = board.getNode(positionAdjacentTop);
            adjacentList.add(nodeVerticalTop);
        }
        if( (i + 1) < board.getRows() ){
            ClassicPosition positionAdjacentBottom = new ClassicPosition(i + 1, j);
            AbstractNode nodeVerticalBottom = board.getNode(positionAdjacentBottom);
            adjacentList.add(nodeVerticalBottom);
        }
        return adjacentList;
    }
}
