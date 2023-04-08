package powpaw.view.impl;

import java.util.stream.Collectors;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import powpaw.controller.api.ScreenController;
import powpaw.controller.impl.PlayerController;
import powpaw.controller.impl.PowerUpController;
import powpaw.controller.impl.WeaponController;
import powpaw.view.api.WorldRender;

public class WorldRenderImpl implements WorldRender {

    private final MapRender mapRender = new MapRender();
    private final PlayerController playerController = new PlayerController();
    private final WeaponController weaponController = new WeaponController(playerController);
    private final PowerUpController powerUpController = new PowerUpController();

    private Scene worldScene;

    @Override
    public PlayerController getPlayerController() {
        return this.playerController;
    }

    @Override
    public WeaponController getWeaponController() {
        return this.weaponController;
    }

    @Override
    public PowerUpController getPowerUpController() {
        return this.powerUpController;
    }

    @Override
    public MapRender getMapRender() {
        return this.mapRender;
    }

    @Override
    public Scene render() {
        Pane worldPane = mapRender.createPane();
        worldPane.setBackground(
                Background.fill(new ImagePattern(new Image("/backgroundWorld.png"))));
        worldPane.getChildren()
                .addAll(playerController.getRender().stream().map(r -> r.getSprite()).collect(Collectors.toList()));

        worldPane.getChildren()
                .addAll(playerController.getRender().stream().map(r -> r.getArmSprite()).collect(Collectors.toList()));

        //playerController.getRender().forEach( p ->  worldPane.getChildren().add(p.getArmSprite()));
        

        // debug

        //worldPane.getChildren().add(playerController.getRender().get(0).getPlayer().getHitbox().getShape());
        //worldPane.getChildren().add(playerController.getRender().get(0).getPlayer().getFeetBox());
        worldPane.getChildren().add(playerController.getRender().get(0).getPlayer().getArmHitbox());
        //worldPane.getChildren().add(playerController.getRender().get(1).getPlayer().getHitbox().getShape());
        //worldPane.getChildren().add(playerController.getRender().get(1).getPlayer().getFeetBox());
        worldPane.getChildren().add(playerController.getRender().get(1).getPlayer().getArmHitbox()); 
      

        mapRender.getTerrains().forEach(b -> worldPane.getChildren().add(b.getHitbox().getShape()));
        //worldPane.getChildren().add(weaponController.getWeapon().getHitbox().getShape());
        worldPane.getChildren().add(weaponController.getRender().getWeaponSprite());
        worldPane.getChildren().add(powerUpController.getRender().getSprite());
        weaponController.getRender().setTerrains(mapRender.getTerrains());
        this.worldScene = new Scene(worldPane, ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H);
        return worldScene;
    }

    public void playersCommands() {

        this.worldScene.setOnKeyPressed(event -> playerController.getPlayerObservable().getKeyObservable()
                .notifyObserversPressed(event.getCode()));

        this.worldScene.setOnKeyReleased(event -> playerController.getPlayerObservable().getKeyObservable()
                .notifyObserversReleased(event.getCode()));
    }
}
