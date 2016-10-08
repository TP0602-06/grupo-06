package ar.fiuba.tdd.tp.nikoligames.parser.utils;

import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 10/6/2016.
 */
public class RuleConfig {

    private List<Position> regionPositions = new ArrayList<Position>();
    private List<Position> adjacentPosition = new ArrayList<Position>();
    private String ruleDefinition;
    private String value = "";

    public RuleConfig(String ruleDefinition) throws Exception {
        this.setRuleDefinition(ruleDefinition);
    }

    public String getRuleDefinition() {
        return ruleDefinition;
    }

    public void setRuleDefinition(String ruleDefinition) throws Exception {
        this.ruleDefinition = ruleDefinition;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void addCellToRegion(int row, int col) {
        this.regionPositions.add(new ClassicPosition(row, col));
    }

    public void addCellToAdjacentRegion(int row, int col) {
        this.adjacentPosition.add(new ClassicPosition(row, col));
    }

    public List<Position> getRegionPositions() {
        return regionPositions;
    }


    public List<Position> getAdjacentPosition() {
        return adjacentPosition;
    }

    public void setAdjacentPosition(List<Position> adjacentPosition) {
        this.adjacentPosition = adjacentPosition;
    }
}
