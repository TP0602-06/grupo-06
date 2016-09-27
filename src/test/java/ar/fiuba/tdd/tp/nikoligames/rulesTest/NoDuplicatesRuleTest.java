package ar.fiuba.tdd.tp.nikoligames.rulesTest;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Cell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.CellType;
import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.CellFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.impl.NoDuplicatesRule;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class NoDuplicatesRuleTest {

    private AbstractCell createCell(String value){
        return CellFactory.getInstance().createCell(CellType.STRINGTYPE,value);
    }

    @Test
    public void creationTest() {
        ArrayList<AbstractCell> list = new ArrayList<>();
        Rule rule = new NoDuplicatesRule(list);
        assertNotNull(rule);
    }

    @Test
    public void emptyRuleTest() {
        ArrayList<AbstractCell> list = new ArrayList<>();
        Rule rule = new NoDuplicatesRule(list);
        assertTrue(!rule.isBroken());
    }

    @Test
    public void oneElementRuleTest() {
        ArrayList<AbstractCell> list = new ArrayList<>();
        AbstractCell cell1 = createCell("1");
        list.add(cell1);
        Rule rule = new NoDuplicatesRule(list);
        assertTrue(!rule.isBroken());
    }

    @Test
    public void twoElementRightRuleTest() {
        ArrayList<AbstractCell> list = new ArrayList<>();
        AbstractCell cell1 = createCell("1");
        list.add(cell1);
        AbstractCell cell2 = createCell("2");
        list.add(cell2);
        Rule rule = new NoDuplicatesRule(list);
        assertTrue(!rule.isBroken());
    }

    @Test
    public void twoElementBrokenRuleTest() {
        ArrayList<AbstractCell> list = new ArrayList<>();
        AbstractCell cell1 = createCell("1");
        list.add(cell1);
        AbstractCell cell2 = createCell("1");
        list.add(cell2);
        Rule rule = new NoDuplicatesRule(list);
        assertTrue(rule.isBroken());
    }

    @Test
    public void ManyElementRightRuleTest() {
        ArrayList<AbstractCell> list = new ArrayList<>();
        AbstractCell cell1 = createCell("1");
        list.add(cell1);
        AbstractCell cell2 = createCell("2");
        list.add(cell2);
        Rule rule = new NoDuplicatesRule(list);
        assertTrue(!rule.isBroken());
    }

}
