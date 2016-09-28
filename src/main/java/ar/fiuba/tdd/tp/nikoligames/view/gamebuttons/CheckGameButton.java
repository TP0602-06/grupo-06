package ar.fiuba.tdd.tp.nikoligames.view.gamebuttons;

import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.BasicButtonListener;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.AbstractSelectValueController;

import javax.swing.*;

/**
 * Created by tobias on 27/09/16.
 */
public class CheckGameButton extends JButton implements ButtonCommand {

    public CheckGameButton() {
        setText("End Game and Check");
        addMouseListener(new BasicButtonListener());
    }

    public void execute() {
        //TODO check model rules
        //TODO if did not break rules
        setBackground(ColorSet.ERROR);
    }
}
