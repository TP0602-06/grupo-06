package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.rulesfactories;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.circuit.NoNotVisitedAdjacentNodesInSameRegionRule;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andres on 14/10/2016.
 */
public class NoNotVisitedAdjacentNodesInSameRegionRuleFactory extends AbstractSingleRuleFactory {
    @Override
    protected Rule createRule(RuleConfig ruleConfig, Board board) {
        ArrayList<List<AbstractNode>> regionList = this.getRegionList(ruleConfig, board);
        ArrayList<AbstractNode> region = this.getRegion(ruleConfig, board);
        return new NoNotVisitedAdjacentNodesInSameRegionRule(region, regionList);
    }
}
