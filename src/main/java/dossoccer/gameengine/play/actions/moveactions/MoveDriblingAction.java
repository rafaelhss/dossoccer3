package dossoccer.gameengine.play.actions.moveactions;

import dossoccer.gameengine.gameactor.Actor;

/**
 * Created by rafael on 16/04/17.
 */

//Necessary to move from a square not dominated by the dribler
public class MoveDriblingAction extends MoveAction {
    public MoveDriblingAction(Actor actor) {
        super(actor);
    }
}
