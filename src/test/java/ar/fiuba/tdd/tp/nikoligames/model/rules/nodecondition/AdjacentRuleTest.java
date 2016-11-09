package ar.fiuba.tdd.tp.nikoligames.model.rules.nodecondition;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.nodecondition.AdjacentRule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.utils.EdgeCreator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AdjacentRuleTest {
    List<AbstractNode> region = new ArrayList<AbstractNode>();
    List<AbstractNode> adjacentList = new ArrayList<AbstractNode>();
    List<AbstractNode> edgeList = new ArrayList<AbstractNode>();
    private AbstractNode rootNode;
    private Rule rule;

    public void setupRegionAndAdjacentList(int sizeAdjacentList) {
        region.clear();
        adjacentList.clear();

        rootNode = new ConcreteNode("1", false);
        region.add(rootNode);

        adjacentList = this.createAdjacentList(sizeAdjacentList);

        rule = new AdjacentRule(region, adjacentList);

    }

    private ArrayList<AbstractNode> createAdjacentList(int size) {
        ArrayList<AbstractNode> adjacentNodes = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            adjacentNodes.add(new ConcreteNode("", false));
        }
        return adjacentNodes;
    }

    @Test
    public void ruleWithNoEdges() {
        setupRegionAndAdjacentList(2);

        Assert.assertFalse(rule.isBroken());
    }

    @Test
    public void ruleWithAllAdjacentEdges() {
        setupRegionAndAdjacentList(2);

        edgeList.addAll(adjacentList);

        EdgeCreator.addUndirectedEdgesBetweenNodeAndEachNodeFromList(rootNode, edgeList);

        Assert.assertFalse(rule.isBroken());
    }

    @Test
    public void ruleWithoutAllAdjacentEdges() {

        setupRegionAndAdjacentList(2);

        edgeList.addAll(adjacentList.subList(0, 2));

        EdgeCreator.addUndirectedEdgesBetweenNodeAndEachNodeFromList(rootNode, edgeList);

        Assert.assertFalse(rule.isBroken());
    }

    @Test
    public void ruleWithExtraEdges() {

        setupRegionAndAdjacentList(2);

        ConcreteNode extraEdge = new ConcreteNode("4", false);

        edgeList.addAll(adjacentList);

        edgeList.add(extraEdge);

        EdgeCreator.addUndirectedEdgesBetweenNodeAndEachNodeFromList(rootNode, edgeList);

        Assert.assertTrue(rule.isBroken());
    }

}
