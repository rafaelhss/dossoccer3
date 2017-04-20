package dossoccer.gameengine.gameactor;

import dossoccer.gameengine.play.actions.Action;
import dossoccer.gameengine.play.events.Event;
import dossoccer.gameengine.state.Field;

/**
 * Created by rafael on 15/04/17.
 */
public interface Actor {
    public Action onEvent(Field field, Event event);
}
