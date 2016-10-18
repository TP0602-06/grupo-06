package ar.fiuba.tdd.tp.nikoligames.view.painters.inncercellvalues;

import javax.swing.*;
import java.awt.*;

/**
 * Created by fedebrasburg on 10/17/16.
 */
public class CenterValuePainter extends CellPainterWithValue{

    public CenterValuePainter(String value) {
        super(value, JLabel.CENTER);
        setAnchor(GridBagConstraints.CENTER);
    }
}
