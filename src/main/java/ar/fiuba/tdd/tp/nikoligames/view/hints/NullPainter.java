package ar.fiuba.tdd.tp.nikoligames.view.hints;

import ar.fiuba.tdd.tp.nikoligames.view.clickables.Paintable;
import ar.fiuba.tdd.tp.nikoligames.view.painters.CellPainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.builder.PainterBuilder;

/**
 * Created by fedebrasburg on 10/17/16.
 */
public class NullPainter implements HintPainter {

    private boolean isEmpty = true;
    private boolean isEditable = false;

    public NullPainter() {

    }

    public void draw(Paintable paintable) {
        PainterBuilder builder = new PainterBuilder(isEmpty, isEditable);
        CellPainter painter = builder.end();
        painter.paintCell(paintable);

    }
}
