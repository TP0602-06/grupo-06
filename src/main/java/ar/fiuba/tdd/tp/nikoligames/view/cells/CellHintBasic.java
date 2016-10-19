package ar.fiuba.tdd.tp.nikoligames.view.cells;

import ar.fiuba.tdd.tp.nikoligames.model.board.DrawableBoard;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.DrawableNode;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.painters.CellPainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.builder.PainterBuilder;

/**
 * Created by tobias on 18/10/16.
 */
public class CellHintBasic implements CellHint {
    private DrawableNode modelCell;

    public CellHintBasic(DrawableNode modelCell) {
        this.modelCell = modelCell;
    }

    @Override
    public void draw(CellView cell) {
        CellPainter painter = new PainterBuilder(modelCell.isEmpty(), modelCell.isEditable()).end();
        painter.paintCell(cell);
    }
}
