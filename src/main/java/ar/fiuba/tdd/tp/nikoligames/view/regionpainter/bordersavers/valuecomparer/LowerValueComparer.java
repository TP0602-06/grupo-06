package ar.fiuba.tdd.tp.nikoligames.view.regionpainter.bordersavers.valuecomparer;

/**
 * Created by tobias on 19/10/16.
 */
public class LowerValueComparer extends ValueComparer {
    @Override
    public boolean isValid(Integer actual, Integer previous) {
        return actual < previous;
    }
}
