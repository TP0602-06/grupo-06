package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.circuit;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.circuit.RegionVisitedCountRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.utils.ChainEdgeCreator;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.utils.DefaultRegionCreator;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.utils.EdgeCreator;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by german on 10/14/2016.
 */
public class RegionVisitedCountRuleTest {
    @Test
    public void regionWithInternalEdgesTest() {
        List<AbstractNode> region = DefaultRegionCreator.createRegion(4);
        ChainEdgeCreator.createChain(region, 0, 2);

        Rule rule = new RegionVisitedCountRule(region, "3");

        Assert.assertFalse(rule.isBroken());
        Assert.assertFalse(rule.isActualBroken());
    }

    @Test
    public void regionWithLessInternalEdgesTest() {
        List<AbstractNode> region = DefaultRegionCreator.createRegion(4);
        ChainEdgeCreator.createChain(region, 0, 2);

        Rule rule = new RegionVisitedCountRule(region, "4");

        Assert.assertTrue(rule.isBroken());
        Assert.assertFalse(rule.isActualBroken());
    }

    @Test
    public void regionWithInternalAndExternalEdgesTest() {
        List<AbstractNode> region = DefaultRegionCreator.createRegion(4);
        ChainEdgeCreator.createChain(region, 1, 2);

        AbstractNode nodeInRegion = region.get(0);
        EdgeCreator.addExternalEdge(nodeInRegion);

        AbstractNode nodeInRegion2 = region.get(3);
        EdgeCreator.addExternalEdge(nodeInRegion2);

        Rule rule = new RegionVisitedCountRule(region, "4");

        Assert.assertFalse(rule.isBroken());
        Assert.assertFalse(rule.isActualBroken());
    }

}
