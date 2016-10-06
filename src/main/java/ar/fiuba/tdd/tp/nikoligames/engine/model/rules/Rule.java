package ar.fiuba.tdd.tp.nikoligames.engine.model.rules;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.cell.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;

import java.util.ArrayList;

public abstract class Rule {

    protected ArrayList<AbstractCell> listOfCells;

    public abstract String getValue();

    public abstract  boolean isBroken();
}
