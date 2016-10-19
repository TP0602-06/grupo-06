package ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview;

import ar.fiuba.tdd.tp.nikoligames.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.edge.DrawableEdge;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;
import ar.fiuba.tdd.tp.nikoligames.view.parentview.GameView;

import java.util.HashSet;

/**
 * Responsabilidades:
 * 1. Crear una abstracción para la encapsulación de la creación de una grilla para el tablero o board
 * Patrón:
 * 1. Abstract Factory
 */
public interface FactoryBoard {

    GridView createGridView(boolean nodeMatchesCell);

    void addInputs(GameView view, HashSet<String> inputs);

}
