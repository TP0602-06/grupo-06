package ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.possibleedges;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;

import java.util.List;

/**
 * Created by tobias on 18/10/16.
 */
public interface EdgePositionGenerator {

    List<EdgePosition> getPossibleEdgePositions();
}
