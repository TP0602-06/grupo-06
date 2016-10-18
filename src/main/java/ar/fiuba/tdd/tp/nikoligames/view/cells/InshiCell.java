package ar.fiuba.tdd.tp.nikoligames.view.cells;

import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.painters.CellPainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.builder.PainterBuilder;

/**
 * Created by fedebrasburg on 10/18/16.
 */
public class InshiCell implements CellHint {
    private boolean isEmpty = true;
    private boolean isEditable = true;
    private String content;

    public void draw(CellView cell) {
        PainterBuilder pb = new PainterBuilder(isEmpty,isEditable);
        pb.topLeftValue(content);
        CellPainter painter = pb.end();
        painter.paintCell(cell);
    }

    public InshiCell(String number) {
        this.content = number;
    }

}
