package tdd.engine.model;


import java.util.ArrayList;

public abstract class Rule {


    //voy a usar TemplateMethod

    protected ArrayList<EditableCell> cells;

    Rule() {
        cells = new ArrayList<EditableCell>();
    }

    public void addCell(EditableCell cell) {
        cells.add(cell);
    }

    public abstract boolean isBrocken();
}
