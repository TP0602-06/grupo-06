package ar.fiuba.tdd.tp.nikoligames.engine.model.board.node.value;

/**
 * Responsabilidades: da flexibilidad para extender lo que se puede guardar como valor del nodo.
 * Es responsable de que el valor de nodo este siempre en un estado válido.
 */
public interface AbstractNodeValue {
    int getIntValue();

    String getValue();

    void setValue(String value);

    boolean isEmpty();
}
