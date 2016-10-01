package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;


import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.AdditionRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.MultiplicationRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.NoDuplicatesRule;

import java.util.ArrayList;
import java.util.HashSet;

public class RuleDefinitionValidator {
    public static final String DO_NOT_REPEAT = "NO_REPITE";
    public static final String SUMA = "SUMA";
    public static final String MULTIPLICATION = "MULTIPLICATION";

    HashSet<String> validRules = new HashSet<>();

    public RuleDefinitionValidator() {
        validRules.add(DO_NOT_REPEAT);
        validRules.add(SUMA);
        validRules.add(MULTIPLICATION);
    }

    public boolean containsRule(String ruleDefinition) {
        return this.validRules.contains(ruleDefinition);
    }

    public Rule createRule(String ruleDefinition, ArrayList<Position> region, String value) throws Exception {
        switch (ruleDefinition) {
            case DO_NOT_REPEAT:
                return new NoDuplicatesRule(region);
            case SUMA:
                return new AdditionRule(region, value);
            case MULTIPLICATION:
                return new MultiplicationRule(region, value);
            default:
                throw new Exception("you should check valid rule definition first");
        }
    }
}
