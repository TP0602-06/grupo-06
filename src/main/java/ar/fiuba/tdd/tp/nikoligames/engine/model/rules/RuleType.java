package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.NoDuplicatesRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.arithmeticrules.AdditionRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.arithmeticrules.MultiplicationRule;

import java.util.ArrayList;

/**
 * Created by Andres on 01/10/2016.
 */
public enum RuleType {

    DO_NOT_REPEAT("NO_REPITE") {
        public Rule createRule(ArrayList<AbstractNode> nodes, String value) {
            return new NoDuplicatesRule(nodes);
        }
    }, SUMA("SUMA") {
        public Rule createRule(ArrayList<AbstractNode> nodes, String value) {
            return new AdditionRule(nodes, value);
        }
    }, MULTIPLICATION("MULTIPLICACION") {
        public Rule createRule(ArrayList<AbstractNode> nodes, String value) {
            return new MultiplicationRule(nodes, value);
        }

    };

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

    public abstract Rule createRule(ArrayList<AbstractNode> cells, String value);
}
