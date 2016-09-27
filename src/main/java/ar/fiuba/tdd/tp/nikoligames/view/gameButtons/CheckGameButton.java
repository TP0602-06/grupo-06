package ar.fiuba.tdd.tp.nikoligames.view.gameButtons;

import javax.swing.*;

/**
 * Created by tobias on 27/09/16.
 */
public class CheckGameButton extends JButton implements ButtonCommand {
    public CheckGameButton(){
        setText("End Game and Check");
    }

    public void execute(){
        //TODO check model rules
    }
}
