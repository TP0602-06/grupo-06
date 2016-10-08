package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.generators;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.implementations.onregion.AdjacentRule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 10/8/2016.
 */
public abstract class BoardAdjacentRules implements AbstractAdjacentRules {

    protected final Board board;

    public BoardAdjacentRules(Board board){
        this.board = board;
    }

    public List<Rule> getAdjacentRules() {
        List<Rule> rulesGenerated = new ArrayList<Rule>();

        for (int i = 1; i <= board.getRows(); i++) {
            for (int j = 1; j <= board.getCols(); j++) {
                ClassicPosition position = new ClassicPosition(i, j);
                AbstractNode node = board.getNode(position);

                List<AbstractNode> region = new ArrayList<AbstractNode>();
                region.add(node);

                List<AbstractNode> adjacentList = getAjacentListForNode(i, j);

                Rule rule = new AdjacentRule(region,adjacentList);
                rulesGenerated.add(rule);
            }
        }
        return rulesGenerated;
    }

    abstract List<AbstractNode> getAjacentListForNode(int i, int j);
}
