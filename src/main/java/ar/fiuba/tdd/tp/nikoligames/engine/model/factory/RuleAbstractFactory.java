package ar.fiuba.tdd.tp.nikoligames.engine.model.factory;


import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.ArrayList;

public interface RuleAbstractFactory {


    public Rule createNoDuplicatesRule(ArrayList<AbstractCell> cells);

    public Rule createAdditionRule(int sum, ArrayList<AbstractCell> cells);

}
