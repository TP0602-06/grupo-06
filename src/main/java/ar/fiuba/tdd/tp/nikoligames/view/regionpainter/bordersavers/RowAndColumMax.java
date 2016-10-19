package ar.fiuba.tdd.tp.nikoligames.view.regionpainter.bordersavers;

import ar.fiuba.tdd.tp.nikoligames.view.regionpainter.bordersavers.fixedkeys.FixedRow;
import ar.fiuba.tdd.tp.nikoligames.view.regionpainter.bordersavers.valuecomparer.GreaterValueComparer;

/**
 * Created by tobias on 19/10/16.
 */
public class RowAndColumMax extends BorderSaver {
    public RowAndColumMax() {
        super(new FixedRow(), new GreaterValueComparer());
    }
}
