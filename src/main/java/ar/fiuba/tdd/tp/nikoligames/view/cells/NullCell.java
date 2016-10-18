package ar.fiuba.tdd.tp.nikoligames.view.cells;

import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.painters.CellPainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.builder.PainterBuilder;

import javax.swing.*;

/**
 * Created by fedebrasburg on 10/17/16.
 */
public class NullCell implements CellHint {

    private boolean isEmpty = true;
    private boolean isEditable = false;

    public NullCell() {

    }

    public void draw(CellView cell) {
        PainterBuilder builder = new PainterBuilder(isEmpty, isEditable);
        CellPainter painter = builder.end();
        painter.paintCell(cell);

    }
}
