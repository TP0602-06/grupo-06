package ar.fiuba.tdd.tp.nikoligames.model.rules.rulesfactories;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andres on 14/10/2016.
 */
public abstract class AbstractRuleFactory {
    public abstract void createRule(RuleConfig ruleConfig, Board board, List<Rule> rules);

    protected List<AbstractNode> getRegion(RuleConfig ruleConfig, Board board) {
        if (ruleConfig.getRegionPositions().size() == 0) {
            return board.getAllNodes();
        }
        return getNodesFromPositionList(ruleConfig.getRegionPositions(), board);
    }

    protected ArrayList<List<AbstractNode>> getRegionList(RuleConfig ruleConfig, Board board) {
        List<List<Position>> regionListPosition = ruleConfig.getRegionListPositions();
        ArrayList<List<AbstractNode>> regionListNode = new ArrayList<List<AbstractNode>>();
        for (List<Position> positionList : regionListPosition) {
            regionListNode.add(this.getNodesFromPositionList(positionList, board));
        }
        return regionListNode;

    }

    protected ArrayList<AbstractNode> getAdjacents(RuleConfig ruleConfig, Board board) {
        return getNodesFromPositionList(ruleConfig.getAdjacentPositions(), board);
    }

    private ArrayList<AbstractNode> getNodesFromPositionList(List<Position> positions, Board board) {
        ArrayList<AbstractNode> region = new ArrayList<>();
        for (Position pos : positions) {
            region.add(board.getNode(pos));
        }
        return region;
    }

    protected String getValue(RuleConfig ruleConfig) {
        return ruleConfig.getValue();
    }
}
