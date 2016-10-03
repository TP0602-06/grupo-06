package ar.fiuba.tdd.tp.nikoligames.view.grids.boardgridview.helpers.rulehelper;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.DrawableCell;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.painters.CellPainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.builder.PainterBuilder;

/**
 * Esta clase se encarga de pintar la celda de acuerdo a las reglas existentes.
 */
public class CellViewMakeUpHelper {

    public void beautyfy(CellView cellView, DrawableCell baseCell) {
        boolean isEmpty = baseCell.isEmpty();
        boolean isEditable = baseCell.isEditable();
        PainterBuilder painterCellBuilder = new PainterBuilder(isEmpty,isEditable);
        CellPainter painter = painterCellBuilder.end();
        //TODO ver rules y setear builder correspondiente
        painter.paintCell(cellView);
    }
}
