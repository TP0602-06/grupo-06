package ar.fiuba.tdd.tp.nikoligames.view.view;
import java.awt.*;

import javax.swing.*;


/**
 * Created by tobias on 24/09/16.
 */
public class View extends JFrame {

    public View(String title, Integer sizeX, Integer sizeY) {
        super(title);
        setSize(sizeX, sizeY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());
    }

}
