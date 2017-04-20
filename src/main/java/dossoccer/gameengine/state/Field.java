package dossoccer.gameengine.state;

import dossoccer.gameengine.gameactor.ball.Ball;
import dossoccer.gameengine.gameactor.player.Player;

import java.util.HashMap;
import java.util.List;

/**
 * Created by rafael on 13/04/17.
 */

public class Field {

    private HashMap<FieldSquare, Square> squares;
    private List<Player> homePlayers;
    private List<Player> awayPlayers;

    private Ball ball;

    public Field(){
        initSquares();
        this.ball = new Ball(this.getSquare(FieldSquare.SQUARE_2_3));
    }

    private void initSquares() {
        squares = new HashMap<>();

        for (FieldSquare fieldSquare : FieldSquare.values()) {
            squares.put(fieldSquare, new Square(fieldSquare));
        }

    }


    public Square getSquare(FieldSquare fieldSquare){
        return squares.get(fieldSquare);
    }



    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public List<Player> getHomePlayers() {
        return homePlayers;
    }

    public void setHomePlayers(List<Player> homePlayers) {
        this.homePlayers = homePlayers;
    }

    public List<Player> getAwayPlayers() {
        return awayPlayers;
    }

    public void setAwayPlayers(List<Player> awayPlayers) {
        this.awayPlayers = awayPlayers;
    }
}
