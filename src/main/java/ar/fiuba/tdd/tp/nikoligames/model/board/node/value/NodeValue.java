package ar.fiuba.tdd.tp.nikoligames.model.board.node.value;

import utils.StringToIntConverter;

/**
 * Responsabilidades: Implementa la abstracción para el valor de un nodo.
 * Es responsable de que el valor de nodo este siempre en un estado válido.
 */
public class NodeValue implements AbstractNodeValue {

    private static final String DEFAUL_EMPTY_VALUE = "";
    private static final int DEFAUL_EMPTY_INT_VALUE = 0;

    private String value;


    public NodeValue() {
        setValue(DEFAUL_EMPTY_VALUE);
    }

    public NodeValue(String initValue) {
        setValue(initValue);
    }

    public int getIntValue() {
        return StringToIntConverter.parseWithDefault(value, DEFAUL_EMPTY_INT_VALUE);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return (value.equals(DEFAUL_EMPTY_VALUE));
    }


}