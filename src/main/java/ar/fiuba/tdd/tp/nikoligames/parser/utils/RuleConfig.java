package ar.fiuba.tdd.tp.nikoligames.parser.utils;

import ar.fiuba.tdd.tp.nikoligames.engine.model.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.NotValidRuleException;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleType;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by german on 10/6/2016.
 */
public class RuleConfig {

    private List<Position> regionPositions = new ArrayList<Position>();



    private List<List<Position>> regionListPositions = new ArrayList<List<Position>>();

    private List<Position> adjacentPosition = new ArrayList<Position>();
    private RuleType ruleDefinition;
    private String value = "";
    private HashSet<String> validInputs = new HashSet<String>();

    public RuleConfig(String ruleDefinition) throws Exception {
        this.setRuleDefinition(ruleDefinition);
    }



    public HashSet<String> getValidInputs() {
        return validInputs;
    }

    public void setValidInputs(HashSet<String> validInputs) {
        this.validInputs = validInputs;
    }

    public RuleType getRuleDefinition() {
        return ruleDefinition;
    }

    public void setRuleDefinition(String ruleDefinition) throws NotValidRuleException {
        this.ruleDefinition = RuleType.getRuleType(ruleDefinition);
    }

    public void setValidInput(String string) {
        validInputs.add(string);
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

    public void addRegionToRegionListPosition(List<Position> regionPositions) {
        this.regionListPositions.add(regionPositions);
    }

    public List<List<Position>> getRegionListPositions() {
        return regionListPositions;
    }

    public List<Position> getRegionPositions() {
        return regionPositions;
    }


    public List<Position> getAdjacentPositions() {
        return adjacentPosition;
    }

}
