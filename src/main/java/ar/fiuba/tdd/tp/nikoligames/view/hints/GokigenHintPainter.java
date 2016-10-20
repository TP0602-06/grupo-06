package ar.fiuba.tdd.tp.nikoligames.view.hints;

import ar.fiuba.tdd.tp.nikoligames.view.clickables.Paintable;
import ar.fiuba.tdd.tp.nikoligames.view.graphics.CircleGraphicDraw;
import ar.fiuba.tdd.tp.nikoligames.view.graphics.LinePosition;
import ar.fiuba.tdd.tp.nikoligames.view.painters.builder.PainterBuilder;

import java.awt.*;

/**
 * Created by tobias on 19/10/16.
 */
public class GokigenHintPainter implements HintPainter {
    private String value;

    public GokigenHintPainter(String value) {
        this.value = value;
    }

    @Override
    public void draw(Paintable paintable) {
        PainterBuilder painterBuilder = new PainterBuilder(false, true);
        painterBuilder.noBackground();
        painterBuilder.bottomLeftValue(value);
        painterBuilder.bottomRightValue(value);
        painterBuilder.end().paintCell(paintable);
    }
}
