package ar.fiuba.tdd.tp.nikoligames.engine.model.inputmanager;

import java.util.HashSet;


public class ValidInputManager {
    public static final String CLEAR = "";
    private HashSet<String> validInputs;

    public ValidInputManager(HashSet<String> validInputs) {
        this.validInputs = validInputs;
    }

    public HashSet<String> getValidInputs() {
        return validInputs;
    }

    public boolean isValidInput(String input) {
        return (validInputs.contains(input) || input.equals(CLEAR));
    }
}
