package ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.possibleedges;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.model.rules.generators.adjacentlist.BoardAdjacentList;
import ar.fiuba.tdd.tp.nikoligames.parser.utils.GameConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tobias on 18/10/16.
 */
public class NullEdgePositionGenerator implements EdgePositionGenerator {

    public List<EdgePosition> getPossibleEdgePositions() {
        return new ArrayList<>();
    }

}
