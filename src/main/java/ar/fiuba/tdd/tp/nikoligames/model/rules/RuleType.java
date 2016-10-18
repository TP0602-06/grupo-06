package ar.fiuba.tdd.tp.nikoligames.model.rules;

/**
 * Created by Andres on 01/10/2016.
 */
public enum RuleType {
    ADDITION("ADDITION"),
    ADJACENT("ADJACENT"),
    CONTIGUOS_NODES_NOT_EMPTY_IF_NOT_SAME_REGION("CONTIGUOS_NODES_NOT_EMPTY_IF_NOT_SAME_REGION"),
    DIAGONAL_VALID_EDGES_GENERATOR("DIAGONAL_VALID_EDGES_GENERATOR"),
    EDGES_INTERNAL_TO_REGION_COUNT("EDGES_INTERNAL_TO_REGION_COUNT"),
    HOR_VER_VALID_EDGES_GENERATOR("HOR_VER_VALID_EDGES_GENERATOR"),
    MULTIPLICATION("MULTIPLICACION"),
    NO_CYCLE("NO_CYCLE"),
    NODE_EDGE_LIST_COUNT("NODE_EDGE_LIST_COUNT"),
    NO_DUPLICATES("NO_DUPLICATES"),
    NON_EMPTY_REGION("NON_EMPTY_REGION"),
    ONE_CYCLE("ONE_CYCLE"),
    REGION_VISITED_AT_MOST_ONCE("REGION_VISITED_AT_MOST_ONCE"),
    REGION_VISITED_COUNT("REGION_VISITED_COUNT");

    private final String text;

    RuleType(final String text) {
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