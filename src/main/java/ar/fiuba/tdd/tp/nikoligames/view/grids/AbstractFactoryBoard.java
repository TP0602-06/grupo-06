package ar.fiuba.tdd.tp.nikoligames.view.grids;

import ar.fiuba.tdd.tp.nikoligames.view.parentView.View;

import javax.swing.*;

/**
 * Created by german on 9/25/2016.
 */
public interface AbstractFactoryBoard {
    void createDefaultBoard(Integer rows, Integer cols, View view);
}
