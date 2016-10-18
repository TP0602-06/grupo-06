package ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.ConcreteBoard;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.ClassicPosition;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Andres on 16/10/2016.
 */
public class BoardAdjacentListTest {

    @Test
    public void getDiagonalAjacentListForNode() throws Exception {
        Board board = new ConcreteBoard(2, 2);
        DiagonalAdjacentListGen diagonalAdjacentListGen = new DiagonalAdjacentListGen(board);
        Map<AbstractNode, List<AbstractNode>> adjacentList = diagonalAdjacentListGen.getAdjacentList();
        AbstractNode node = board.getNode(new ClassicPosition(1, 1));
        List<AbstractNode> listAdjacentToNode = adjacentList.get(node);
        assertEquals(listAdjacentToNode.size(), 1);
        AbstractNode adjNode = board.getNode(new ClassicPosition(2, 2));
        assertTrue(listAdjacentToNode.contains(adjNode));
    }

    @Test
    public void getHorizontalAjacentListForNode() throws Exception {
        Board board = new ConcreteBoard(2, 2);
        HorizontalVerticalAdjacentListGen horizontalVerticalAdjacentListGen = new HorizontalVerticalAdjacentListGen(board);
        Map<AbstractNode, List<AbstractNode>> adjacentList = horizontalVerticalAdjacentListGen.getAdjacentList();
        AbstractNode node = board.getNode(new ClassicPosition(1, 1));
        List<AbstractNode> listAdjacentToNode = adjacentList.get(node);
        assertEquals(listAdjacentToNode.size(), 2);
        AbstractNode adjNode = board.getNode(new ClassicPosition(2, 1));
        assertTrue(listAdjacentToNode.contains(adjNode));
    }
}