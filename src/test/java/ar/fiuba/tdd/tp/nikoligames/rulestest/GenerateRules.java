package ar.fiuba.tdd.tp.nikoligames.rulestest;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.CellFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.impl.NoDuplicatesRule;

import java.util.ArrayList;

public class GenerateRules {

    private static AbstractCell createCell(String value) {
        CellFactory cellFactory = new CellFactory();
        return cellFactory.createCell(value);
    }

    public static Rule rigthNoDuplicatesRule() {
        ArrayList<AbstractCell> list = new ArrayList<>();
        AbstractCell cell1 = createCell("1");
        list.add(cell1);
        AbstractCell cell2 = createCell("2");
        list.add(cell2);
        return (new NoDuplicatesRule(list));
    }

    public Rule wrongNoDuplicatesRule() {
        ArrayList<AbstractCell> list = new ArrayList<>();
        AbstractCell cell1 = createCell("1");
        list.add(cell1);
        AbstractCell cell2 = createCell("1");
        list.add(cell2);
        return (new NoDuplicatesRule(list));
    }
}