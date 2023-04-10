package powpaw;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javafx.geometry.Point2D;
import powpaw.Player.model.api.Player;
import powpaw.Player.model.impl.PlayerImpl;
import powpaw.Player.model.impl.PlayerImpl.PlayerState;

public class PlayerTest {

    private final static Point2D DEBUG_POSITION = new Point2D(0, 0);
    private final static int DEBUG_PLAYER_NUMBER = 1;
    private final static double DEBUG_PLAYER_WIDHT = 5;
    private final static double DEBUG_PLAYER_HEIGHT = 10;
    private final static Point2D DEBUG_PLAYER_DIRECTION = new Point2D(1, 0);

    private Player player = new PlayerImpl(DEBUG_POSITION, DEBUG_PLAYER_NUMBER);

    @Test
    void getNumberTest() {
        assertEquals(DEBUG_PLAYER_NUMBER, this.player.getNumber());
    }

    @Test
    void initialPositionTest() {
        assertEquals(DEBUG_POSITION, this.player.getPosition());
    }

    @Test
    void setSizeTest() {
        this.player.setHeight(DEBUG_PLAYER_HEIGHT);
        assertEquals(DEBUG_PLAYER_HEIGHT, this.player.getHeight());

        this.player.setWidth(DEBUG_PLAYER_WIDHT);
        assertEquals(DEBUG_PLAYER_WIDHT, this.player.getWidth());

    }

    @Test
    void setDirectionTest() {
        Point2D direction = DEBUG_PLAYER_DIRECTION;

        this.player.setDirection(direction);
        assertEquals(direction, this.player.getDirection());
    }

    @Test
    void setStateTest() {
        this.player.setCurrentState(PlayerState.ATTACK);
        assertEquals(PlayerState.ATTACK, this.player.getState());

        this.player.setCurrentState(PlayerState.IDLE);
        assertEquals(PlayerState.IDLE, this.player.getState());
    }
}
