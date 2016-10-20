package ar.fiuba.tdd.tp.nikoligames.model.rules.utils;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.ConcreteNode;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by german on 10/14/2016.
 */
public class NodeWithValueCreator {
    public static List<AbstractNode> createNodesWithValues(List<String> values, boolean editable) {
        return values.stream()
                .map(value -> new ConcreteNode(value, editable))
                .collect(Collectors.toList());
    }
}
