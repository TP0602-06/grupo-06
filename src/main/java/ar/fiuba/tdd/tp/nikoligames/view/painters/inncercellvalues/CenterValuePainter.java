package ar.fiuba.tdd.tp.nikoligames.view.painters.inncercellvalues;

import java.awt.*;
import javax.swing.*;


/**
 * Esta clase se encarga de centrar el valor en la celda.
 */
public class CenterValuePainter extends CellPainterWithValue {

    public CenterValuePainter(String value) {
        super(value, JLabel.CENTER);
        setAnchor(GridBagConstraints.CENTER);
        setIpadx(1);
        setIpady(1);
    }
}
