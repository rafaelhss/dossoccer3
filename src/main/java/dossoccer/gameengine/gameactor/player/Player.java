package dossoccer.gameengine.gameactor.player;

import dossoccer.gameengine.gameactor.Actor;
import dossoccer.gameengine.play.actions.Action;
import dossoccer.gameengine.play.events.Event;
import dossoccer.gameengine.state.Field;
import dossoccer.gameengine.state.FieldSquare;
import dossoccer.gameengine.state.Square;

/**
 * Created by rafael on 15/04/17.
 */
public class Player implements Actor{


    private String name;
    private Role role;

    private Square position;

    public Player(String name, Role role){
        this.setName(name);
        this.role = role;
    }



    public FieldSquare getPreferentialPosition(boolean home){
      /*  if(role == Role.GOALKEEPER){
            return FieldSquare.GOAL;
        }
        */
        if(role == Role.LEFT){
            if (home) {
                return FieldSquare.SQUARE_1_1;
            } else {
                return FieldSquare.SQUARE_4_6;
            }
        }
        if(role == Role.LEFT_DEFENDER){
            if (home) {
                return FieldSquare.SQUARE_2_1;
            } else {
                return FieldSquare.SQUARE_3_6;
            }
        }
        if(role == Role.RIGHT_DEFENDER){
            if (home) {
                return FieldSquare.SQUARE_3_1;
            } else {
                return FieldSquare.SQUARE_2_6;
            }
        }
        if(role == Role.RIGHT){
            if (home) {
                return FieldSquare.SQUARE_4_1;
            } else {
                return FieldSquare.SQUARE_1_6;
            }
        }

        if(role == Role.LEFT_DEFENDER_MID){
            if (home) {
                return FieldSquare.SQUARE_2_3;
            } else {
                return FieldSquare.SQUARE_3_4;
            }
        }

        if(role == Role.RIGHT_DEFENDER_MID){
            if (home) {
                return FieldSquare.SQUARE_3_3;
            } else {
                return FieldSquare.SQUARE_2_4;
            }
        }


        if(role == Role.LEFT_FORWARD_MID){
            if (home) {
                return FieldSquare.SQUARE_2_5;
            } else {
                return FieldSquare.SQUARE_3_2;
            }
        }

        if(role == Role.RIGHT_FORWARD_MID){
            if (home) {
                return FieldSquare.SQUARE_3_5;
            } else {
                return FieldSquare.SQUARE_2_2;
            }
        }
        if(role == Role.LEFT_FORWARD){
            if (home) {
                return FieldSquare.SQUARE_2_6;
            } else {
                return FieldSquare.SQUARE_3_1;
            }
        }

        if(role == Role.RIGHT_FORWARD){
            if (home) {
                return FieldSquare.SQUARE_3_6;
            } else {
                return FieldSquare.SQUARE_2_1;
            }
        }

        return null;
    }

    public Square getPosition() {
        return position;
    }

    public void setPosition(Square position) {
        this.position = position;
    }




    @Override
    public Action onEvent(Field field, Event event) {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
