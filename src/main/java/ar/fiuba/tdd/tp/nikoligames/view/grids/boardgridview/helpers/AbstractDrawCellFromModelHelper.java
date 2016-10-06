package ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.helpers;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.DrawableNode;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;

/**
 * Define la interfaz del creador de celdas de la vista a partir de las celdas del modelo.
 */

public interface AbstractDrawCellFromModelHelper {
    CellView drawCellFromModel(DrawableNode modelCell);
}
