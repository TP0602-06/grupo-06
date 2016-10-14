package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.onregion;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.nodecondition.AdjacentRule;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by matias on 12/10/16.
 */
public class AdjacentRuleTest {
    @Test
    public void ruleWithAllAdjacentEdges() {
        ConcreteNode rootNode = new ConcreteNode("1", false);
        ConcreteNode adjacentNode1 = new ConcreteNode("2", false);
        ConcreteNode adjacentNode2 = new ConcreteNode("3", false);

        ArrayList<AbstractNode> region = new ArrayList<>();
        region.add(rootNode);

        ArrayList<AbstractNode> adjacentNodes = new ArrayList<>();
        adjacentNodes.add(adjacentNode1);
        adjacentNodes.add(adjacentNode2);

        rootNode.addEdge(adjacentNode1);
        rootNode.addEdge(adjacentNode2);

        AdjacentRule rule = new AdjacentRule(region, adjacentNodes);

        Assert.assertEquals(false, rule.isBroken());
    }

    @Test
    public void ruleWithoutAllAdjacentEdges() {
        ConcreteNode rootNode = new ConcreteNode("1", false);
        ConcreteNode adjacentNode1 = new ConcreteNode("2", false);
        ConcreteNode adjacentNode2 = new ConcreteNode("3", false);

        ArrayList<AbstractNode> region = new ArrayList<>();
        region.add(rootNode);

        ArrayList<AbstractNode> adjacentNodes = new ArrayList<>();
        adjacentNodes.add(adjacentNode1);
        adjacentNodes.add(adjacentNode2);

        rootNode.addEdge(adjacentNode1);

        AdjacentRule rule = new AdjacentRule(region, adjacentNodes);

        Assert.assertEquals(true, rule.isBroken());
    }

    @Test
    public void ruleWithExtraEdges() {
        ConcreteNode rootNode = new ConcreteNode("1", false);
        ConcreteNode adjacentNode1 = new ConcreteNode("2", false);
        ConcreteNode adjacentNode2 = new ConcreteNode("3", false);
        ConcreteNode adjacentNode3 = new ConcreteNode("4", false);

        ArrayList<AbstractNode> region = new ArrayList<>();
        region.add(rootNode);

        ArrayList<AbstractNode> adjacentNodes = new ArrayList<>();
        adjacentNodes.add(adjacentNode1);
        adjacentNodes.add(adjacentNode2);

        rootNode.addEdge(adjacentNode1);
        rootNode.addEdge(adjacentNode2);
        rootNode.addEdge(adjacentNode3);

        AdjacentRule rule = new AdjacentRule(region, adjacentNodes);

        Assert.assertEquals(false, rule.isBroken());
    }
}
