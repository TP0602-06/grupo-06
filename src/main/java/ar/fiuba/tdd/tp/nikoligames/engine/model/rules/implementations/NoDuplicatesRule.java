package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleImplementation;
import utils.Constants;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by german on 9/30/2016.
 */
public class NoDuplicatesRule extends RuleImplementation {
    public NoDuplicatesRule(ArrayList<AbstractNode> nodes) {
        super(nodes, Constants.EMPTY_STRING);
    }

    @Override
    public boolean isBroken() {
        return check();
    }

    @Override
    public boolean isActualBroken() {
        return check();
    }

    private boolean check() {
        List<String> values = region.stream().map(n -> n.getValue()).collect(Collectors.toList());
        return values.stream()
                .filter(v -> !v.equals(Constants.EMPTY_STRING))
                .anyMatch(nodeValue -> Collections.frequency(values, nodeValue) > 1);
    }
}
