package ar.fiuba.tdd.tp.nikoligames.view.painters.inncercellvalues;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;

/**
 * Esta clase pinta la pista en la esquina inferior izquierda.
 */
public class BottomLeftValuePainter extends CellPainterWithValue {

    public BottomLeftValuePainter(String value) {
        super(value, JLabel.LEFT);
    }

    @Override
    public Integer getAnchor() {
        return GridBagConstraints.SOUTHWEST;
    }

    @Override
    public Integer getIpadx() {
        return 0;
    }

    @Override
    public Integer getIpady() {
        return 2;
    }
}
