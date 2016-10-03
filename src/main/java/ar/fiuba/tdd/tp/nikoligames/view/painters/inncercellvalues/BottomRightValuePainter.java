package ar.fiuba.tdd.tp.nikoligames.view.painters.inncercellvalues;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;

/**
 * Esta clase agrega un valor en la esquina inferior derecha.
 */
public class BottomRightValuePainter extends CellPainterWithValue {

    public BottomRightValuePainter(String value) {
        super(value, JLabel.RIGHT);
        setAnchor(GridBagConstraints.SOUTHEAST);
        setIpadx(2);
        setIpady(2);
    }
}
