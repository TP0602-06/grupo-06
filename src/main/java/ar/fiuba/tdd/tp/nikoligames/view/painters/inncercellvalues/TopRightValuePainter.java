package ar.fiuba.tdd.tp.nikoligames.view.painters.inncercellvalues;

import java.awt.*;
import javax.swing.JLabel;

/**
 * Agrega la pista a la esquina superior derecha.
 */
public class TopRightValuePainter extends CellPainterWithValue {

    public TopRightValuePainter(String value) {
        super(value, JLabel.RIGHT);
        setAnchor(GridBagConstraints.NORTHEAST);
        setIpadx(2);
        setIpady(0);
    }
}
