package dossoccer.gameengine.play.actions;

import dossoccer.gameengine.gameactor.Actor;
import dossoccer.gameengine.state.Field;

/**
 * Created by rafael on 15/04/17.
 */
public abstract class Action {
    private Actor actor;

    public Action(Actor actor){
        this.setActor(actor);
    }

    public abstract Field run(Field currentField);


    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
