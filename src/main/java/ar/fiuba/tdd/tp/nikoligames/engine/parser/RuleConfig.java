package ar.fiuba.tdd.tp.nikoligames.engine.parser;

import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;

import java.util.ArrayList;

/**
 * Created by Andres on 06/10/2016.
 */
public class RuleConfig {
    private String ruleType;
    private String value;
    private ArrayList<Position> positions;

    public RuleConfig(String ruleType) {
        this.ruleType = ruleType;
        this.positions = new ArrayList<Position>();
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public String getRuleType() {
        return ruleType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void addPosition(Position position) {
        positions.add(position);
    }


}
