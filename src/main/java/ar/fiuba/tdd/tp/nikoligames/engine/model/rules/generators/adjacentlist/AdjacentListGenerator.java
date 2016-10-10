package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.generators.adjacentlist;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;

import java.util.List;
import java.util.Map;

/**
 * Created by german on 10/9/2016.
 */
public interface AdjacentListGenerator {
    Map<AbstractNode, List<AbstractNode>> getAdjacentList();
}
