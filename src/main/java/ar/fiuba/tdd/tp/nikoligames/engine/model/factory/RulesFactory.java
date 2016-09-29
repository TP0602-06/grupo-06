package ar.fiuba.tdd.tp.nikoligames.engine.model.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.impl.AdditionRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.impl.NoDuplicatesRule;

import java.util.ArrayList;

/**
 * Fabrica de reglas que permite al cliente no conocer la implementacion de la creacion  de una regla.
 */

public class RulesFactory {

    public Rule createAdditionRule(int sum, ArrayList<AbstractCell> cells) {
        return new AdditionRule(sum, cells);
    }

    public Rule createNoDuplicatesRule(ArrayList<AbstractCell> cells) {
        return new NoDuplicatesRule(cells);
    }



}
