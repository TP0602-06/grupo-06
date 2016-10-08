package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.generators;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.regionrules.AdjacentRule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 10/7/2016.
 */
public class HorizontalVerticalAdjacentRules implements AbstractAdjacentRules {
    private final Board board;

    public HorizontalVerticalAdjacentRules(Board board) {
        this.board = board;
    }

    public List<Rule> getAdjacentRules() {
        List<Rule> rulesGenerated = new ArrayList<Rule>();

        for (int i = 1; i <= board.getRows(); i++) {
            for (int j = 1; j <= board.getCols(); j++) {
                ClassicPosition position = new ClassicPosition(i, j);
                AbstractNode node = board.getNode(position);

                List<AbstractNode> region = new ArrayList<AbstractNode>();
                region.add(node);

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

                Rule rule = new AdjacentRule(region,adjacentList);
                rulesGenerated.add(rule);
            }
        }
        return rulesGenerated;
    }
}
