package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;


import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.ValidInputValueRule;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class RuleFactory {

    private final Board board;

    public RuleFactory(Board board) {
        this.board = board;
    }

    public Rule createValidValueRule(HashSet<String> validInputs) {
        List<AbstractNode> allNodes = board.getAllNodes();
        Rule validInputsRule = new ValidInputValueRule(allNodes,validInputs);
        return null;
    }

    private Rule createRule(RuleConfig ruleConfig) throws NotValidRuleException {
        ArrayList<AbstractNode> region = new ArrayList<>();
        for (Position pos : ruleConfig.getRegionPositions()) {
            region.add(board.getNode(pos));
        }

        RuleType ruleDefinition = RuleType.getRuleType(ruleConfig.getRuleDefinition());
        Rule rule = ruleDefinition.createRule(region, ruleConfig.getValue());
        return rule;
    }

    public List<Rule> createRules(List<RuleConfig> ruleConfigs) throws NotValidRuleException {
        List<Rule> rules = new ArrayList<Rule>();

        Iterator<RuleConfig> ruleConfigIterator = ruleConfigs.iterator();
        while (ruleConfigIterator.hasNext()) {
            RuleConfig ruleConfig = ruleConfigIterator.next();

            Rule rule = this.createRule(ruleConfig);
            rules.add(rule);
        }
        return rules;
    }


}
