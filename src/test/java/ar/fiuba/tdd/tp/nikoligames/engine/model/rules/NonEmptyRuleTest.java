package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.NonEmptyRule;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by matias on 11/10/16.
 */
public class NonEmptyRuleTest {
    @Test
    public void ruleWithoutEmptyNodes() throws Exception {
        ConcreteNode node1 = new ConcreteNode("1", false);
        ConcreteNode node2 = new ConcreteNode("2", false);
        ConcreteNode node3 = new ConcreteNode("3", false);
        ConcreteNode node4 = new ConcreteNode("4", false);

        ArrayList<AbstractNode> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);

        NonEmptyRule rule = new NonEmptyRule(nodes);
        Assert.assertEquals(false, rule.isBroken());
    }

    @Test
    public void ruleWithEmptyNodes() throws Exception {
        ConcreteNode node1 = new ConcreteNode("1", false);
        ConcreteNode node2 = new ConcreteNode("", false);
        ConcreteNode node3 = new ConcreteNode("2", false);
        ConcreteNode node4 = new ConcreteNode("4", false);

        ArrayList<AbstractNode> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);

        NonEmptyRule rule = new NonEmptyRule(nodes);
        Assert.assertEquals(true, rule.isBroken());
    }
}
