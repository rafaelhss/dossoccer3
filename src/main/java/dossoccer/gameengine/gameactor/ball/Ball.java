package dossoccer.gameengine.gameactor.ball;

import dossoccer.gameengine.gameactor.Actor;
import dossoccer.gameengine.gameactor.player.Player;
import dossoccer.gameengine.play.actions.Action;
import dossoccer.gameengine.play.events.Event;
import dossoccer.gameengine.play.events.gameevents.GameStartedEvent;
import dossoccer.gameengine.state.Field;
import dossoccer.gameengine.state.Square;

/**
 * Created by rafael on 15/04/17.
 */
public class Ball  implements Actor{

    private boolean onPlay;
    private Square position;
    private Player controller;


    public Ball(Square position){
        this.position = position;
    }

    public Player getController() {
        return controller;
    }

    public Square getPosition() {
        return position;
    }

    public void setPosition(Square position) {
        this.position = position;
    }

    @Override
    public Action onEvent(Field field, Event event) {

        if(event instanceof GameStartedEvent){
            this.controller = field.getAwayPlayers().stream()
                    .filter(player -> player.getPosition().getFieldSquare() == this.getPosition().getFieldSquare())
                    .findAny()
                    .orElse(null);

            this.controller = field.getHomePlayers().stream()
                    .filter(player -> player.getPosition().getFieldSquare() == this.getPosition().getFieldSquare())
                    .findAny()
                    .orElse(null);
        }

        return null;
    }


    public boolean isOnPlay() {
        return onPlay;
    }

    public void setOnPlay(boolean onPlay) {
        this.onPlay = onPlay;
    }
}
