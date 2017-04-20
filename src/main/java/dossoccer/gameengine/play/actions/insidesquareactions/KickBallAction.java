package dossoccer.gameengine.play.actions.insidesquareactions;

import dossoccer.gameengine.gameactor.Actor;
import dossoccer.gameengine.play.actions.Action;
import dossoccer.gameengine.state.Field;
import dossoccer.gameengine.state.FieldSquare;

/**
 * Created by rafael on 16/04/17.
 */
public class KickBallAction extends Action {

    private int MAX_X = 2;
    private int MAX_Y = 2;

    private FieldSquare target;

    public KickBallAction(Actor actor, FieldSquare target) {
        super(actor);
        this.target = target;
    }

    public FieldSquare getTarget() {
        return target;
    }

    @Override
    public Field run(Field currentField) {
        //se quem chutou nao esta com a bola, nada acontece
        if(currentField.getBall().getController() == this.getActor()){

            int xDistance = currentField.getBall().getPosition().calculateXDistance(target);
            int yDistance = currentField.getBall().getPosition().calculateYDistance(target);

            if(xDistance > MAX_X){
                xDistance = MAX_X;
            }
            if(yDistance > MAX_Y){
                yDistance = MAX_Y;
            }

            FieldSquare newFieldSquare = currentField.getBall().getPosition().getRelativeSquare(xDistance, yDistance);

            if(newFieldSquare == null){ //chutou pra fora
                currentField.getBall().setOnPlay(false);
            }
            //TODO se newField for gol, verificar se o goleiro catou
            else {
                currentField.getBall().setPosition(currentField.getSquare(newFieldSquare));
            }
        }

        return currentField;
    }
}
