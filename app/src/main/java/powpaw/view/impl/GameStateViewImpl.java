package powpaw.view.impl;

import javafx.scene.Scene;
import javafx.stage.Stage;
import powpaw.GameLoop;
import powpaw.controller.api.GameStateController;
import powpaw.controller.api.ScreenController;
import powpaw.controller.impl.GameStateControllerImpl;
import powpaw.controller.impl.MediaAudio;
import powpaw.view.api.GameOver;
import powpaw.view.api.GameStateView;
import powpaw.view.api.StartMenu;

public class GameStateViewImpl implements GameStateView {

    Stage stage = new Stage();
    GameStateController gameStateController = new GameStateControllerImpl();

    public GameStateViewImpl() {
        stage.setTitle("PowPaw");
        stage.setResizable(false);

    }

    @Override
    public void showStartMenu() {
        gameStateController.start();
        stage.setScene(new Scene(new StartMenu(), ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H));
        MediaAudio.playSound("/mainTitle.wav");
        stage.show();
    }

    @Override
    public void showCharacterCreation() {
        gameStateController.characterCreation();
        stage.setScene(new Scene(new StatsSettingMenu(), ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H));
        stage.show();
    }

    @Override
    public void showGame() {
        gameStateController.game();
        WorldRenderImpl worldRender = new WorldRenderImpl();
        GameLoop loop = new GameLoop();
        stage.setScene(worldRender.render());
        stage.show();
        worldRender.playersCommands();
        loop.setPlayerController(worldRender.getPlayerController());
        loop.setWeaponController(worldRender.getWeaponController());
        loop.setPowerUpController(worldRender.getPowerUpController());
        loop.start();
    }

    @Override
    public void showGameOver() {
        gameStateController.gameOver();
        stage.setScene(new Scene(new GameOver(), ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H));
        stage.show();

    }

}
