package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.rulesfactories;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.circuit.RegionVisitedCountRule;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andres on 14/10/2016.
 */
public class RegionVisitedCountRuleFactory extends AbstractSingleRuleFactory {
    @Override
    protected Rule createRule(RuleConfig ruleConfig, Board board) {
        List<AbstractNode> region = getRegion(ruleConfig, board);
        String value = getValue(ruleConfig);
        return new RegionVisitedCountRule(region, value);
    }
}
