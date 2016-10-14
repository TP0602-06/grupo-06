package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

/**
 * Created by Andres on 01/10/2016.
 */
public enum RuleType {
    DO_NOT_REPEAT("DO_NOT_REPEAT"), ADDITION("ADDITION"), MULTIPLICATION("MULTIPLICACION"), ADJACENT("ADYACENTE"),
    EDGES_INTERNAL_TO_REGION_COUNT("EDGES_INTERNAL_TO_REGION_COUNT"),NO_CYCLE("NO_CYCLE"),NODE_EDGE_LIST_COUNT("NODE_EDGE_LIST_COUNT"),
    NO_DUPLICATES("NO_DUPLICATES"),NON_EMPTY_REGION("NON_EMPTY_REGION"),
    NO_NOT_VISITED_ADJACENT_NODES_IN_SAME_REGION("NO_NOT_VISITED_ADJACENT_NODES_IN_SAME_REGION"),
    ONE_CYCLE("ONE_CYCLE"),REGION_VISITED_AT_MOST_ONCE("REGION_VISITED_AT_MOST_ONCE"),REGION_VISITED_COUNT("REGION_VISITED_COUNT"),
    VALID_INPUT("VALID_INPUT");
    private final String text;

    private RuleType(final String text) {
        this.text = text;
    }

    public static RuleType getRuleType(String ruleDefinition) throws NotValidRuleException {
        for (RuleType ruleType : RuleType.values()) {
            if (ruleType.isRule(ruleDefinition)) {
                return ruleType;
            }
        }
        throw new NotValidRuleException();
    }

    @Override
    public String toString() {
        return text;
    }

    public boolean isRule(String string) {
        return this.toString().equals(string);
    }

}
