package ar.fiuba.tdd.tp.nikoligames.view.clickables.edge;

import ar.fiuba.tdd.tp.nikoligames.model.board.position.EdgePosition;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.view.ColorSet;
import ar.fiuba.tdd.tp.nikoligames.view.clickables.Paintable;
import ar.fiuba.tdd.tp.nikoligames.view.listeners.EdgeSelectedListener;
import ar.fiuba.tdd.tp.nikoligames.view.viewcontroller.edgecontroller.SelectEdgeController;


/**
 * Created by tobias on 17/10/16.
 */
public abstract class ViewEdge extends Paintable {

    public ViewEdge(SelectEdgeController controller) {
        super();
        addMouseListener(new EdgeSelectedListener(controller));
        setOpaque(false);
        setBorder(null);
        setContentAreaFilled(false);
    }

    public void clicked() {
        toggleClick();
        updateView();
    }

    public abstract void undoClick(Game game);

    protected abstract void toggleClick();

    public abstract EdgePosition getEdgePositions();

    public abstract boolean hasEdgePosition(EdgePosition edgePosition);

    protected abstract void updateView();


}
