package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.circuit;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.UndirectedBoard;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.generators.adjacentlist.AdjacentListGenerator;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.generators.adjacentlist.HorizontalVerticalAdjacentListGen;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.generators.adjacentrules.AbstractAdjacentRulesGenerator;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.generators.adjacentrules.PairOfAdjacentRulesGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by german on 10/14/2016.
 */
public class generatorTest {

    private List<AbstractNode> region;
    private List<AbstractNode> board;
    private void putAdjacentList(Map<AbstractNode, List<AbstractNode>> adjacentList , int indexNode, List<Integer> adjacentNodes) {
        List<AbstractNode> adjacentListNode = new ArrayList<AbstractNode>();

        Iterator<Integer> adjacentNodesIterator = adjacentNodes.iterator();
        while (adjacentNodesIterator.hasNext()){
            Integer adjacentNodeIndex = adjacentNodesIterator.next();
            adjacentListNode.add(board.get(adjacentNodeIndex));
            adjacentList.put(board.get(indexNode),adjacentListNode);
        }
    }
    private List<Rule> setup() {

        Map<AbstractNode, List<AbstractNode>> adjacentList = new HashMap<AbstractNode, List<AbstractNode>>();
        putAdjacentList(adjacentList, 0 , Arrays.asList(1,2));
        putAdjacentList(adjacentList, 1 , Arrays.asList(0,3));
        putAdjacentList(adjacentList, 2 , Arrays.asList(0,3));
        putAdjacentList(adjacentList, 3 , Arrays.asList(1,2));

        Board board = new UndirectedBoard(4, 4);

        AdjacentListGenerator adjacentListGenerator = new HorizontalVerticalAdjacentListGen(board);

        //Map<AbstractNode, List<AbstractNode>> adjacentList = adjacentListGenerator.getAdjacentList();

        Iterator<Position> iterator = board.getPositionIterator();
        while (iterator.hasNext()) {
            Position position = iterator.next();
            AbstractNode node = board.getNode(position);
            region.add(node);
        }

        List<AbstractNode> region1 = region.subList(0, 5);
        List<AbstractNode> region2 = region.subList(5, 16);
        List<List<AbstractNode>> allRegions = new ArrayList<List<AbstractNode>>();

        allRegions.add(region1);
        allRegions.add(region2);

        AbstractAdjacentRulesGenerator adjacentRulesGenerator = new PairOfAdjacentRulesGenerator(adjacentList, allRegions);
        List<Rule> rules = adjacentRulesGenerator.getAdjacentRules();

        return rules;
    }

    @Test
    public void nodeNoEdgesTestTrue() {
        List<Rule> rules = setup();

        Iterator<Rule> ruleIterator = rules.iterator();
        while (ruleIterator.hasNext()) {
            Rule rule = ruleIterator.next();
            Assert.assertTrue(rule.isBroken());
        }

    }


}
