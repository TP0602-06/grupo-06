package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.circuit;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleImplementation;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.circuit.helper.edgecounthelper.EdgeCountHelper;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.circuit.helper.edgecounthelper.InOrOutOfRegionEdgeCountHelper;

import java.util.List;

/**
 * Responsabilidades: verifica que cada nodo de la region sea visitado como mucho una vez por el circuito.
 */
public class RegionVisitedAtMostOnceRule extends RuleImplementation {

    private final EdgeCountHelper edgeCountHelper;

    public RegionVisitedAtMostOnceRule(List<AbstractNode> region) {
        super(region, "");
        edgeCountHelper = new InOrOutOfRegionEdgeCountHelper(region);
    }

    @Override
    public boolean isBroken() {
        int inOrOutEdgesCount = edgeCountHelper.getCount();
        if ((inOrOutEdgesCount == 2) || (inOrOutEdgesCount == 0)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isActualBroken() {
        int inOrOutEdgesCount = edgeCountHelper.getCount();
        if ((inOrOutEdgesCount <= 2) && (inOrOutEdgesCount >= 0)) {
            return false;
        }
        return true;
    }
}
