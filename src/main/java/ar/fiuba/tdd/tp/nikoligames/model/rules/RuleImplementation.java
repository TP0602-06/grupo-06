package ar.fiuba.tdd.tp.nikoligames.model.rules;

import ar.fiuba.tdd.tp.nikoligames.model.board.node.AbstractNode;

import java.util.List;

public abstract class RuleImplementation extends Rule {

    protected List<AbstractNode> region;
    protected String value;

    public RuleImplementation(List<AbstractNode> region, String value) {
        this.value = value;
        this.region = region;
    }

    public String getValue() {
        return value;
    }


    public List<AbstractNode> getRegion() {
        return region;
    }
}
