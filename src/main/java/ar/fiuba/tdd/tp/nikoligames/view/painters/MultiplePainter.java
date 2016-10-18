package ar.fiuba.tdd.tp.nikoligames.view.painters;

import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.CellView;

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
    public void paintCell(CellView cell) {
        painters.forEach((painter) -> painter.paintCell(cell));
    }

    public void addPainter(CellPainter painter) {
        painters.add(painter);
    }
}
