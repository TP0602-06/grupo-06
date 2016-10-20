package ar.fiuba.tdd.tp.nikoligames.view.painters;

import ar.fiuba.tdd.tp.nikoligames.view.clickables.Paintable;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase pinta una celda con varios pintores.
 */
public class MultiplePainter implements CellPainter {
    private List<CellPainter> painters;

    public MultiplePainter() {
        this.painters = new ArrayList<>();
    }

    @Override
    public void paintCell(Paintable paintable) {
        painters.forEach((painter) -> painter.paintCell(paintable));
    }

    public void addPainter(CellPainter painter) {
        painters.add(painter);
    }
}
