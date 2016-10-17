package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.rulesfactories;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;

import java.util.List;

/**
 * Created by Andres on 16/10/2016.
 */
public abstract class AbstractMultipleRuleFactory extends AbstractRuleFactory {
    @Override
    public final void createRule(RuleConfig ruleConfig, Board board, List<Rule> rules) {
        rules.addAll(this.createRules(ruleConfig,board));
    }

    protected abstract List<Rule> createRules(RuleConfig ruleConfig,Board board);
}
