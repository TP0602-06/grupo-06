package ar.fiuba.tdd.tp.nikoligames.engine.parser.utils;


import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;

import java.util.HashSet;
import java.util.List;

public class ConcreteGameConfig implements GameConfig {

    private String name;
    private List<NodeConfig> cells;
    private List<RuleConfig> rules;
    private HashSet<String> inputs;

    private SizeConfig sizeConfig;

    public ConcreteGameConfig(String name, SizeConfig sizeConfig, HashSet<String> validInputs, List<RuleConfig> rules, List<NodeConfig> cells) {
        this.sizeConfig = sizeConfig;
        this.name = name;
        this.rules = rules;
        this.inputs = validInputs;
        this.cells = cells;
    }

    public List<NodeConfig> getInitialCells() {
        return this.cells;
    }

    public String getName() {
        return name;
    }

    public List<RuleConfig> getRules() {
        return rules;
    }

    public HashSet<String> getValidInputs() {
        return inputs;
    }

    public SizeConfig getSizeConfig() {
        return sizeConfig;
    }

}
