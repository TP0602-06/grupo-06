package ar.fiuba.tdd.tp.nikoligames.view.painters;

import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.CellView;

/**
 * Deshabilita la celda a ser clickeada.
 */
public class DisablePainter implements CellPainter {

    @Override
    public void paintCell(CellView cell) {
        cell.setEnabled(false);
    }
}
