package ar.fiuba.tdd.tp.nikoligames.view.painters;

import ar.fiuba.tdd.tp.nikoligames.view.clickables.Paintable;

/**
 * Created by tobias on 20/10/16.
 */
public class TransparentPainter implements CellPainter {

    @Override
    public void paintCell(Paintable paintable) {
        paintable.setOpaque(false);
    }
}
