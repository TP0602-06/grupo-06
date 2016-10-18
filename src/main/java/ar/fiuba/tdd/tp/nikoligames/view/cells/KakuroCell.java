package ar.fiuba.tdd.tp.nikoligames.view.cells;

import ar.fiuba.tdd.tp.nikoligames.view.graphics.GraphicDraw;
import ar.fiuba.tdd.tp.nikoligames.view.graphics.LineGraphicDraw;
import ar.fiuba.tdd.tp.nikoligames.view.graphics.LinePosition;
import ar.fiuba.tdd.tp.nikoligames.view.painters.CellPainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.builder.PainterBuilder;
import javafx.scene.control.Cell;

import java.awt.*;

/**
 * Created by fedebrasburg on 10/17/16.
 */
public class KakuroCell implements CellHint {

    private String leftNumber;
    private String rightNumber;
    private  int left = 0;
    private  int right = 1;
    private String regex = " ";

    public KakuroCell(String numbers){
        leftNumber = numbers.split(regex)[left];
        rightNumber = numbers.split(regex)[right];
    }

    public void draw(CellView cell){
        PainterBuilder p = new PainterBuilder(false, false);
        p.bottomLeftValue(leftNumber);
        p.topRightValue(rightNumber);
        CellPainter painter = p.end();
        painter.paintCell(cell);

        GraphicDraw graphicDraw = new LineGraphicDraw(Color.BLACK, LinePosition.BOTTOM_LEFT,LinePosition.TOP_RIGHT);
        cell.addGraphic(graphicDraw);
    }
}
