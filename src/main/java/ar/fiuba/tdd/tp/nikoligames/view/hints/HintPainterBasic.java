package ar.fiuba.tdd.tp.nikoligames.view.hints;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.DrawableNode;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.Paintable;
import ar.fiuba.tdd.tp.nikoligames.view.painters.CellPainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.builder.PainterBuilder;

/**
 * Created by tobias on 18/10/16.
 */
public class HintPainterBasic implements HintPainter {
    private DrawableNode modelCell;

    public HintPainterBasic(DrawableNode modelCell) {
        this.modelCell = modelCell;
    }

    @Override
    public void draw(Paintable paintable) {
        CellPainter painter = new PainterBuilder(modelCell.isEmpty(), modelCell.isEditable()).end();
        painter.paintCell(paintable);
    }
}
