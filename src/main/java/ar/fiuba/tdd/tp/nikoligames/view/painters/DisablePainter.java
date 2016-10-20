package ar.fiuba.tdd.tp.nikoligames.view.painters;

import ar.fiuba.tdd.tp.nikoligames.view.clickables.Paintable;

/**
 * Deshabilita la celda a ser clickeada.
 */
public class DisablePainter implements CellPainter {

    @Override
    public void paintCell(Paintable paintable) {
        paintable.setEnabled(false);
    }
}
