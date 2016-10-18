package ar.fiuba.tdd.tp.nikoligames.model.rules.circuit;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.implementations.circuit.NoNotVisitedAdjacentNodesInSameRegionRule;
import ar.fiuba.tdd.tp.nikoligames.model.rules.utils.DefaultRegionCreator;
import ar.fiuba.tdd.tp.nikoligames.model.rules.utils.EdgeCreator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 10/14/2016.
 */
public class NoNotVisitedAdjacentNodesInSameRegionRuleTest {

    List<List<AbstractNode>> allRegions;
    private List<AbstractNode> region;
    private List<AbstractNode> board;

    private void setup() {
        board = DefaultRegionCreator.createRegion(4);
        List<AbstractNode> region1 = board.subList(0, 2);
        List<AbstractNode> region2 = board.subList(2, 4);
        allRegions = new ArrayList<List<AbstractNode>>();
        allRegions.add(region1);
        allRegions.add(region2);
    }


    @Test
    public void nodeNoEdgesTestTrue() {
        setup();
        region = board.subList(0, 2);

        Rule rule = new NoNotVisitedAdjacentNodesInSameRegionRule(region, allRegions);

        Assert.assertTrue(rule.isBroken());

    }

    @Test
    public void nodeVisitedEdgesTestTrue() {
        setup();
        region = board.subList(0, 2);
        EdgeCreator.addExternalEdge(region.get(0));

        Rule rule = new NoNotVisitedAdjacentNodesInSameRegionRule(region, allRegions);

        Assert.assertFalse(rule.isBroken());

    }

    @Test
    public void nodeEdgesTestTrue() {
        setup();
        region = board.subList(1, 3);

        Rule rule = new NoNotVisitedAdjacentNodesInSameRegionRule(region, allRegions);

        Assert.assertFalse(rule.isBroken());

    }


}
