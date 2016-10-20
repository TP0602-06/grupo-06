package ar.fiuba.tdd.tp.nikoligames.view.painters.bordercell;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.Paintable;
import ar.fiuba.tdd.tp.nikoligames.view.painters.CellPainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.builder.PainterBuilder;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;


/**
 * Pinta los bordes de la celda.
 */
public class BorderCellPainter implements CellPainter {

    private Integer size;
    private Integer side;

    public BorderCellPainter(Integer size, Integer side) {
        this.size = size;
        this.side = side;
    }

    @Override
    public void paintCell(Paintable paintable) {
        Border previousBorder = paintable.getBorder();
        Insets previousSizes = previousBorder.getBorderInsets(paintable);
        Insets newInsets = makeNewInset(previousSizes);
        Border newBorder = makeNewBorder(newInsets);
        paintable.setBorder(newBorder);
    }

    private Border makeNewBorder(Insets newInsets) {
        Integer top = newInsets.top;
        Integer bottom = newInsets.bottom;
        Integer left = newInsets.left;
        Integer right = newInsets.right;
        return BorderFactory.createMatteBorder(top, left, bottom, right, ColorSet.BORDER);
    }

    private Insets makeNewInset(Insets previousInset) {
        Insets newInset = new Insets(0, 0, 0, 0);
        newInset.top = actualSideSize(previousInset.top, PainterBuilder.TOP);
        newInset.left = actualSideSize(previousInset.left, PainterBuilder.LEFT);
        newInset.bottom = actualSideSize(previousInset.bottom, PainterBuilder.BOTTOM);
        newInset.right = actualSideSize(previousInset.right, PainterBuilder.RIGHT);
        return newInset;
    }

    private Integer actualSideSize(Integer previousValue, Integer side) {
        if (this.side.equals(side)) {
            return this.size;
        }
        if (previousValue > PainterBuilder.BOLD) {
            return PainterBuilder.NORMAL;
        }
        return previousValue;
    }
}
