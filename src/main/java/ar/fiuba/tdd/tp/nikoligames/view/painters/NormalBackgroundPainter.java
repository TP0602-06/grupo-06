package ar.fiuba.tdd.tp.nikoligames.view.painters;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;

/**
 * Pinta el fondo de la celda con el color basico.
 */
public class NormalBackgroundPainter implements CellPainter {

    @Override
    public void paintCell(CellView cell) {
        cell.setBaseBackground(ColorSet.NORMAL_BACKGROUND);
    }
}
