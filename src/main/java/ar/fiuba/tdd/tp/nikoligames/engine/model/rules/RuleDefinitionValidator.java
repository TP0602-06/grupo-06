package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;


import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.AdditionRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.MultiplicationRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.NoDuplicatesRule;

import java.util.ArrayList;
import java.util.HashSet;

public class RuleDefinitionValidator {
    public static final String DO_NOT_REPEAT = "NO_REPITE";
    public static final String SUMA = "SUMA";
    public static final String MULTIPLICATION = "MULTIPLICACION";

    HashSet<String> validRules = new HashSet<String>();

    public RuleDefinitionValidator() {
        validRules.add(DO_NOT_REPEAT);
        validRules.add(SUMA);
        validRules.add(MULTIPLICATION);
    }

    public boolean containsRule(String ruleDefinition) {
        return this.validRules.contains(ruleDefinition);
    }

    public Rule createRule(String ruleDefinition, ArrayList<AbstractCell> listOfCell, String value) throws Exception {
        switch (ruleDefinition) {
            case DO_NOT_REPEAT:
                return new NoDuplicatesRule(listOfCell);
            case SUMA:
                return new AdditionRule(listOfCell, value);
            case MULTIPLICATION:
                return new MultiplicationRule(listOfCell, value);
            default:
                throw new Exception("you should check valid rule definition first");
        }
    }
}
