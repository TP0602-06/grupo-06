package ar.fiuba.tdd.tp.nikoligames.view.hints;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.Paintable;
import ar.fiuba.tdd.tp.nikoligames.view.graphics.GraphicDraw;
import ar.fiuba.tdd.tp.nikoligames.view.graphics.LineGraphicDraw;
import ar.fiuba.tdd.tp.nikoligames.view.graphics.LinePosition;
import ar.fiuba.tdd.tp.nikoligames.view.painters.CellPainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.builder.PainterBuilder;

import java.awt.*;

/**
 * Created by fedebrasburg on 10/17/16.
 */
public class KakuroPainter implements HintPainter {

    private String leftNumber;
    private String rightNumber;
    private int left = 0;
    private int right = 1;
    private String regex = "-";

    public KakuroPainter(String numbers) {
        leftNumber = numbers.split(regex)[left];
        rightNumber = numbers.split(regex)[right];
    }

    public void draw(Paintable paintable) {
        PainterBuilder builder = new PainterBuilder();
        builder.bottomLeftValue(leftNumber);
        builder.topRightValue(rightNumber);
        builder.backgroundColor(ColorSet.INVALID_BACKGROUND);
        CellPainter painter = builder.end();
        painter.paintCell(paintable);

        GraphicDraw graphicDraw = new LineGraphicDraw(Color.BLACK, LinePosition.TOP_LEFT, LinePosition.BOTTOM_RIGHT);
        paintable.addGraphic(graphicDraw);
    }
}
