package ar.fiuba.tdd.tp.nikoligames.model.rules.utils;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.ConcreteNode;
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
            region.add(new ConcreteNode(Constants.CLEAR_STRING, false));
        }
        return region;
    }
}
