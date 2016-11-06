package ar.fiuba.tdd.tp.nikoligames.model.rules;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.nodecondition.ValidInputValueRule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.rulesfactories.*;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.RuleConfig;

import java.util.*;

@SuppressWarnings("CPD-START")

public class RulesFactory {
    private final Board board;
    private Map<RuleType, AbstractRuleFactory> hashFactory;

    public RulesFactory(Board board) {
        this.board = board;
        this.hashFactory = new HashMap();

        this.putArithmeticRules();
        this.putCircuitRules();
        this.putNodeConditionRules();
        this.putRegionRules();

        hashFactory.put(RuleType.CONTIGUOS_NODES_NOT_EMPTY_IF_NOT_SAME_REGION, new NextNotEmptyRulesGeneratorFactory());
        hashFactory.put(RuleType.DIAGONAL_VALID_EDGES_GENERATOR, new DiagonalValidEdgesRulesGeneratorFactory());
        hashFactory.put(RuleType.HOR_VER_VALID_EDGES_GENERATOR, new HorizontalVerticalValidEdgesRulesGeneratorFactory());
        hashFactory.put(RuleType.ADDITION.DIAGONAL_CELL_NOT_EMPTY, new DiagonalCellNotEmptyGeneratorFactory());
    }

    public Rule createValidValueRule(Set<String> validInputs) {
        List<AbstractNode> allNodes = board.getAllNodes();
        Rule validInputsRule = new ValidInputValueRule(allNodes, validInputs);
        return validInputsRule;
    }

    public List<Rule> createRules(List<RuleConfig> ruleConfigs) throws NotValidRuleException {
        List<Rule> rules = new ArrayList();
        for (RuleConfig ruleConfig : ruleConfigs) {
            AbstractRuleFactory ruleFactory = getRuleFactory(ruleConfig);
            ruleFactory.createRule(ruleConfig, board, rules);
        }
        return rules;
    }

    protected AbstractRuleFactory getRuleFactory(RuleConfig ruleConfig) {
        RuleType ruleType = ruleConfig.getRuleDefinition();
        return hashFactory.get(ruleType);
    }

    private void putArithmeticRules() {
        this.putRuleFactory(RuleType.ADDITION, new AdditionRuleFactory());
        this.putRuleFactory(RuleType.MULTIPLICATION, new MultiplicationRuleFactory());
    }

    private void putCircuitRules() {
        this.putRuleFactory(RuleType.CONSECUTIVE_NUMBERS_CHAIN, new ConsecutiveNumbersChainRuleFactory());
        this.putRuleFactory(RuleType.EDGES_INTERNAL_TO_REGION_COUNT, new EdgesInternalToRegionCountRuleFactory());
        this.putRuleFactory(RuleType.NO_CYCLE, new NoCycleRuleFactory());
        this.putRuleFactory(RuleType.ONE_CYCLE, new OneCycleRuleFactory());
        this.putRuleFactory(RuleType.REGION_VISITED_AT_MOST_ONCE, new RegionVisitedAtMostOnceRuleFactory());
        this.putRuleFactory(RuleType.REGION_VISITED_COUNT, new RegionVisitedCountRuleFactory());
    }

    private void putNodeConditionRules() {
        this.putRuleFactory(RuleType.ADJACENT, new AdjacentRuleFactory());
        this.putRuleFactory(RuleType.NODE_EDGE_LIST_COUNT, new NodeEdgeListCountRuleFactory());
    }

    private void putRegionRules() {
        this.putRuleFactory(RuleType.CONSECUTIVE_NUMBERS, new ConsecutiveNumbersRuleFactory());
        this.putRuleFactory(RuleType.DISTANCE_BETWEEN_DUPLICATES, new DistanceBetweenDuplicatesRuleFactory());
        this.putRuleFactory(RuleType.NO_DUPLICATES, new NoDuplicatesRuleFactory());
        this.putRuleFactory(RuleType.NON_EMPTY_REGION, new NonEmptyRegionRuleFactory());
    }

    private void putRuleFactory(RuleType type, AbstractRuleFactory ruleFactory) {
        this.hashFactory.put(type, ruleFactory);
    }
}
