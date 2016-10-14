package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.circuit;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.circuit.NoCycleRule;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 10/13/2016.
 */
public class NoCyleRuleTest {

    @Test
    public void nodeNoEdgesTest() {
        List<AbstractNode> region = new ArrayList<AbstractNode>();
        AbstractNode node1 = new ConcreteNode("", true);
        region.add(node1);
        Rule rule = new NoCycleRule(region);
        Assert.assertFalse(rule.isBroken());
    }

    @Test
    public void twoNodesNoEdgesTest() {
        List<AbstractNode> region = new ArrayList<AbstractNode>();
        AbstractNode node1 = new ConcreteNode("", true);
        region.add(node1);
        AbstractNode node2 = new ConcreteNode("", true);
        region.add(node2);
        Rule rule = new NoCycleRule(region);
        Assert.assertFalse(rule.isBroken());
    }

    @Test
    public void nodesWithEdgesNoCycleTest() {
        List<AbstractNode> region = new ArrayList<AbstractNode>();
        AbstractNode node1 = new ConcreteNode("", true);
        region.add(node1);
        AbstractNode node2 = new ConcreteNode("", true);
        region.add(node2);
        AbstractNode node3 = new ConcreteNode("", true);
        region.add(node3);

        this.addEdge(node1, node2);
        this.addEdge(node2, node3);

        Rule rule = new NoCycleRule(region);
        Assert.assertFalse(rule.isBroken());
    }

    @Test
    public void nodesWithEdgesOneCycleTest() {
        List<AbstractNode> region = new ArrayList<AbstractNode>();
        AbstractNode node1 = new ConcreteNode("", true);
        region.add(node1);
        AbstractNode node2 = new ConcreteNode("", true);
        region.add(node2);
        AbstractNode node3 = new ConcreteNode("", true);
        region.add(node3);
        AbstractNode node4 = new ConcreteNode("", true);
        region.add(node4);

        this.addEdge(node1, node2);
        this.addEdge(node2, node3);
        this.addEdge(node3, node4);
        this.addEdge(node3, node1);

        Rule rule = new NoCycleRule(region);
        Assert.assertTrue(rule.isBroken());
    }

    public void addEdge(AbstractNode node1, AbstractNode node2) {
        node1.addEdge(node2);
        node2.addEdge(node1);
    }
}
