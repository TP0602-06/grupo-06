package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.nodecondition;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.nodecondition.AdjacentRule;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by matias on 12/10/16.
 */
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

    private void addUndirectedEdgesBetweenNodeAndEachNodeFromList(AbstractNode node, List<AbstractNode> edges) {
        Iterator<AbstractNode> iterator = edges.iterator();
        while (iterator.hasNext()) {
            AbstractNode connectedNode = iterator.next();
            addUndirectedEdge(node, connectedNode);
        }
    }

    private void addUndirectedEdge(AbstractNode node, AbstractNode connectedNode) {
        node.addEdge(connectedNode);
        connectedNode.addEdge(node);
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

        addUndirectedEdgesBetweenNodeAndEachNodeFromList(rootNode, edgeList);

        Assert.assertFalse(rule.isBroken());
    }

    @Test
    public void ruleWithoutAllAdjacentEdges() {

        setupRegionAndAdjacentList(2);

        edgeList.addAll(adjacentList.subList(0, 2));

        addUndirectedEdgesBetweenNodeAndEachNodeFromList(rootNode, edgeList);

        Assert.assertFalse(rule.isBroken());
    }

    @Test
    public void ruleWithExtraEdges() {

        setupRegionAndAdjacentList(2);

        ConcreteNode extraEdge = new ConcreteNode("4", false);

        edgeList.addAll(adjacentList);

        edgeList.add(extraEdge);

        addUndirectedEdgesBetweenNodeAndEachNodeFromList(rootNode, edgeList);

        Assert.assertTrue(rule.isBroken());
    }

}
