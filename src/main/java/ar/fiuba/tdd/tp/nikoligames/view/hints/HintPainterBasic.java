package ar.fiuba.tdd.tp.nikoligames.view.hints;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.DrawableNode;
import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.Paintable;
import ar.fiuba.tdd.tp.nikoligames.view.painters.CellPainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.builder.PainterBuilder;

/**
 * Created by tobias on 18/10/16.
 */
public class HintPainterBasic implements HintPainter {

    @Override
    public void draw(Paintable paintable) {
        PainterBuilder builder = new PainterBuilder();
        CellPainter painter = builder.end();
        painter.paintCell(paintable);
    }
}
