package ar.fiuba.tdd.tp.nikoligames.engine.model.rules.generators;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.AbstractNode;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 10/7/2016.
 */
public class AdjacentRulesGeneretor {
    private final Board board;

    public AdjacentRulesGeneretor(Board board) {
        this.board = board;
    }

    public List<Rule> getHorizontalRules() {
        List<Rule> rulesGenerated = new ArrayList<Rule>();
        for (int i = 1; i <= board.getRows(); i++) {
            for (int j = 1; j <= board.getCols(); j++) {
                ClassicPosition position = new ClassicPosition(i, j);

                ClassicPosition positionAdjacentLeft = new ClassicPosition(i, j - 1);
                ClassicPosition positionAdjacentRight = new ClassicPosition(i, j + 1);

                AbstractNode node = board.getNode(position);

            }
        }
        return null;
    }
}
