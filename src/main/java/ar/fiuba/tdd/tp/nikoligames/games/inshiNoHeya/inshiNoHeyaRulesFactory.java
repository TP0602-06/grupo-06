package ar.fiuba.tdd.tp.nikoligames.games.inshiNoHeya;

import ar.fiuba.tdd.tp.nikoligames.engine.model.board.AbstractCell;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.engine.model.board.Position;
import ar.fiuba.tdd.tp.nikoligames.engine.model.factory.GroupRulesFactory;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.Rule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.impl.AdditionRule;
import ar.fiuba.tdd.tp.nikoligames.engine.model.rules.impl.NoDuplicatesRule;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by fedebrasburg on 9/29/16.
 */
public class inshiNoHeyaRulesFactory {

    private Board board;

    inshiNoHeyaRulesFactory(Board board) {
        this.board = board;
    }

    public ArrayList<Rule> getRules() {
        ArrayList<Rule> rules = new ArrayList<>();



        GroupRulesFactory factory = new GroupRulesFactory();
        factory.addColumnsRules(rules,this.board);
        factory.addRowsRules(rules,this.board);
        return rules;
    }




}
