package ar.fiuba.tdd.tp.nikoligames.parser.utils;


import ar.fiuba.tdd.tp.nikoligames.view.config.ViewConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcreteGameConfig implements GameConfig {

    private String name;
    private List<NodeConfig> nodes;
    private List<RuleConfig> rules;
    private Set<String> inputs;
    private ViewConfig viewConfig;

    private SizeConfig sizeConfig;

    public ConcreteGameConfig(String name,SizeConfig sizeConfig,HashSet<String> validInputs,
                              List<RuleConfig> rules, List<NodeConfig> node, ViewConfig viewConfig) {
        this.sizeConfig = sizeConfig;
        this.name = name;
        this.rules = rules;
        this.inputs = validInputs;
        this.nodes = node;
        this.viewConfig = viewConfig;
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

    public Set<String> getValidInputs() {
        return inputs;
    }

    public SizeConfig getSizeConfig() {
        return sizeConfig;
    }

    public ViewConfig getViewConfig() {
        return viewConfig;
    }

}
