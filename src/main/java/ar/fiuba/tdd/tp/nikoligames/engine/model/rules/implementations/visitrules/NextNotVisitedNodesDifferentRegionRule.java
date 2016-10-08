package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.visitrules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by german on 10/6/2016.
 */
public class NextNotVisitedNodesDifferentRegionRule extends VisitRule {

    private final List<List<AbstractNode>> regions;

    //la region seria cada par de celda contiguas o adyacentes
    public NextNotVisitedNodesDifferentRegionRule(ArrayList<AbstractNode> region, List<List<AbstractNode>> regions) {
        super(region, "");
        this.regions = regions;
    }

    @Override
    public boolean isBroken() {

        AbstractNode node1 = region.get(0);
        AbstractNode node2 = region.get(1);
        if (!this.isVisited(node1) || (!this.isVisited(node2))) {
            return false;
        }
        //si ninguno esta visitado
        Iterator<List<AbstractNode>> regionsIterator = regions.iterator();
        while (regionsIterator.hasNext()) {
            List<AbstractNode> region = regionsIterator.next();
            if (region.contains(node1) || (region.contains(node2))) {
                //solo si son No visitadas en distintas regiones se rompe la regla
                if (((region.contains(node1)) && (region.contains(node2)))) {
                    return false;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean isActualBroken() {
        return isBroken();//TODO revisar
    }


}
