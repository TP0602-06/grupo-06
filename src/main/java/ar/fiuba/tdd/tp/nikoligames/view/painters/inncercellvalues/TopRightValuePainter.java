package ar.fiuba.tdd.tp.nikoligames.view.painters.inncercellvalues;

import java.awt.*;
import javax.swing.JLabel;

/**
 * Agrega la pista a la esquina superior derecha.
 */
public class TopRightValuePainter extends CellPainterWithValue {

    public TopRightValuePainter(String value) {
        super(value, JLabel.RIGHT);
    }

    @Override
    public Integer getAnchor() {
        return GridBagConstraints.NORTHEAST;
    }

    @Override
    public Integer getIpadx() {
        return 2;
    }

    @Override
    public Integer getIpady() {
        return 0;
    }
}
