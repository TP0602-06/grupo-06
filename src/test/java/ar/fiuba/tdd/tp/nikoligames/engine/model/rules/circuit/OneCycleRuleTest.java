package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.circuit;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.circuit.OneCycleRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.utils.ChainEdgeCreator;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.utils.DefaultRegionCreator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matias on 13/10/16.
 */
public class OneCycleRuleTest {
    @Test
    public void ruleWithOneCycle() {
        List<AbstractNode> region = DefaultRegionCreator.createRegion(5);

        this.createCycle(region, 1, 3);

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

        this.createCycle(region, 0, 4);
        this.createCycle(region, 5, 9);

        OneCycleRule rule = new OneCycleRule(region);

        Assert.assertEquals(true, rule.isBroken());
    }


    private void createCycle(List<AbstractNode> region, int firstIndex, int lastIndex) {
        for (int currentIndex = firstIndex; currentIndex <= lastIndex; currentIndex++) {
            AbstractNode node = region.get(currentIndex);
            AbstractNode edge = this.getNextNodeInCycle(region, firstIndex, currentIndex,lastIndex);
            this.addEdge(node, edge);
        }
    }

    private AbstractNode getNextNodeInCycle(List<AbstractNode> region, int firstIndex, int currentIndex, int lastIndex) {
        if (currentIndex == lastIndex) {
            return region.get(firstIndex);
        } else {
            return region.get(currentIndex + 1);
        }
    }

    private void addEdge(AbstractNode node, AbstractNode edge) {
        node.addEdge(edge);
        edge.addEdge(node);
    }
}
