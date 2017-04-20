package dossoccer.gameengine.play;

import dossoccer.gameengine.gameactor.player.Player;
import dossoccer.gameengine.play.actions.Action;
import dossoccer.gameengine.play.events.Event;
import dossoccer.gameengine.play.events.commands.Command;
import dossoccer.gameengine.play.events.gameevents.UserCommandProcessed;
import dossoccer.gameengine.state.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rafael on 15/04/17.
 */
public class Play {





    private Field processCommandsAndReactions(GameCycle gameCycle){

        //avalliar se eh o caso de processar somente um user command
        List<Event> commands = gameCycle.getEventList()
                .stream()
                .filter(event -> event instanceof Command)
                .collect(Collectors.toList());

        Field currentField = gameCycle.getField();

       /* for (Event evt : commands){
            Command command = (Command) evt;
            currentField = command.getAction().run(currentField);
        }*/
       //only one command. uncomment up if more

        Command command = commands != null && commands.size() > 0 ? (Command) commands.get(0) : null;

        List<Player> players = new ArrayList<>();
        players.addAll(currentField.getHomePlayers());
        players.addAll(currentField.getAwayPlayers());

        //Parallel... god may help all us
        Field finalCurrentField = currentField;
        List<Action> reactions = players.parallelStream()
                                    .filter(player -> command == null || player != command.getAction().getActor()) //TODO A chance de isso funcionar tende a zero
                                    .map(player -> player.onEvent(finalCurrentField, new UserCommandProcessed(commands)))
                                    .filter(action -> action != null)
                                    .collect(Collectors.toList());

        //Apply players reactions
        if(reactions!= null && reactions.size() > 0) {
            for (Action reaction : reactions) {
                currentField = reaction.run(currentField);
            }
        }



        return currentField;
    }


    //Main method to be called by the statefull game machine
    public GameCycle processCycle(GameCycle current){
        Field newField = processCommandsAndReactions(current);

        current.setField(newField);

        return current;
    }

}
