package ar.fiuba.tdd.tp.nikoligames.engine.model.factory;


import ar.fiuba.tdd.tp.nikoligames.engine.model.board.CellInterface;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.ArrayList;

public interface RuleAbstractFactory {


    public Rule createNoDuplicatesRule(ArrayList<CellInterface> cells);

    public Rule createAdditionRule(int sum, ArrayList<CellInterface> cells);

}
