package ar.fiuba.tdd.tp.nikoligames;


import ar.fiuba.tdd.tp.nikoligames.view.View;
import ar.fiuba.tdd.tp.nikoligames.view.cells.EditableNumberCell;
import ar.fiuba.tdd.tp.nikoligames.view.cells.InvalidCell;
import ar.fiuba.tdd.tp.nikoligames.view.cells.NumberCellView;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridOfSquares;
import ar.fiuba.tdd.tp.nikoligames.view.grids.GridView;

import javax.swing.*;

/**
 * Created by mcapolupo on 18/9/16.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Nikolio games :D");
        View vista = new View("test", 600, 800);
        GridView grid = new GridOfSquares(7, 10);
        vista.add(grid);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                grid.addCell(new InvalidCell());
            }
        }
        vista.setVisible(true);
    }
}
