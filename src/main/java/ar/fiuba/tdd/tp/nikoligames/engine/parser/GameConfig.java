package ar.fiuba.tdd.tp.nikoligames.engine.parser;


import ar.fiuba.tdd.tp.nikoligames.engine.parser.regionrule.AbstractRegionRule;
import ar.fiuba.tdd.tp.nikoligames.engine.parser.regionrule.Clue;
import org.json.simple.JSONArray;

import java.util.List;

/**
 * Created by mcapolupo on 20/9/16.
 * It is a kind of Board DTO, totally agnostic to model.
 */
public class GameConfig {
    private List<AbstractRegionRule> rules;
    private List<Clue> clues;

    private String name;
    private SizeConfig sizeConfig;

    public GameConfig(List<AbstractRegionRule> rules, List<Clue> clues, String name, SizeConfig sizeConfig) {
        this.rules = rules;
        this.clues = clues;
        this.name = name;
        this.sizeConfig = sizeConfig;
    }

    public List<AbstractRegionRule> getRules() {
        return rules;
    }

    public List<Clue> getClues() {
        return clues;
    }

    public String getName() {
        return name;
    }

    public SizeConfig getSizeConfig() {
        return sizeConfig;
    }

}
