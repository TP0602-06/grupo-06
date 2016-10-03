package ar.fiuba.tdd.tp.nikoligames.view.cells;

import java.awt.Color;
import javax.swing.JButton;


/**
 * Esta clase es la claseBase de toda celda.
 */
public abstract class CellView extends JButton {
    private Integer indexX;
    private Integer indexY;
    private Color backgroundColor;

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
