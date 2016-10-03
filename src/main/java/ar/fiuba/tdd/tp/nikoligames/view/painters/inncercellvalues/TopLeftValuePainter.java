package ar.fiuba.tdd.tp.nikoligames.view.painters.inncercellvalues;

import java.awt.*;
import javax.swing.JLabel;

/**
 * Agrega la pista a la esquina superior izquierda.
 */
public class TopLeftValuePainter extends CellPainterWithValue {

    public TopLeftValuePainter(String value) {
        super(value, JLabel.LEFT);
        setAnchor(GridBagConstraints.NORTHWEST);
        setIpadx(0);
        setIpady(0);
    }
}
