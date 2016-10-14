package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.onregion;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.nodecondition.AdjacentRule;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matias on 12/10/16.
 */
public class AdjacentRuleTest {
    @Test
    public void ruleWithAllAdjacentEdges() {
        ArrayList<AbstractNode> region = new ArrayList<>();

        ConcreteNode rootNode = new ConcreteNode("1", false);
        region.add(rootNode);

        ArrayList<AbstractNode> adjacentNodes = this.createAdjacentNodes(2);
        this.addEdges(rootNode, adjacentNodes);

        AdjacentRule rule = new AdjacentRule(region, adjacentNodes);

        Assert.assertEquals(false, rule.isBroken());
    }

    @Test
    public void ruleWithoutAllAdjacentEdges() {
        ArrayList<AbstractNode> region = new ArrayList<>();

        ConcreteNode rootNode = new ConcreteNode("1", false);
        region.add(rootNode);

        ArrayList<AbstractNode> adjacentNodes = this.createAdjacentNodes(2);

        this.addEdges(rootNode, adjacentNodes.subList(0, 1));

        AdjacentRule rule = new AdjacentRule(region, adjacentNodes);

        Assert.assertEquals(true, rule.isBroken());
    }

    @Test
    public void ruleWithExtraEdges() {
        ArrayList<AbstractNode> region = new ArrayList<>();

        ConcreteNode rootNode = new ConcreteNode("1", false);
        region.add(rootNode);

        ArrayList<AbstractNode> adjacentNodes = this.createAdjacentNodes(2);
        this.addEdges(rootNode, adjacentNodes);

        ConcreteNode extraEdge = new ConcreteNode("4", false);
        rootNode.addEdge(extraEdge);

        AdjacentRule rule = new AdjacentRule(region, adjacentNodes);

        Assert.assertEquals(false, rule.isBroken());
    }

    private ArrayList<AbstractNode> createAdjacentNodes(int size) {
        ArrayList<AbstractNode> adjacentNodes = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            adjacentNodes.add(new ConcreteNode("", false));
        }
        return adjacentNodes;
    }

    private void addEdges(AbstractNode node, List<AbstractNode> edges) {
        edges.forEach(edge -> node.addEdge(edge));
    }
}
