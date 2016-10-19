package ar.fiuba.tdd.tp.nikoligames.view.regionpainter.bordersavers.fixedkeys;

import ar.fiuba.tdd.tp.nikoligames.view.regionpainter.bordersavers.fixedkeys.FixedKey;

/**
 * Created by tobias on 19/10/16.
 */
public class FixedColum extends FixedKey {
    @Override
    public Integer getFirst(Integer first, Integer second) {
        return second;
    }

    @Override
    public Integer getSecond(Integer first, Integer second) {
        return first;
    }
}
