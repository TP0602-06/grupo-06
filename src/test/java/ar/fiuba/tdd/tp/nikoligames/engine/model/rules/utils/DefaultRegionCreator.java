package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.utils;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.ConcreteNode;
import utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 10/14/2016.
 */
public class DefaultRegionCreator {
    public static List<AbstractNode> createRegion(int size) {
        ArrayList<AbstractNode> region = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            region.add(new ConcreteNode(Constants.EMPTY_STRING, false));
        }
        return region;
    }
}
