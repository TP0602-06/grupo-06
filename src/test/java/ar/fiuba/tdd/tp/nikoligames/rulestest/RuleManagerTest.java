package ar.fiuba.tdd.tp.nikoligames.rulestest;


import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleManager;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RuleManagerTest {

    @Test
    public void creationTest() {
        RuleManager manager = new RuleManager(new ArrayList<>());
        assertNotNull(manager);
    }

    @Test
    public void noRulesManagerTest() {
        RuleManager manager = new RuleManager(new ArrayList<>());
        assertTrue(manager.checkRules());
    }

    @Test
    public void oneElementRightRulesManagerTest() {
        ArrayList<Rule> list = new ArrayList<>();
        list.add(GenerateRules.rigthNoDuplicatesRule());
        RuleManager manager = new RuleManager(list);
        assertTrue(manager.checkRules());
    }

    @Test
    public void oneElementWrongRulesManagerTest() {
        ArrayList<Rule> list = new ArrayList<>();
        GenerateRules generateRules = new GenerateRules();
        list.add(generateRules.wrongNoDuplicatesRule());
        RuleManager manager = new RuleManager(list);
        assertTrue(!manager.checkRules());
    }

}

