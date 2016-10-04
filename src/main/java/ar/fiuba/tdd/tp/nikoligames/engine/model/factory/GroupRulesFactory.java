package ar.fiuba.tdd.tp.nikoligames.engine.model.factory;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.*;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.impl.NoDuplicatesRule;

import java.util.ArrayList;

/**
 * Created by fedebrasburg on 9/29/16.
 */
public class GroupRulesFactory {

    public void addColumnsRules(ArrayList<Rule> rules, Board board) {
        for (int boardColumn = 0; boardColumn < board.getCols(); boardColumn++) {
            ArrayList<AbstractCell> cells = this.getColumnCells(boardColumn,board);
            addNewRule(rules,cells);
        }
    }

    public  void addRowsRules(ArrayList<Rule> rules,Board board) {
        for (int boardRow = 0; boardRow < board.getRows(); boardRow++) {
            ArrayList<AbstractCell> cells = this.getRowCells(boardRow,board);
            addNewRule(rules,cells);
        }
    }

    private void addNewRule(ArrayList<Rule> rules, ArrayList<AbstractCell> cells){
        NoDuplicatesRule rule = new NoDuplicatesRule(cells);
        rules.add(rule);
    }

    private ArrayList<AbstractCell> getColumnCells(int boardColumn, Board board) {
        ArrayList<Position> positions = this.getColumnPositions(boardColumn,board);
        return board.getArrayOfCells(positions);
    }

    private ArrayList<AbstractCell> getRowCells(int boardRow, Board board) {
        ArrayList<Position> positions = this.getRowPositions(boardRow,board);
        return board.getArrayOfCells(positions);
    }

    private ArrayList<Position> getColumnPositions(int boardColumn, Board board) {
        ArrayList<Position> positions = new ArrayList<>();
        for (int boardRow = 0; boardRow < board.getRows(); boardRow++) {
            positions.add(new Position(boardColumn, boardRow));
        }
        return positions;
    }

    private ArrayList<Position> getRowPositions(int boardRow, Board board) {
        ArrayList<Position> positions = new ArrayList<>();
        for (int boardColumn = 0; boardColumn < board.getCols(); boardColumn++) {
            positions.add(new Position(boardColumn, boardRow));
        }
        return positions;
    }
}
