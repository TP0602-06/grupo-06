package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.circuit;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.circuit.EdgesInternalToRegionCountRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.utils.ChainEdgeCreator;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.utils.DefaultRegionCreator;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by german on 10/14/2016.
 */
public class EdgesInternalToRegionCountRuleTest {
    @Test
    public void nodeNoEdgesTestTrue() {
        List<AbstractNode> region = DefaultRegionCreator.createRegion(4);

        Rule rule = new EdgesInternalToRegionCountRule(region, "1");

        Assert.assertTrue(rule.isBroken());
    }

    @Test
    public void nodeNoEdgesTestFalse() {
        List<AbstractNode> region = DefaultRegionCreator.createRegion(4);

        Rule rule = new EdgesInternalToRegionCountRule(region, "0");

        Assert.assertFalse(rule.isBroken());
    }

    @Test
    public void nodeWithInternalEdgesTestTrue() {
        List<AbstractNode> region = DefaultRegionCreator.createRegion(4);

        ChainEdgeCreator.createChain(region, 0, 3);

        Rule rule = new EdgesInternalToRegionCountRule(region, "1");

        Assert.assertTrue(rule.isBroken());
    }

    @Test
    public void nodeWithInternalEdgesTestFalse() {
        List<AbstractNode> region = DefaultRegionCreator.createRegion(4);

        ChainEdgeCreator.createChain(region, 0, 3);

        Rule rule = new EdgesInternalToRegionCountRule(region, "3");

        Assert.assertFalse(rule.isBroken());
    }

    @Test
    public void nodeWithExternalEdgesTestFalse() {
        List<AbstractNode> region = DefaultRegionCreator.createRegion(4);

        ChainEdgeCreator.createChain(region, 0, 3);
        AbstractNode nodeInRegion = region.get(0);

        AbstractNode externalNode = new ConcreteNode("", false);
        nodeInRegion.addEdge(externalNode);

        Rule rule = new EdgesInternalToRegionCountRule(region, "3");

        Assert.assertFalse(rule.isBroken());
    }

    @Test
    public void nodeWithExternalEdgesTestTrue() {
        List<AbstractNode> region = DefaultRegionCreator.createRegion(4);

        ChainEdgeCreator.createChain(region, 0, 3);
        AbstractNode nodeInRegion = region.get(0);

        AbstractNode externalNode = new ConcreteNode("", false);
        nodeInRegion.addEdge(externalNode);

        Rule rule = new EdgesInternalToRegionCountRule(region, "4");

        Assert.assertTrue(rule.isBroken());
    }
}
