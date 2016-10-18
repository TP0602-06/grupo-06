package ar.fiuba.tdd.tp.nikoligames.view.cells;

import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleType;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.cells.CellView;
import ar.fiuba.tdd.tp.nikoligames.view.painters.CellPainter;
import ar.fiuba.tdd.tp.nikoligames.view.painters.builder.PainterBuilder;

import javax.swing.*;

/**
 * Created by fedebrasburg on 10/18/16.
 */
public class InshiCell implements CellHint{
    private String content;
    public  InshiCell(String content){
        this.content = content;
    }

    public void draw(CellView cell){
        PainterBuilder painterBuilder = new PainterBuilder(false,true);
        painterBuilder.topLeftValue(content);
        CellPainter painter = painterBuilder.end();
        painter.paintCell(cell);
    }
}
