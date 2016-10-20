package ar.fiuba.tdd.tp.nikoligames.view.painters;

import ar.fiuba.tdd.tp.nikoligames.view.clickables.Paintable;

import java.awt.*;

/**
 * Created by tobias on 18/10/16.
 */
public class BackgroundPainter implements CellPainter {
    private Color color;

    public BackgroundPainter(Color color) {
        this.color = color;
    }

    @Override
    public void paintCell(Paintable paintable) {
        paintable.setBackground(color);
    }
}
