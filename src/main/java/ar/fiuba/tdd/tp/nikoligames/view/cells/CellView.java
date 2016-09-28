package ar.fiuba.tdd.tp.nikoligames.view.cells;

import javax.swing.*;

/**
 * Esta clase es la claseBase de toda celda.
 */
public abstract class CellView extends JButton {
    private Integer indexX;
    private Integer indexY;

    public void setCoordinates(Integer indexX, Integer indexY) {
        this.indexX = indexX;
        this.indexY = indexY;
    }

    public Integer getXIndex() {
        return this.indexX;
    }

    public Integer getYIndex() {
        return this.indexY;
    }

    public abstract void clearFocus();

}
