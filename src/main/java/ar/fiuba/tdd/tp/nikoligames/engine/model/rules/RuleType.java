package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.NoDuplicatesRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.NonEmptyRegionRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.circuit.OneCycleRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.arithmetic.AdditionRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.arithmetic.MultiplicationRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.nodecondition.AdjacentRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.circuit.RegionVisitedCountRule;

import java.util.ArrayList;

/**
 * Created by Andres on 01/10/2016.
 */
public enum RuleType {
    @SuppressWarnings("CPD-START")
    DO_NOT_REPEAT("NO_REPITE") {
        public Rule createRule(ArrayList<AbstractNode> nodes, ArrayList<AbstractNode> adjacentNodes, String value) {
            return new NoDuplicatesRule(nodes);
        }
    }, SUMA("SUMA") {
        public Rule createRule(ArrayList<AbstractNode> nodes, ArrayList<AbstractNode> adjacentNodes, String value) {
            return new AdditionRule(nodes, value);
        }
    }, MULTIPLICATION("MULTIPLICACION") {
        public Rule createRule(ArrayList<AbstractNode> nodes, ArrayList<AbstractNode> adjacentNodes, String value) {
            return new MultiplicationRule(nodes, value);
        }
    }, ADJACENT("ADYACENTE") {
        public Rule createRule(ArrayList<AbstractNode> nodes, ArrayList<AbstractNode> adjacentNodes, String value) {
            return new AdjacentRule(nodes, adjacentNodes);
        }
    }, VISITEDDCOUNTRULE("CUENTAVISITADOS") {
        public Rule createRule(ArrayList<AbstractNode> nodes, ArrayList<AbstractNode> adjacentNodes, String value) {
            return new RegionVisitedCountRule(nodes, value);
        }
    }, NONEMPTY("NOVACIO") {
        public Rule createRule(ArrayList<AbstractNode> nodes, ArrayList<AbstractNode> adjacentNodes, String value) {
            return new NonEmptyRegionRule(nodes);
        }
    }, UniqueClosedCircuitRule("UNICOCIRCUITOCERRADO") {
        public Rule createRule(ArrayList<AbstractNode> nodes, ArrayList<AbstractNode> adjacentNodes, String value) {
            return new OneCycleRule(nodes);
        }
    };
    @SuppressWarnings("CPD-END")
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

    public abstract Rule createRule(ArrayList<AbstractNode> cells, ArrayList<AbstractNode> adjacentNodes, String value);
}
