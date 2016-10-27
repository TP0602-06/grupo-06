package ar.fiuba.tdd.tp.nikoligames.model.board.node;

/**
 * Responsibilities:
 * 1. Gives flexibility to extent what it can be saved as a value on a node and it is responsable to give the value a valid state.
 */
public interface AbstractNodeValue {
    int getIntValue();

    String getValue();

    void setValue(String value);

    void clearValue();

    boolean isEmpty();
}
