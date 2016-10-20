package ar.fiuba.tdd.tp.nikoligames.view.hints;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.Paintable;
import ar.fiuba.tdd.tp.nikoligames.view.graphics.CircleGraphicDraw;
import ar.fiuba.tdd.tp.nikoligames.view.graphics.LinePosition;
import ar.fiuba.tdd.tp.nikoligames.view.painters.builder.PainterBuilder;

import java.awt.*;

/**
 * Created by tobias on 19/10/16.
 */
public class SlitherPainter implements HintPainter {
    private boolean empty = true;
    private boolean editable = false;
    private Integer radius = 10;
    private Color circleColor = ColorSet.INVALID_BACKGROUND;

    @Override
    public void draw(Paintable paintable) {
        PainterBuilder builder = new PainterBuilder(empty,editable);
        builder.border(0,PainterBuilder.TOP);
        builder.border(0,PainterBuilder.BOTTOM);
        builder.border(0,PainterBuilder.LEFT);
        builder.border(0,PainterBuilder.RIGHT);
        builder.end().paintCell(paintable);


        paintable.addGraphic(new CircleGraphicDraw(radius, LinePosition.TOP_LEFT,circleColor));
        paintable.addGraphic(new CircleGraphicDraw(radius, LinePosition.TOP_RIGHT,circleColor));
        paintable.addGraphic(new CircleGraphicDraw(radius, LinePosition.BOTTOM_LEFT,circleColor));
        paintable.addGraphic(new CircleGraphicDraw(radius, LinePosition.BOTTOM_RIGHT,circleColor));
    }
}
