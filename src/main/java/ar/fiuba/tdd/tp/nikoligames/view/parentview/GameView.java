package ar.fiuba.tdd.tp.nikoligames.view.parentview;

import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import java.awt.*;

import javax.swing.*;


/**
 * Created by tobias on 24/09/16.
 */
public class GameView extends JFrame {

    public GameView(String title, Integer sizeX, Integer sizeY) {
        super(title);
        setSize(sizeX, sizeY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());
    }




}