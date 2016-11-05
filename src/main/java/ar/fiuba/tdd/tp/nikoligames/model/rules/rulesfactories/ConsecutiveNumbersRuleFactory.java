package ar.fiuba.tdd.tp.nikoligames.model.rules.rulesfactories;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.region.ConsecutiveNumbersRule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.region.NonEmptyRegionRule;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;

import java.util.List;

/**
 * Created by matias on 05/11/16.
 */
public class ConsecutiveNumbersRuleFactory extends AbstractSingleRuleFactory {
    @Override
    protected Rule createRule(RuleConfig ruleConfig, Board board) {
        List<AbstractNode> region = this.getRegion(ruleConfig, board);
        return new ConsecutiveNumbersRule(region);
    }
}
