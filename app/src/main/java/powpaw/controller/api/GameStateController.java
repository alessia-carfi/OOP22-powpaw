package powpaw.controller.api;

public interface GameStateController {

    /**
     * GameStateController. Every method set a determinated state:
     * Start,Character Creation, Game and Game over.
     * 
     * @author Simone Collorà
     */

    /**
     * Set State to START.
     */
    void start();

    /**
     * Set State to STATS.
     */
    void characterCreation();

    /**
     * Set State to GAME.
     */
    void game();

    /**
     * Set State to GAMEOVER.
     */
    void gameOver();
}
