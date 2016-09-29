package ar.fiuba.tdd.tp.nikoligames.games;

/**
 * Created by mcapolupo on 28/9/16.
 */
public enum MappedValues {

    INPUT_EDITABLE("?");

    private String value;

    MappedValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
