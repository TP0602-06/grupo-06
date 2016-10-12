package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.visitrules.VisitedHelper;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by german on 10/12/2016.
 */
public class CircuitHelper {
    private final List<AbstractNode> region;

    public CircuitHelper(List<AbstractNode> region){
        this.region = region;
    }
    public List<List<AbstractNode>> getAllCircuits(){
        List<AbstractNode> seenNodes = new ArrayList<AbstractNode>();

        Iterator<AbstractNode> regionIterator = region.iterator();
        while (regionIterator.hasNext()) {
            AbstractNode node = regionIterator.next();
            if ((VisitedHelper.isVisited(node)) && (!seenNodes.contains(node))){
                List<List<AbstractNode>> circuits = getCircuitsStartingFromNode(node,seenNodes);
            }

        }
        return null;
    }

    private List<List<AbstractNode>> getCircuitsStartingFromNode(AbstractNode node,List<AbstractNode> seenNodes) {
        List<List<AbstractNode>> circuits = new ArrayList<List<AbstractNode>>();
        seenNodes.add(node);
        //TODO recorrer todos los caminos, si se corta es un circuito hasta ahi,
        // si encuentra uno de los vistos tambien corta, todo corta si no hay mas caminos por recorrer
        List<AbstractNode> edgelist = node.getEdgeList();
        Iterator<AbstractNode> edgeListIterator = edgelist.iterator();
        while (edgeListIterator.hasNext()){
            AbstractNode nextNode = edgeListIterator.next();
        }
        return circuits;
    }

    public boolean isClosed(List<AbstractNode> circuit){
        return false;
    }
    public boolean isUnique(List<List<AbstractNode>> circuits){
        return (circuits.size() == 1);
    }
}
