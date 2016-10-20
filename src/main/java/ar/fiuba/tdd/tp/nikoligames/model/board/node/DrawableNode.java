package ar.fiuba.tdd.tp.nikoligames.model.board.node;

/**
 * Responsibilities:
 * 1.Is the interface of the node that can be seen by the View
 */
public interface DrawableNode {

    boolean isEmpty();

    boolean isEditable();

    String getValue();

}
