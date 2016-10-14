package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.circuit;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.circuit.RegionVisitedAtMostOnceRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.utils.ChainEdgeCreator;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.utils.DefaultRegionCreator;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by german on 10/14/2016.
 */
public class RegionVisitedAtMostOnceRuleTest {

    @Test
    public void nodeNoEdgesTestTrue() {
        List<AbstractNode> region = DefaultRegionCreator.createRegion(4);

        Rule rule = new RegionVisitedAtMostOnceRule(region);

        Assert.assertFalse(rule.isBroken());
    }

    @Test
    public void regionWithInternalEdgesTest() {
        List<AbstractNode> region = DefaultRegionCreator.createRegion(4);
        ChainEdgeCreator.createChain(region, 0, 2);

        Rule rule = new RegionVisitedAtMostOnceRule(region);

        Assert.assertFalse(rule.isBroken());
    }

    @Test
    public void regionWithExternalEdgesTest() {
        List<AbstractNode> region = DefaultRegionCreator.createRegion(4);
        ChainEdgeCreator.createChain(region, 0, 2);

        AbstractNode nodeInRegion = region.get(0);

        addExternalEdge(nodeInRegion);

        AbstractNode nodeInRegion2 = region.get(3);

        addExternalEdge(nodeInRegion2);

        Rule rule = new RegionVisitedAtMostOnceRule(region);

        Assert.assertFalse(rule.isBroken());
    }

    @Test
    public void regionWithOneExternalEdgeTest() {
        List<AbstractNode> region = DefaultRegionCreator.createRegion(4);
        ChainEdgeCreator.createChain(region, 0, 2);

        AbstractNode nodeInRegion = region.get(0);

        addExternalEdge(nodeInRegion);

        Rule rule = new RegionVisitedAtMostOnceRule(region);

        Assert.assertFalse(rule.isActualBroken());
        Assert.assertTrue(rule.isBroken());
    }

    @Test
    public void regionWithThreeExternalEdgesTest() {
        List<AbstractNode> region = DefaultRegionCreator.createRegion(4);
        ChainEdgeCreator.createChain(region, 0, 2);

        AbstractNode nodeInRegion = region.get(0);
        addExternalEdge(nodeInRegion);

        AbstractNode nodeInRegion2 = region.get(1);
        addExternalEdge(nodeInRegion2);

        AbstractNode nodeInRegion3 = region.get(2);
        addExternalEdge(nodeInRegion);

        Rule rule = new RegionVisitedAtMostOnceRule(region);

        Assert.assertTrue(rule.isActualBroken());
        Assert.assertTrue(rule.isBroken());
    }

    private void addExternalEdge(AbstractNode nodeInRegion2) {
        AbstractNode externalNode2 = new ConcreteNode("", false);
        nodeInRegion2.addEdge(externalNode2);
    }
}
