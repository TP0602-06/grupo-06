package ar.fiuba.tdd.tp.nikoligames.model.rules.rulesfactories;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.circuit.EdgesInternalToRegionCountRule;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;

import java.util.List;

/**
 * Created by Andres on 14/10/2016.
 */
public class EdgesInternalToRegionCountRuleFactory extends AbstractSingleRuleFactory {
    @Override
    protected Rule createRule(RuleConfig ruleConfig, Board board) {
        String value = this.getValue(ruleConfig);
        List<AbstractNode> region = this.getRegion(ruleConfig, board);
        return new EdgesInternalToRegionCountRule(region, value);
    }
}
