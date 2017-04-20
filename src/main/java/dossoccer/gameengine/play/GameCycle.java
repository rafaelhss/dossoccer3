package dossoccer.gameengine.play;

import dossoccer.gameengine.play.events.Event;
import dossoccer.gameengine.state.Field;

import java.util.List;

/**
 * Created by rafael on 15/04/17.
 */
public class GameCycle {
    private Field field;
    private List<Event> eventList;

    public GameCycle(Field field, List<Event> eventList){
        this.field = field;
        this.eventList = eventList;
    }





    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
