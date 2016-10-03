package ar.fiuba.tdd.tp.nikoligames.view.painters;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.cells.CellView;

/**
 * Pinta la celda marcandola como invalida.
 */
public class InvalidBackgroundPainter implements CellPainter {

    @Override
    public void paintCell(CellView cell) {
        cell.setBaseBackground(ColorSet.INVALID_BACKGROUND);
    }
}
