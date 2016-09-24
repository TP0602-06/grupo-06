package tdd.engine.model;


import java.util.ArrayList;

public abstract class Rule {


    //voy a usar TemplateMethod

    protected ArrayList<Cell> cells;

    Rule() {
        cells = new ArrayList<Cell>();
    }

    public void addCell(Cell cell) {
        cells.add(cell);
    }

    public abstract boolean isBrocken();
}
