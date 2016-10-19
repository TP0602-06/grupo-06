package ar.fiuba.tdd.tp.nikoligames.view.regionpainter.borderSavers;

/**
 * Created by tobias on 19/10/16.
 */
public class RowAndColumMax extends RowFixedColumnVariableBorder {
    @Override
    protected boolean isNew(Integer column, Integer previousValue) {
        return column > previousValue;
    }
}
