package ar.fiuba.tdd.tp.nikoligames.view.regionpainter.bordersavers;

import ar.fiuba.tdd.tp.nikoligames.view.regionpainter.bordersavers.fixedkeys.FixedColum;
import ar.fiuba.tdd.tp.nikoligames.view.regionpainter.bordersavers.valuecomparer.LowerValueComparer;

/**
 * Created by tobias on 19/10/16.
 */
public class ColumnAndRowMin extends BorderSaver {
    public ColumnAndRowMin() {
        super(new FixedColum(), new LowerValueComparer());
    }
}
