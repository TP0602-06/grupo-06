package ar.fiuba.tdd.tp.nikoligames.view.regionpainter.bordersavers;

import ar.fiuba.tdd.tp.nikoligames.view.regionpainter.bordersavers.fixedkeys.FixedColum;
import ar.fiuba.tdd.tp.nikoligames.view.regionpainter.bordersavers.valuecomparer.GreaterValueComparer;

/**
 * Created by tobias on 19/10/16.
 */
public class ColumnAndRowMax extends BorderSaver {

    public ColumnAndRowMax() {
        super(new FixedColum(), new GreaterValueComparer());
    }
}
