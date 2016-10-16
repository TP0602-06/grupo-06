package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;


import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.nodecondition.ValidInputValueRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.rulesfactories.*;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;

import java.util.*;

public class RulesFactory {

    private final Board board;
    private Map<RuleType, AbstractRuleFactory> hashFactory;

    @SuppressWarnings("CPD-START")

    public RulesFactory(Board board) {
        this.board = board;
        this.hashFactory = new HashMap();
        hashFactory.put(RuleType.ADDITION, new AdditionRuleFactory());
        hashFactory.put(RuleType.ADJACENT, new AdjacentRuleFactory());
        hashFactory.put(RuleType.EDGES_INTERNAL_TO_REGION_COUNT, new EdgesInternalToRegionCountRuleFactory());
        hashFactory.put(RuleType.MULTIPLICATION, new MultiplicationRuleFactory());
        hashFactory.put(RuleType.NO_CYCLE, new NoCycleRuleFactory());
        hashFactory.put(RuleType.NODE_EDGE_LIST_COUNT, new NodeEdgeListCountRuleFactory());
        hashFactory.put(RuleType.NO_DUPLICATES, new NoDuplicatesRuleFactory());
        hashFactory.put(RuleType.NON_EMPTY_REGION, new NonEmptyRegionRuleFactory());
        hashFactory.put(RuleType.NO_NOT_VISITED_ADJACENT_NODES_IN_SAME_REGION, new NoNotVisitedAdjacentNodesInSameRegionRuleFactory());
        hashFactory.put(RuleType.ONE_CYCLE, new OneCycleRuleFactory());
        hashFactory.put(RuleType.REGION_VISITED_AT_MOST_ONCE, new RegionVisitedAtMostOnceRuleFactory());
        hashFactory.put(RuleType.REGION_VISITED_COUNT, new RegionVisitedCountRuleFactory());
        hashFactory.put(RuleType.VALID_INPUT, new ValidInputValueRuleFactory());
    }

    @SuppressWarnings("CPD-END")


    public Rule createValidValueRule(HashSet<String> validInputs) {
        List<AbstractNode> allNodes = board.getAllNodes();
        Rule validInputsRule = new ValidInputValueRule(allNodes, validInputs);
        return validInputsRule;
    }


    public List<Rule> createRules(List<RuleConfig> ruleConfigs) throws NotValidRuleException {
        List<Rule> rules = new ArrayList();

        for (RuleConfig ruleConfig : ruleConfigs) {
            AbstractRuleFactory ruleFactory = getRuleFactory(ruleConfig);
            Rule rule = ruleFactory.createRule(ruleConfig, board);
            rules.add(rule);
        }

        return rules;
    }

    protected AbstractRuleFactory getRuleFactory(RuleConfig ruleConfig) {
        RuleType ruleType = ruleConfig.getRuleDefinition();
        return hashFactory.get(ruleType);
    }


}
