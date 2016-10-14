package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.circuit.OneCycleRule;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by matias on 13/10/16.
 */
public class OneCycleRuleTest {
    @Test
    public void ruleWithUniqueCycle() {
        ArrayList<AbstractNode> region = this.createRegion(5);

        this.createCycle(region, 0, 4);

        OneCycleRule rule = new OneCycleRule(region);

        Assert.assertEquals(false, rule.isBroken());
    }

    @Test
    public void ruleWithoutAnyCycle() {
        ArrayList<AbstractNode> region = this.createRegion(5);

        this.createChain(region, 0, 4);

        OneCycleRule rule = new OneCycleRule(region);

        Assert.assertEquals(true, rule.isBroken());
    }

    @Test
    public void ruleWithTwoCycles() {
        ArrayList<AbstractNode> region = this.createRegion(10);

        this.createCycle(region, 0, 4);
        this.createCycle(region, 5, 9);

        OneCycleRule rule = new OneCycleRule(region);

        Assert.assertEquals(true, rule.isBroken());
    }

    private ArrayList<AbstractNode> createRegion(int size) {
        ArrayList<AbstractNode> region = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            region.add(new ConcreteNode("", false));
        }
        return region;
    }

    private void createCycle(ArrayList<AbstractNode> region, int firstIndex, int lastIndex) {
        for (int currentIndex = firstIndex; currentIndex <= lastIndex; currentIndex++) {
            AbstractNode node = region.get(currentIndex);
            AbstractNode edge = this.getNextNodeInCycle(region, firstIndex, currentIndex);
            this.addEdge(node, edge);
        }
    }

    private void createChain(ArrayList<AbstractNode> region, int firstIndex, int lastIndex) {
        for (int currentIndex = firstIndex; currentIndex <= lastIndex - 1; currentIndex++) {
            AbstractNode node = region.get(currentIndex);
            AbstractNode edge = region.get(currentIndex + 1);
            this.addEdge(node, edge);
        }
    }

    private AbstractNode getNextNodeInCycle(ArrayList<AbstractNode> region, int firstIndex, int currentIndex) {
        if (currentIndex == region.size() - 1) {
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
