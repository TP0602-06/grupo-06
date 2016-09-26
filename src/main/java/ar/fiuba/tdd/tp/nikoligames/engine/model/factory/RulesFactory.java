package ar.fiuba.tdd.tp.nikoligames.engine.model.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.CellInterface;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.AdditionRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.NoDuplicatesRule;

import java.util.ArrayList;


public class RulesFactory implements RuleAbstractFactory {

    private static RulesFactory instance = null;

    private RulesFactory() {
    }

    public Rule createAdditionRule(int sum, ArrayList<CellInterface> cells) {
        return new AdditionRule(sum, cells);
    }

    public Rule createNoDuplicatesRule(ArrayList<CellInterface> cells) {
        return new NoDuplicatesRule(cells);
    }

    //Singleton
    public static RuleAbstractFactory getInstance() {
        if (instance == null) {
            instance = new RulesFactory();
        }
        return instance;
    }

}
