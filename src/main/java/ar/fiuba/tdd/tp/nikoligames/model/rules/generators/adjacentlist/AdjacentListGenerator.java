package ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;

import java.util.List;
import java.util.Map;

/**
 * Created by german on 10/9/2016.
 * Responsabilities:
 * 1. Creates a List of generators. Which is a map with a key that is a Abstract Node and a value which is a list of all the adjacent Nodes.
 */
public interface AdjacentListGenerator {
    Map<AbstractNode, List<AbstractNode>> getAdjacentList();
}
