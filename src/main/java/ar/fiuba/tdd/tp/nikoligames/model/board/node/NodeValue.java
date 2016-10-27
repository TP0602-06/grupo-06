package ar.fiuba.tdd.tp.nikoligames.model.board.node;

import utils.Constants;
import utils.StringToIntConverter;

/**
 * Responsabilities:
 * 1.Implements the interface of an abstract node value an has the same resposabilites.
 */
public class NodeValue implements AbstractNodeValue {

    private static final int DEFAUL_EMPTY_INT_VALUE = 0;

    private String value;


    public NodeValue() {
        setValue(Constants.CLEAR_STRING);
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

    @Override
    public void clearValue() {
        this.setValue(Constants.CLEAR_STRING);
    }

    public boolean isEmpty() {
        return (value.equals(Constants.CLEAR_STRING));
    }


}
