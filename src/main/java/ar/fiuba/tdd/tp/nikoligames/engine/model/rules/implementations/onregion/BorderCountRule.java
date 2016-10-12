package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.onregion;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleImplementation;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.edgecounthelper.EdgeCountHelper;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.edgecounthelper.EdgesInsideRegionCountHelper;

import java.util.List;

/**
 * Responsabilidades:
 * Contar la cantidad de aristas internas a la region, para Slitherlink debe ser una region de 4 nodos de una celda.
 */
public class BorderCountRule extends RuleImplementation {
    private final EdgeCountHelper edgeCountHelper;
    private final int countRule;

    public BorderCountRule(List<AbstractNode> region, String value) {
        super(region, value);
        edgeCountHelper = new EdgesInsideRegionCountHelper(region);
        countRule = Integer.parseInt(value);

    }

    @Override
    public boolean isBroken() {
        int count = edgeCountHelper.getCount();
        return (count == countRule);
    }

    @Override
    public boolean isActualBroken() {
        int count = edgeCountHelper.getCount();
        return (count <= countRule);
    }
}
