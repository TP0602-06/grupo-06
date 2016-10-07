package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;


import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.Node;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.utils.RuleConfig;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RuleFactory {

    private final Board board;
    private RuleDefinitionValidator validRuleDefinitions = new RuleDefinitionValidator();

    public RuleFactory(Board board) {
        this.board = board;
    }

    private Rule createRule(RuleConfig ruleConfig) throws Exception {
        ArrayList<Node> region = new ArrayList<>();
        for (Position pos : ruleConfig.getRegionPositions()) {
            region.add(board.getNode(pos));
        }
        Rule rule = this.validRuleDefinitions.createRule(ruleConfig.getRuleDefinition(), region, ruleConfig.getValue());
        return rule;
    }

    public List<Rule> createRules(List<RuleConfig> ruleConfigs) throws Exception {
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
