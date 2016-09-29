package ar.fiuba.tdd.tp.nikoligames.games;

/**
 * Tiene lo caracteres especiales y no esten hardcodeados.
 */
public enum MappedValues {

    INPUT_EDITABLE("?"),

    GREY_CELL("*\\*"),

    EMPTY_CELL("");

    private String value;

    MappedValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
