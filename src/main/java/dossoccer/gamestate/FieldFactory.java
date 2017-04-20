package dossoccer.gamestate;

import dossoccer.gameengine.gameactor.player.Player;
import dossoccer.gameengine.gameactor.player.Role;
import dossoccer.gameengine.state.Field;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael on 15/04/17.
 */
public class FieldFactory {


    public Field kickOff(){

        Field field = new Field();

        List<Player> tA = new ArrayList<>();
        List<Player> tB = new ArrayList<>();

        for(Role role : Role.values()){
            SecureRandom random = new SecureRandom();


            Player pA = new Player(new BigInteger(13, random).toString(32) + "(A)", role);
            Player pB = new Player(new BigInteger(13, random).toString(32) + "(B)", role);

            tA.add(pA);
            tB.add(pB);

        }

        field.setAwayPlayers(tB);
        field.setHomePlayers(tA);

        field.getHomePlayers().stream().forEach(player -> player.setPosition(field.getSquare(player.getPreferentialPosition(true))));
        field.getAwayPlayers().stream().forEach(player -> player.setPosition(field.getSquare(player.getPreferentialPosition(false))));

        return field;
    }
}
