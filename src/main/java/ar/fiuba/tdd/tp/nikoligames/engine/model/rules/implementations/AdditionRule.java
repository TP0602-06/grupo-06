package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleDefinitionValidator;

import java.util.ArrayList;

/**
 * Created by german on 9/30/2016.
 */
public class AdditionRule extends ArithmeticRule {
    private static final int defaultValue = 0;

    public AdditionRule(ArrayList<Position> region, String value) {
        super(region, value);
    }

    @Override
    public String getDefinition() {
        return RuleDefinitionValidator.SUMA;
    }

    protected int arithmeticOperation(int operationAcumulator, Cell cell) {
        int value = Integer.parseInt(this.value);
        operationAcumulator += value;
        return operationAcumulator;
    }

    ;

    protected int defaultIntValue() {
        return defaultValue;
    }

    ;
}
