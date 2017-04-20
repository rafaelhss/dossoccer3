package dossoccer.gameengine.play.events.commands;

import dossoccer.gameengine.play.actions.Action;
import dossoccer.gameengine.play.events.Event;

/**
 * Created by rafael on 16/04/17.
 */
public class Command extends Event {
    private Action action;

    public Command (Action action){
        this.action = action;
    }

    public Action getAction() {
        return action;
    }
}
