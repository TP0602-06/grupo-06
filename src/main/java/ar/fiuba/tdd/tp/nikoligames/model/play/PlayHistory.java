package ar.fiuba.tdd.tp.nikoligames.model.play;

import ar.fiuba.tdd.tp.nikoligames.model.board.Board;
import ar.fiuba.tdd.tp.nikoligames.model.board.EdgeAlreadyExistsExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.EdgeNotExistsExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.node.NotEditableExpection;
import ar.fiuba.tdd.tp.nikoligames.model.board.position.Position;
import ar.fiuba.tdd.tp.nikoligames.model.game.Game;
import ar.fiuba.tdd.tp.nikoligames.model.play.implemented.*;

import java.util.Stack;

/**
 * Responsabilidades: manejar la creacion y la posterior UNDO de las jugadas en el juego.
 * Patron: Mediador.
 */
public class PlayHistory implements AbstractPlayHistory {
    private final Game game;
    private Stack<UndoablePlay> playsMadeStack = new Stack<UndoablePlay>();
    private int nextPlayNumber = 1;

    public PlayHistory(Game game, Board board) {
        this.game = game;
    }

    private void addPlay(AbstractPlay play) throws EdgeNotExistsExpection, NotEditableExpection, EdgeAlreadyExistsExpection {
        play.process();
        playsMadeStack.push(play);
        nextPlayNumber++;
    }

    @SuppressWarnings("CPD-START")
    public void changeNodeValue(String newValue, Position position) throws NotEditableExpection {
        AbstractPlay play = new ChangeNodeValuePlay(game, nextPlayNumber, newValue, position);
        try {
            this.addPlay(play);
        } catch (EdgeNotExistsExpection edgeNotExistsExpection) {
            edgeNotExistsExpection.printStackTrace();
        } catch (EdgeAlreadyExistsExpection edgeAlreadyExistsExpection) {
            edgeAlreadyExistsExpection.printStackTrace();
        }
    }

    public void createDirectedEdge(Position position1, Position position2) throws EdgeAlreadyExistsExpection {
        AbstractPlay play = new CreateDirectedEdgePlay(game, nextPlayNumber, position1, position2);
        try {
            this.addPlay(play);
        } catch (EdgeNotExistsExpection edgeNotExistsExpection) {
            edgeNotExistsExpection.printStackTrace();
        } catch (NotEditableExpection notEditableExpection) {
            notEditableExpection.printStackTrace();
        }
    }

    public void removeDirectedEdge(Position position1, Position position2) throws EdgeNotExistsExpection {
        AbstractPlay play = new RemoveDirectedEdgePlay(game, nextPlayNumber, position1, position2);
        try {
            this.addPlay(play);
        } catch (NotEditableExpection notEditableExpection) {
            notEditableExpection.printStackTrace();
        } catch (EdgeAlreadyExistsExpection edgeAlreadyExistsExpection) {
            edgeAlreadyExistsExpection.printStackTrace();
        }
    }

    public void createUndirectedEdge(Position position1, Position position2) throws EdgeAlreadyExistsExpection {
        AbstractPlay play = new CreateUndirectedEdgePlay(game, nextPlayNumber, position1, position2);
        try {
            this.addPlay(play);
        } catch (EdgeNotExistsExpection edgeNotExistsExpection) {
            edgeNotExistsExpection.printStackTrace();
        } catch (NotEditableExpection notEditableExpection) {
            notEditableExpection.printStackTrace();
        }
    }

    public void removeUndirectedEdge(Position position1, Position position2) throws EdgeNotExistsExpection {
        AbstractPlay play = new RemoveUndirectedEdgePlay(game, nextPlayNumber, position1, position2);
        try {
            this.addPlay(play);
        } catch (NotEditableExpection notEditableExpection) {
            notEditableExpection.printStackTrace();
        } catch (EdgeAlreadyExistsExpection edgeAlreadyExistsExpection) {
            edgeAlreadyExistsExpection.printStackTrace();
        }
    }

    public void undo() {
        UndoablePlay play = playsMadeStack.pop();
        play.undo();
    }
}
