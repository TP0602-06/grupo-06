package ar.fiuba.tdd.tp.nikoligames.model.rules.rulesfactories;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.arithmetic.AdditionRule;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;

/**
 * Created by Andres on 14/10/2016.
 */
public class AdditionRuleFactory extends AbstractSingleRuleFactory {

    @Override
    protected Rule createRule(RuleConfig ruleConfig, Board board) {
        return new AdditionRule(this.getRegion(ruleConfig, board), this.getValue(ruleConfig));
    }
}
