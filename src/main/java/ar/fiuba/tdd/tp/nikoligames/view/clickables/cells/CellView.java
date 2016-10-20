package ar.fiuba.tdd.tp.nikoligames.view.clickables.cells;

import ar.fiuba.tdd.tp.nikoligames.view.clickables.Paintable;

import java.awt.Color;


/**
 * Esta clase es la claseBase de toda celda.
 */
public abstract class CellView extends Paintable {

    private Integer indexX;
    private Integer indexY;
    private Color backgroundColor;


    public CellView() {
        super();
    }

    public void setCoordinates(Integer indexX, Integer indexY) {
        this.indexX = indexX;
        this.indexY = indexY;
    }

    public void setBaseBackground(Color color) {
        setBackground(color);
        backgroundColor = color;
    }

    public Integer getXIndex() {
        return this.indexX;
    }

    public Integer getYIndex() {
        return this.indexY;
    }

    public void clearFocus() {
        this.setBackground(backgroundColor);
    }

}
