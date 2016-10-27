package ar.fiuba.tdd.tp.nikoligames.model.play;

import ar.fiuba.tdd.tp.nikoligames.model.board.EdgeAlreadyExistsExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.EdgeNotExistsExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.NotEditableExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.play.implemented.DrawablePlay;

/**
 * Created by german on 10/27/2016.
 */
public interface AbstractPlayHistory {
    @SuppressWarnings("CPD-START")
    void changeNodeValue(String newValue, Position position) throws NotEditableExpection;

    void createDirectedEdge(Position position1, Position position2) throws EdgeAlreadyExistsExpection;

    void removeDirectedEdge(Position position1, Position position2) throws EdgeNotExistsExpection;

    void createUndirectedEdge(Position position1, Position position2) throws EdgeAlreadyExistsExpection;

    void removeUndirectedEdge(Position position1, Position position2) throws EdgeNotExistsExpection;

    DrawablePlay undo() throws NoPlaysException;
}
