package ar.fiuba.tdd.tp.nikoligames.model.rules.rulesfactories;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;

import java.util.List;

/**
 * Created by Andres on 16/10/2016.
 */
public abstract class AbstractSingleRuleFactory extends AbstractRuleFactory {
    protected abstract Rule createRule(RuleConfig ruleConfig, Board board);

    @Override
    public final void createRule(RuleConfig ruleConfig, Board board, List<Rule> rules) {
        rules.add(this.createRule(ruleConfig, board));
    }
}
