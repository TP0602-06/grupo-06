package ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.helpers;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.DrawableCell;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;

public interface AbstractDrawCellFromModelHelper {
    CellView drawCellFromModel(DrawableCell modelCell);
}
