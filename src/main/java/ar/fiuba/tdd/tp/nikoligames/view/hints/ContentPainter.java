package ar.fiuba.tdd.tp.nikoligames.view.hints;

import ar.fiuba.tdd.tp.nikoligames.view.clickables.Paintable;
import ar.fiuba.tdd.tp.nikoligames.view.painters.CellPainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.builder.PainterBuilder;

/**
 * Created by fedebrasburg on 10/17/16.
 */
public class ContentPainter implements HintPainter {
    private String content;

    public ContentPainter(String content) {
        this.content = content;
    }

    public void draw(Paintable paintable) {
        PainterBuilder painterBuilder = new PainterBuilder();
        painterBuilder.centerValue(content);
        CellPainter painter = painterBuilder.end();
        painter.paintCell(paintable);
    }
}
