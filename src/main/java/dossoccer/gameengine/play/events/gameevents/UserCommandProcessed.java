package dossoccer.gameengine.play.events.gameevents;

import dossoccer.gameengine.play.events.Event;

import java.util.List;

/**
 * Created by rafael on 18/04/17.
 */
public class UserCommandProcessed extends Event {
    private List<Event> commands;

    public UserCommandProcessed(List<Event> commands) {
        super();
        this.setCommands(commands);
    }


    public List<Event> getCommands() {
        return commands;
    }

    public void setCommands(List<Event> commands) {
        this.commands = commands;
    }
}
