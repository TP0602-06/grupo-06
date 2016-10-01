package ar.fiuba.tdd.tp.nikoligames.engine.model.position;

/**
 * Da al modelo una forma de representar una posicion sin tener que repetir siempre (x,y).
 * Actualmente no tiene comportamiento, pero aca iria cualquier calculo entre posiciones.
 * Nos es comodo para abstraernos de una (x,y) concreta.
 */
public interface Position {
    int getRow();

    int getColumn();
}
