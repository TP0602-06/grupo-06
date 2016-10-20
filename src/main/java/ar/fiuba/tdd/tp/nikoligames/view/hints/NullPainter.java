package ar.fiuba.tdd.tp.nikoligames.view.hints;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.Paintable;
import ar.fiuba.tdd.tp.nikoligames.view.painters.CellPainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.builder.PainterBuilder;

/**
 * Created by fedebrasburg on 10/17/16.
 */
public class NullPainter implements HintPainter {

    public void draw(Paintable paintable) {
        PainterBuilder builder = new PainterBuilder();
        builder.backgroundColor(ColorSet.INVALID_BACKGROUND);
        CellPainter painter = builder.end();
        painter.paintCell(paintable);

    }
}
