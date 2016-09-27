package ar.fiuba.tdd.tp.nikoligames.view.grids;

import javax.swing.*;

/**
 * Created by german on 9/25/2016.
 */
public interface AbstractFactoryBoard {
    JPanel createDefaultBoard(Integer rows, Integer cols, GridView selectValuesPanel);

    GridView createDefaultSelectValuesPanel();
}
