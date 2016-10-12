package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.visitrules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.onregion.AbstractRegionRule;

import java.util.List;

/**
 * Responsabilidades: regla para contar cuantos nodos de la region están visitados.
 */
public class RegionCountVisited extends AbstractRegionRule {

    private int count = 0;
    private int countRule;

    public RegionCountVisited(List<AbstractNode> region, String value) {
        super(region, value);
        countRule = Integer.parseInt(value);
    }

    @Override
    public boolean isActualBroken() {
        return super.isBroken();
    }

    @Override
    public boolean isBroken() {
        boolean visitedMoreThanCountRule = super.isBroken();
        if (visitedMoreThanCountRule == true) {
            return true;
        }
        if (count == countRule) {
            return false;
        }
        return true;
    }

    @Override
    protected boolean nodeCondition(AbstractNode node) {
        if (VisitedHelper.isVisited(node)) {
            count++;
            if (count > countRule) {
                return true;
            }
        }
        return false;
    }
}
