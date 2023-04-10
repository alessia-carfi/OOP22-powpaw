package powpaw.PowerUp.controller.impl;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import powpaw.Player.controller.api.PlayerController;
import powpaw.PowerUp.controller.api.PowerUpController;
import powpaw.PowerUp.model.api.PowerUp;
import powpaw.PowerUp.model.impl.AttackPowerUp;
import powpaw.PowerUp.model.impl.SpeedPowerUp;
import powpaw.PowerUp.view.api.PowerUpRender;
import powpaw.PowerUp.view.impl.PowerUpRenderImpl;

/**
 * PowerUpController that create render and set powerUp behaviour.
 * 
 * @author Simone Collorà
 */
public final class PowerUpControllerImpl implements PowerUpController {
    private final Random rand = new Random();
    private final PowerUpRender powerUpRender;
    private PowerUp powerUp;
    private boolean isCollected;

    /**
     * PowerUpController costructor.
     */
    public PowerUpControllerImpl() {
        this.powerUpRender = new PowerUpRenderImpl();
        this.choosePowerUp();
    }

    @Override
    public PowerUpRender getRender() {
        return this.powerUpRender;
    }

    @Override
    public void pickPowerUp(final PlayerController playerController) {

        playerController.getPlayerObservable().getPlayers().forEach(player -> {
            if (powerUp.getHurtbox().getBoundsInParent()
                    .intersects(player.getHitbox().getShape().getBoundsInParent()) && !isCollected) {
                powerUp.statPowerUp(player.getNumber() == 1
                        ? playerController.getPlayerObservable().getPlayers().get(0).getPlayerStats()
                        : playerController.getPlayerObservable().getPlayers().get(1).getPlayerStats());
                isCollected = true;
                powerUp.setVisible(false);
                new Timeline(new KeyFrame(Duration.seconds(10), event -> {
                    isCollected = false;
                    this.choosePowerUp();
                    powerUp.setVisible(true);
                })).play();
            }
        });
    }

    /**
     * This method chose with a random number what powerUp will be created.
     */
    private void choosePowerUp() {
        final int powerUpIndex = rand.nextInt(2);
        powerUp = powerUpIndex == 0 ? new SpeedPowerUp() : new AttackPowerUp();
        powerUpRender.setPowerUp(powerUp, powerUpIndex);
    }
}
