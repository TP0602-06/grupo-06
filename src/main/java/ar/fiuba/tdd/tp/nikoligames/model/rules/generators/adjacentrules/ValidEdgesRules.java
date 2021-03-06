package ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentrules;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.nodecondition.AdjacentRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by german on 10/9/2016.
 * Responsibilites:
 * 1. Creates a list of adjacent Rules
 */
public class ValidEdgesRules extends AbstractAdjacentRulesGenerator {

    public ValidEdgesRules(Map<AbstractNode, List<AbstractNode>> adjacentList) {
        super(adjacentList);
    }

    void createRule(AbstractNode node, List<AbstractNode> nodeAdjacentList, List<Rule> rulesGenerated) {
        List<AbstractNode> ruleRegion = new ArrayList<AbstractNode>();
        ruleRegion.add(node);
        Rule rule = new AdjacentRule(ruleRegion, nodeAdjacentList);
        rulesGenerated.add(rule);

    }
}
