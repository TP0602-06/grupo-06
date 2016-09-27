package ar.fiuba.tdd.tp.nikoligames.engine.model.board;

/**
 * Created by Andres on 24/09/2016.
 */
public class Position {

    private int valueX;
    private int valuey;

    public Position(int valueX, int valuey) {
        this.valueX = valueX;
        this.valuey = valuey;
    }

    public int getX() {
        return valueX;
    }

    public int getY() {
        return valuey;
    }

}
