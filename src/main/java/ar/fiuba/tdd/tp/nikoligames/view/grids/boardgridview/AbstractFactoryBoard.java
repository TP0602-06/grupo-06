package ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

/**
 * Es la factory de la grilla para el tablero.
 */
public interface AbstractFactoryBoard {
    GridView createBoardView(DrawableBoard modelBoard);
}
