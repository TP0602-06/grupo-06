package ar.fiuba.tdd.tp.nikoligames.engine.model;

/**
 * Da al modelo una forma de representar una posicion sin tener que repetir siempre (x,y).
 * Actualmente no tiene comportamiento, pero aca iria cualquier calculo entre posiciones.
 * Nos es comodo para abstraernos de una (x,y) concreta.
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
