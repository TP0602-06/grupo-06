package ar.fiuba.tdd.tp.nikoligames.model.rules.circuit;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.circuit.OneCycleRule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.utils.ChainEdgeCreator;
import ar.fiuba.tdd.tp.nikoligames.model.rules.utils.DefaultRegionCreator;
import com.sun.net.httpserver.Filter;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by matias on 13/10/16.
 */
public class OneCycleRuleTest {
    @Test
    public void ruleWithOneCycle() {
        List<AbstractNode> region = DefaultRegionCreator.createRegion(5);

        ChainEdgeCreator.createCycle(region, 1, 3);

        OneCycleRule rule = new OneCycleRule(region);

        Assert.assertEquals(false, rule.isBroken());
    }

    @Test
    public void ruleWithoutAnyCycle() {
        List<AbstractNode> region = DefaultRegionCreator.createRegion(5);

        ChainEdgeCreator.createChain(region, 0, 4);

        OneCycleRule rule = new OneCycleRule(region);

        Assert.assertEquals(true, rule.isBroken());
    }

    @Test
    public void ruleWithTwoCycles() {
        List<AbstractNode> region = DefaultRegionCreator.createRegion(10);

        ChainEdgeCreator.createCycle(region, 0, 4);
        ChainEdgeCreator.createCycle(region, 5, 9);

        OneCycleRule rule = new OneCycleRule(region);

        Assert.assertEquals(true, rule.isBroken());
    }
}
