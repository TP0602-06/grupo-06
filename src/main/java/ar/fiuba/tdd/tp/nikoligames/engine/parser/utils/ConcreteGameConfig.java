package ar.fiuba.tdd.tp.nikoligames.engine.parser.utils;


import java.util.HashSet;
import java.util.List;

public class ConcreteGameConfig implements GameConfig {

    private String name;
    private List<NodeConfig> nodes;
    private List<RuleConfig> rules;
    private HashSet<String> inputs;

    private SizeConfig sizeConfig;

    public ConcreteGameConfig(String name, SizeConfig sizeConfig, HashSet<String> validInputs,List<RuleConfig> rules,List<NodeConfig> node) {
        this.sizeConfig = sizeConfig;
        this.name = name;
        this.rules = rules;
        this.inputs = validInputs;
        this.nodes = node;
    }

    public List<NodeConfig> getInitialCells() {
        return this.nodes;
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
