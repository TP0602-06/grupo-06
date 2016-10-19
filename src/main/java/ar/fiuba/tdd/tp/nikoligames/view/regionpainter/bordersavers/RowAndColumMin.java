package ar.fiuba.tdd.tp.nikoligames.view.regionpainter.bordersavers;

import ar.fiuba.tdd.tp.nikoligames.view.regionpainter.bordersavers.fixedkeys.FixedRow;
import ar.fiuba.tdd.tp.nikoligames.view.regionpainter.bordersavers.valuecomparer.LowerValueComparer;

/**
 * Created by tobias on 19/10/16.
 */
public class RowAndColumMin extends BorderSaver {

    public RowAndColumMin() {
        super(new FixedRow(), new LowerValueComparer());
    }
}
