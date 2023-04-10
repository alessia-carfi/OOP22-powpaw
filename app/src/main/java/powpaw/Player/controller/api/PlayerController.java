package powpaw.Player.controller.api;

import java.util.List;

import powpaw.Player.model.api.Player;
import powpaw.Player.view.api.PlayerRender;

/**
 * Interface for the controller of a player.
 * 
 * @author Alessia Carfì
 */
public interface PlayerController {

    /**
     * Returns the list of player render objects.
     * 
     * @return the list of player render objects.
     */
    List<PlayerRender> getRender();

    /**
     * Returns the PlayerObservable object.
     * 
     * @return the PlayerObservable object.
     */
    PlayerObservable getPlayerObservable();

    /**
     * Returns the list of players.
     * 
     * @return the list of players.
     */
    List<Player> getPlayers();
}
