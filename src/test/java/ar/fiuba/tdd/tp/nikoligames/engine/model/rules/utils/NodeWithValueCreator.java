package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.utils;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by german on 10/14/2016.
 */
public class NodeWithValueCreator {
    public static List<AbstractNode> createNodesWithValues(List<String> values, boolean editable) {
        List<AbstractNode> nodes = new ArrayList<AbstractNode>();
        Iterator<String> valueIterator = values.iterator();
        while (valueIterator.hasNext()) {
            String value = valueIterator.next();
            AbstractNode node = new ConcreteNode(value, editable);
            nodes.add(node);
        }
        return nodes;
    }
}
