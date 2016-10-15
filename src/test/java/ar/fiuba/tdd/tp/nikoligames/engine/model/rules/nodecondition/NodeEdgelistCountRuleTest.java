package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.nodecondition;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.nodecondition.NodeEdgelistCountRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.utils.DefaultRegionCreator;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.utils.EdgeCreator;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by german on 10/15/2016.
 */
public class NodeEdgelistCountRuleTest {

    @Test
    public void ruleWithNoEdges() {
        List<AbstractNode> board = DefaultRegionCreator.createRegion(4);
        List<AbstractNode> region = board.subList(0, 1);//just rootNode
        Rule rule = new NodeEdgelistCountRule(region, "0");

        Assert.assertFalse(rule.isBroken());
        Assert.assertFalse(rule.isActualBroken());
    }

    @Test
    public void ruleWithEdges() {
        List<AbstractNode> board = DefaultRegionCreator.createRegion(4);
        List<AbstractNode> region = board.subList(0, 1);//just rootNode

        List<AbstractNode> connectedToFirstNode = board.subList(1, 4);
        EdgeCreator.addUndirectedEdgesBetweenNodeAndEachNodeFromList(region.get(0), connectedToFirstNode);

        Rule rule = new NodeEdgelistCountRule(region, "3");

        Assert.assertFalse(rule.isBroken());
        Assert.assertFalse(rule.isActualBroken());

    }

}
