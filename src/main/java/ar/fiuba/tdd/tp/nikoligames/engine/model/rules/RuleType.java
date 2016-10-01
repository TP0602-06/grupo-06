package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.AdditionRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.MultiplicationRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.NoDuplicatesRule;

import java.util.ArrayList;

/**
 * Created by Andres on 01/10/2016.
 */
public enum RuleType {

    DO_NOT_REPEAT("NO_REPITE") {
        public Rule createRule(ArrayList<Position> region, String value) {
            return new NoDuplicatesRule(region);
        }
    }, SUMA("SUMA") {
        public Rule createRule(ArrayList<Position> region, String value) {
            return new AdditionRule(region, value);
        }
    }, MULTIPLICATION("MULTIPLICACION") {
        public Rule createRule(ArrayList<Position> region, String value) {
            return new MultiplicationRule(region, value);
        }

    };

    private final String text;

    private RuleType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public boolean isRule(String string) {
        return this.toString().equals(string);
    }

    public abstract Rule createRule(ArrayList<Position> region, String value);

}
