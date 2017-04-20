package dossoccer.gameengine.play.actions.moveactions;

import dossoccer.gameengine.gameactor.Actor;
import dossoccer.gameengine.play.actions.Action;
import dossoccer.gameengine.state.Field;
import dossoccer.gameengine.state.Square;

/**
 * Created by rafael on 15/04/17.
 */
public class MoveAction extends Action{

    public MoveAction(Actor actor) {
        super(actor);
    }

    @Override
    public Field run(Field currentField) {
        return null;
    }

    private Square origin;
    private Square destination;


    public Square getOrigin() {
        return origin;
    }

    public void setOrigin(Square origin) {
        this.origin = origin;
    }

    public Square getDestination() {
        return destination;
    }

    public void setDestination(Square destination) {
        this.destination = destination;
    }
}
