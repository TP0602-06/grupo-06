package ar.fiuba.tdd.tp.nikoligames.view.painters.builder;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.painters.*;
import ar.fiuba.tdd.tp.nikoligames.view.painters.bordercell.BorderCellPainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.inncercellvalues.*;

import java.awt.*;

/**
 * Builder para el pintor de la celda.
 */
public class PainterBuilder {
    public static final Integer BOLD = 4;
    public static final Integer NORMAL = 1;
    public static final Integer NONE = 0;

    public static final Integer TOP = 0;
    public static final Integer LEFT = 1;
    public static final Integer BOTTOM = 2;
    public static final Integer RIGHT = 3;

    private MultiplePainter painter;

    public PainterBuilder() {
        painter = new MultiplePainter();
        backgroundColor(ColorSet.NORMAL_BACKGROUND);
    }

    public void backgroundColor(Color color) {
        painter.addPainter(new BackgroundPainter(color));
    }

    public void topLeftValue(String value) {
        painter.addPainter(new TopLeftValuePainter(value));
    }

    public void topRightValue(String value) {
        painter.addPainter(new TopRightValuePainter(value));
    }

    public void bottomLeftValue(String value) {
        painter.addPainter(new BottomLeftValuePainter(value));
    }

    public void centerValue(String value) {
        painter.addPainter(new CenterValuePainter(value));
    }

    public void bottomRightValue(String value) {
        painter.addPainter(new BottomRightValuePainter(value));
    }

    public void border(Integer size, Integer side) {
        painter.addPainter(new BorderCellPainter(size, side));
    }

    public void noBackground() {
        painter.addPainter(new TransparentPainter());
    }

    public CellPainter end() {
        return painter;
    }

}
