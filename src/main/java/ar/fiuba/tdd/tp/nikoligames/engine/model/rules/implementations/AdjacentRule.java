package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by german on 10/6/2016.
 */
public class AdjacentRule extends RuleImplementation {

    private List<AbstractNode> adjacentNodes;

    public AdjacentRule(ArrayList<AbstractNode> region, ArrayList<AbstractNode> adjacentNodes) {
        super(region, "");
        this.adjacentNodes = adjacentNodes;
    }

    @Override
    public boolean isBroken() {
        Iterator<AbstractNode> regionIterator = region.iterator();
        while (regionIterator.hasNext()) {
            AbstractNode node = regionIterator.next();
            List<AbstractNode> edgeList = node.getEdgeList();
            if (!adjacentNodes.containsAll(edgeList)) { //si algún nodo conectado no esta en la lista de adyacencia
                return true;
            }
        }
        return false;
    }
}
