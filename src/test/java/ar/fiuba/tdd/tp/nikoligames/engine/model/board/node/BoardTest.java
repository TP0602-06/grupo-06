package ar.fiuba.tdd.tp.nikoligames.engine.model.board.node;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.ConcreteBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by german on 10/16/2016.
 */
public class BoardTest {
    @Test
    public void nodePositionTest() throws Exception {
        Board board = new ConcreteBoard(2, 2);
        Position nodePosition = new ClassicPosition(1, 1);
        board.changeNodeValue(nodePosition, "4");
        AbstractNode node = board.getNode(nodePosition);
        Assert.assertTrue((node.getIntValue() == 4));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void outOfRangeTest() throws Exception {
        Board board = new ConcreteBoard(2, 2);
        Position nodePosition = new ClassicPosition(3, 3);

        board.getNode(nodePosition);
    }

    @Test
    public void createEdgeTest() throws Exception {
        Board board = new ConcreteBoard(2, 2);
        Position nodePosition = new ClassicPosition(1, 1);
        Position nodePosition2 = new ClassicPosition(1, 2);

        board.createUndirectedEdge(nodePosition, nodePosition2);

        AbstractNode node = board.getNode(nodePosition);
        AbstractNode node2 = board.getNode(nodePosition2);

        Assert.assertTrue((node.getEdgeList().contains(node2)));
        Assert.assertTrue((node2.getEdgeList().contains(node)));
    }

    @Test
    public void createAndRemoveEdgeTest() throws Exception {
        Board board = new ConcreteBoard(2, 2);
        Position nodePosition = new ClassicPosition(1, 1);
        Position nodePosition2 = new ClassicPosition(1, 2);

        board.createUndirectedEdge(nodePosition, nodePosition2);

        board.removeUndirectedEdge(nodePosition2, nodePosition);

        AbstractNode node = board.getNode(nodePosition);
        AbstractNode node2 = board.getNode(nodePosition2);

        Assert.assertFalse((node.getEdgeList().contains(node2)));
        Assert.assertFalse((node2.getEdgeList().contains(node)));
    }

    @Test
    public void createDuplicateAndRemoveEdgeTest() throws Exception {
        Board board = new ConcreteBoard(2, 2);
        Position nodePosition = new ClassicPosition(1, 1);
        Position nodePosition2 = new ClassicPosition(1, 2);

        board.createUndirectedEdge(nodePosition, nodePosition2);
        board.createUndirectedEdge(nodePosition2, nodePosition);

        board.removeUndirectedEdge(nodePosition2, nodePosition);

        AbstractNode node = board.getNode(nodePosition);
        AbstractNode node2 = board.getNode(nodePosition2);

        Assert.assertFalse((node.getEdgeList().contains(node2)));
        Assert.assertFalse((node2.getEdgeList().contains(node)));
    }

}