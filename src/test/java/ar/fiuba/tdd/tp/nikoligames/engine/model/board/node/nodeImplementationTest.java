package ar.fiuba.tdd.tp.nikoligames.engine.model.board.node;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by german on 10/15/2016.
 */
public class nodeImplementationTest {
    @Test
    public void isEmptyNodeTest(){
        AbstractNode node = new ConcreteNode();
        Assert.assertTrue(node.isEmpty());
        Assert.assertFalse(node.isEditable());
    }
    @Test
    public void isEmptyGetIntValueNodeTest(){
        AbstractNode node = new ConcreteNode();
        Assert.assertTrue(node.getIntValue() == 0);
    }

    @Test
    public void AddAndRemoveNodeTest(){
        AbstractNode node = new ConcreteNode();
        AbstractNode node1 = new ConcreteNode();
        AbstractNode node2 = new ConcreteNode();

        node.addEdge(node1);
        node.addEdge(node2);
        List<AbstractNode> edgelist = node.getEdgeList();
        Assert.assertTrue(edgelist.size() == 2);

        node.removeEdge(node1);

        List<AbstractNode> edgelistNext = node.getEdgeList();
        Assert.assertTrue(edgelistNext.size() == 1);

        Assert.assertFalse(edgelistNext.contains(node1));
        Assert.assertTrue(edgelistNext.contains(node2));
    }
}
