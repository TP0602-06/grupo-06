package ar.fiuba.tdd.tp.nikoligames.view.parentview.factory.possibleedges;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;

import java.util.List;

/**
 * Esta interfaz responde a obtener todos los posibles edges del juego.
 */
public interface EdgePositionGenerator {

    List<EdgePosition> getPossibleEdgePositions();
}
