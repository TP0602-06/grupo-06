package ar.fiuba.tdd.tp.nikoligames.view.painters.inncercellvalues;

import java.awt.*;
import javax.swing.JLabel;

/**
 * Agrega la pista a la esquina superior izquierda.
 */
public class TopLeftValuePainter extends CellPainterWithValue {

    public TopLeftValuePainter(String value) {
        super(value, JLabel.LEFT);
    }

    @Override
    public Integer getAnchor() {
        return GridBagConstraints.NORTHWEST;
    }

    @Override
    public Integer getIpadx() {
        return 0;
    }

    @Override
    public Integer getIpady() {
        return 0;
    }
}
