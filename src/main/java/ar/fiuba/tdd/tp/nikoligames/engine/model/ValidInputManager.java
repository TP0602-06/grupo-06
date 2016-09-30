package ar.fiuba.tdd.tp.nikoligames.engine.model;

import java.util.HashSet;
import java.util.List;


public class ValidInputManager {
    private HashSet<String> validInputs;

    public ValidInputManager(HashSet<String> validInputs) {
        this.validInputs = validInputs;
    }

    public HashSet<String> getValidInputs() {
        return validInputs;
    }

    public boolean isValidInput(String input){
        return validInputs.contains(input);
    }
}
