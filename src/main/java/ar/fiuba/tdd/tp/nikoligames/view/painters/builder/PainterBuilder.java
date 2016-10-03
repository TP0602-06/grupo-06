package ar.fiuba.tdd.tp.nikoligames.view.painters.builder;

import ar.fiuba.tdd.tp.nikoligames.view.painters.*;
import ar.fiuba.tdd.tp.nikoligames.view.painters.bordercell.BorderCellPainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.inncercellvalues.BottomLeftValuePainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.inncercellvalues.BottomRightValuePainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.inncercellvalues.TopLeftValuePainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.inncercellvalues.TopRightValuePainter;

/**
 * Builder para el pintor de la celda.
 */
public class PainterBuilder {
    public static Integer BOLD = 4;
    public static Integer NORMAL = 1;
    public static Integer NONE = 0;

    public static Integer TOP = 0;
    public static Integer LEFT = 1;
    public static Integer BOTTOM = 2;
    public static Integer RIGHT = 3;

    private MultiplePainter painter;

    public PainterBuilder(boolean isEmpty, boolean isEditable) {
        painter = new MultiplePainter();

        if (!isEditable && isEmpty) {
                invalidBackground();
                disable();
        } else {
            normalBackground();
        }

    }

    private void normalBackground() {
        painter.addPainter(new NormalBackgroundPainter());
    }

    private void invalidBackground() {
        painter.addPainter(new InvalidBackgroundPainter());
    }

    private void disable(){
        painter.addPainter(new DisablePainter());
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

    public void bottomRightValue(String value) {
        painter.addPainter(new BottomRightValuePainter(value));
    }

    public void border(Integer size, Integer side) {
        painter.addPainter(new BorderCellPainter(size,side));
    }
    public CellPainter end() {
        return painter;
    }

}
