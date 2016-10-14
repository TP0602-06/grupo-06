package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.onregion;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.nodecondition.ValidInputValueRule;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by matias on 13/10/16.
 */
public class ValidInputValueRuleTest {
    @Test
    public void ruleWithAllValidValues() {
        ConcreteNode node1 = new ConcreteNode("1", false);
        ConcreteNode node2 = new ConcreteNode("2", false);
        ConcreteNode node3 = new ConcreteNode("3", false);

        ArrayList<AbstractNode> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);

        HashSet<String> values = new HashSet<>();
        values.add("1");
        values.add("2");
        values.add("3");

        ValidInputValueRule rule = new ValidInputValueRule(nodes, values);

        Assert.assertEquals(false, rule.isBroken());
    }

    @Test
    public void ruleWithInvalidValue() {
        ConcreteNode node1 = new ConcreteNode("1", false);
        ConcreteNode node2 = new ConcreteNode("5", false);
        ConcreteNode node3 = new ConcreteNode("3", false);

        ArrayList<AbstractNode> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);

        HashSet<String> values = new HashSet<>();
        values.add("1");
        values.add("2");
        values.add("3");

        ValidInputValueRule rule = new ValidInputValueRule(nodes, values);

        Assert.assertEquals(true, rule.isBroken());
    }

    @Test
    public void ruleWithEmptyValidValue() {
        ConcreteNode node1 = new ConcreteNode("1", false);
        ConcreteNode node2 = new ConcreteNode("", false);
        ConcreteNode node3 = new ConcreteNode("3", false);

        ArrayList<AbstractNode> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);

        HashSet<String> values = new HashSet<>();
        values.add("1");
        values.add("");
        values.add("3");

        ValidInputValueRule rule = new ValidInputValueRule(nodes, values);

        Assert.assertEquals(false, rule.isBroken());
    }
}
