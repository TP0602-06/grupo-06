package ar.fiuba.tdd.tp.nikoligames.engine.parser.regionrule;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Position;

import java.util.ArrayList;

public class RegionRuleNumber implements AbstractRegionRule {

    private ArrayList<Position> region;
    private String ruleDefinition;
    private String number;

    public RegionRuleNumber(ArrayList<Position>  region, String number, String ruleDefinition){
        this.number = number;
        this.region = region;
        this.ruleDefinition = ruleDefinition;
    }

    public void addCellToRegion(int row, int col){
        Position pos = new Position(row,col);
        this.region.add(pos);
    }

    public String getRuleDefinition() {
        return this.ruleDefinition;
    }

    public ArrayList<Position> getRegion(){
        return region;
    }

    public String getNumber(){
        return number;
    }
}
