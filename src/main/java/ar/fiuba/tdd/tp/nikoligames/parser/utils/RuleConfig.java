package ar.fiuba.tdd.tp.nikoligames.parser.utils;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.ClassicPosition;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.NotValidRuleException;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.RuleType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by german on 10/6/2016.
 */
public class RuleConfig {

    private List<Position> regionPositions = new ArrayList();
    private List<List<Position>> regionListPositions = new ArrayList();

    private List<Position> adjacentPosition = new ArrayList();
    private RuleType ruleDefinition;
    private String value = "";
    private Set<String> validInputs = new HashSet();

    public RuleConfig(String ruleDefinition) throws Exception {
        this.setRuleDefinition(ruleDefinition);
    }


    public Set<String> getValidInputs() {
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
