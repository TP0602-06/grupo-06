package ar.fiuba.tdd.tp.nikoligames.view.cells;

import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.painters.CellPainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.builder.PainterBuilder;

import javax.swing.*;

/**
 * Created by fedebrasburg on 10/17/16.
 */
public class ContentCell implements CellHint {
    private String content;

    public ContentCell(String content) {
        this.content = content;
    }

    public void draw(CellView cell) {
        PainterBuilder painterBuilder = new PainterBuilder(false, false);
        painterBuilder.centerValue(content);
        CellPainter painter = painterBuilder.end();
        painter.paintCell(cell);
    }
}
