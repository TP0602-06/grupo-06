package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;


import ar.fiuba.tdd.tp.nikoligames.engine.model.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.AdditionRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.MultiplicationRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.NoDuplicatesRule;

import java.util.ArrayList;
import java.util.HashSet;

public class RuleDefinitionValidator {
    public static final String NO_REPITE = "NO_REPITE";
    public static final String SUMA = "SUMA";
    public static final String MULTIPLICACION = "MULTIPLICACION";

    HashSet<String> validRules = new HashSet<>();

    public RuleDefinitionValidator(){
        validRules.add(NO_REPITE);
        validRules.add(SUMA);
        validRules.add(MULTIPLICACION);
    }

    public boolean containsRule(String ruleDefinition){
        return this.validRules.contains(ruleDefinition);
    }

    public Rule createRule(String ruleDefinition, ArrayList<Position> region, String value) throws Exception {
        switch (ruleDefinition) {
            case NO_REPITE:
                return new NoDuplicatesRule(region);
            case SUMA:
                return new AdditionRule(region, value);
            case MULTIPLICACION:
                return new MultiplicationRule(region, value);
            default: throw new Exception("you should check valid rule definition first");
        }
    }
}
