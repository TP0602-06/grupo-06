package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.nodecondition;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleImplementation;

import java.util.List;

/**
 * Responsabilidades: Verificar que se cumpla la regla de cantidad de aristas que debe tener
 * determinado nodo del juego. Se debe checkear en otra aregla que las adjacencias sean correctas y no estén repetidas
 */
public class NodeEdgelistCountRule extends RuleImplementation {
    private int countRule;

    public NodeEdgelistCountRule(List<AbstractNode> region, String value) {
        super(region, value);
        countRule = Integer.parseInt(value);
    }

    @Override
    public boolean isBroken() {
        int edgeListSize = getEdgeListSize();
        return (edgeListSize != countRule);
    }

    private int getEdgeListSize() {
        AbstractNode node = region.get(0);
        List<AbstractNode> edgelist = node.getEdgeList();
        return edgelist.size();
    }

    @Override
    public boolean isActualBroken() {
        int edgeListSize = getEdgeListSize();
        if (edgeListSize <= countRule) {
            return false;
        }
        return true;
    }
}
