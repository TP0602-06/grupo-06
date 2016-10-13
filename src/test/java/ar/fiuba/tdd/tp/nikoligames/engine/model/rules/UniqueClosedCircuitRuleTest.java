package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.UniqueClosedCircuitRule;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by matias on 13/10/16.
 */
public class UniqueClosedCircuitRuleTest {
    @Test
    public void ruleWithUniqueCloseCircuit() {
        ConcreteNode node1 = new ConcreteNode("1", false);
        ConcreteNode node2 = new ConcreteNode("2", false);
        ConcreteNode node3 = new ConcreteNode("2", false);
        ConcreteNode node4 = new ConcreteNode("4", false);
        ConcreteNode node5 = new ConcreteNode("5", false);

        ArrayList<AbstractNode> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);

        node1.addEdge(node2);
        node2.addEdge(node3);
        node3.addEdge(node4);
        node4.addEdge(node5);
        node5.addEdge(node1);

        UniqueClosedCircuitRule rule = new UniqueClosedCircuitRule(nodes);

        Assert.assertEquals(false, rule.isBroken());
    }

    @Test
    public void ruleWithoutAnyCloseCircuit() {
        ConcreteNode node1 = new ConcreteNode("1", false);
        ConcreteNode node2 = new ConcreteNode("2", false);
        ConcreteNode node3 = new ConcreteNode("2", false);
        ConcreteNode node4 = new ConcreteNode("4", false);
        ConcreteNode node5 = new ConcreteNode("5", false);

        ArrayList<AbstractNode> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);

        node1.addEdge(node2);
        node2.addEdge(node3);
        node3.addEdge(node4);
        node4.addEdge(node5);

        UniqueClosedCircuitRule rule = new UniqueClosedCircuitRule(nodes);

        Assert.assertEquals(true, rule.isBroken());
    }

    @Test
    public void ruleWithoutTwoCloseCircuit() {
        ConcreteNode node1 = new ConcreteNode("1", false);
        ConcreteNode node2 = new ConcreteNode("2", false);
        ConcreteNode node3 = new ConcreteNode("2", false);
        ConcreteNode node4 = new ConcreteNode("4", false);
        ConcreteNode node5 = new ConcreteNode("5", false);
        ConcreteNode node6 = new ConcreteNode("6", false);
        ConcreteNode node7 = new ConcreteNode("7", false);
        ConcreteNode node8 = new ConcreteNode("8", false);
        ConcreteNode node9 = new ConcreteNode("9", false);
        ConcreteNode node10 = new ConcreteNode("10", false);

        ArrayList<AbstractNode> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);
        nodes.add(node6);
        nodes.add(node7);
        nodes.add(node8);
        nodes.add(node9);
        nodes.add(node10);

        node1.addEdge(node2);
        node2.addEdge(node3);
        node3.addEdge(node4);
        node4.addEdge(node5);

        node6.addEdge(node7);
        node7.addEdge(node8);
        node8.addEdge(node9);
        node9.addEdge(node10);
        node10.addEdge(node6);

        UniqueClosedCircuitRule rule = new UniqueClosedCircuitRule(nodes);

        Assert.assertEquals(true, rule.isBroken());
    }
}
