package ar.fiuba.tdd.tp.nikoligames.view.hints;

import ar.fiuba.tdd.tp.nikoligames.view.clickables.Paintable;
import ar.fiuba.tdd.tp.nikoligames.view.painters.CellPainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.builder.PainterBuilder;

/**
 * Created by fedebrasburg on 10/18/16.
 */
public class InshiPainter implements HintPainter {
    private String content;
    private boolean isEmpty = true;
    private boolean isEditable = true;

    public void draw(Paintable paintable) {
        PainterBuilder pb = new PainterBuilder(isEmpty,isEditable);
        pb.topLeftValue(content);
        CellPainter painter = pb.end();
        painter.paintCell(paintable);
    }

    public InshiPainter(String number) {
        this.content = number;
    }

}
