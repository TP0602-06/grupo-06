package ar.fiuba.tdd.tp.nikoligames.view.gameButtons;

import javax.swing.*;

/**
 * Created by tobias on 27/09/16.
 */
public class RestartGameButton extends JButton implements ButtonCommand {
    public RestartGameButton(){
        setText("Restart");
    }

    public void execute(){
        //TODO restart game from 0;
    }
}
