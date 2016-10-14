package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.rulesfactories;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.nodecondition.ValidInputValueRule;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Andres on 14/10/2016.
 */
public class ValidInputValueRuleFactory extends AbstractRuleFactory {

    @Override
    public Rule createRule(RuleConfig ruleConfig, Board board) {
        ArrayList<AbstractNode> region = this.getRegion(ruleConfig, board);
        HashSet<String> validInputs = this.getValidInputs(ruleConfig);
        return new ValidInputValueRule(region, validInputs);
    }
}
