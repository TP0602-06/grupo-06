package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by german on 10/6/2016.
 */
public class VisitedCountRule extends RuleImplementation {

    public VisitedCountRule(ArrayList<Node> region, String value) {
        super(region, value);
    }

    @Override
    public boolean isBroken() {
        int count = 0;

        Iterator<Node> regionIterator = region.iterator();
        while (regionIterator.hasNext()) {
            Node node = regionIterator.next();
            if (!this.isVisited(node)) {
                count++;
            }
        }
        if (count == Integer.parseInt(value)) {
            return false;
        }
        return true;
    }

    private boolean isVisited(Node node) {
        List<Node> edgeList = node.getEdgeList();
        int size = edgeList.size();
        if (size == 0) {
            return false;
        } else {
            return true;
        }
    }
}
