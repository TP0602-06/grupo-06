package ar.fiuba.tdd.tp.nikoligames.view.parentview;

import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import java.awt.*;

import javax.swing.*;


/**
 * Esta clase define la ventana del juego.
 */
public class GameView extends JFrame {

    public GameView(String title, Integer sizeX, Integer sizeY) {
        super(title);
        setSize(sizeX, sizeY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());
    }




}
