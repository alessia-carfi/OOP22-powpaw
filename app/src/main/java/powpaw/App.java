/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package powpaw;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import powpaw.controller.api.ScreenController;
import powpaw.controller.impl.PlayerController;
import powpaw.view.api.WorldRender;

public class App extends Application {
    private WorldRender worldRender = new WorldRender();
    GameLoop loop = new GameLoop();
    PlayerController playerController = new PlayerController();

    public static void main(String[] args) {
        Application.launch(App.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane worldPane = new Pane();
        worldRender.createScene(worldPane);
        worldPane.getChildren().add(playerController.getRender().getSprite());

        Scene worldScene = new Scene(worldPane, ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H);

        worldScene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                playerController.getWorld().getKeyObservable().notifyObserversPressed(event);
                System.out.println(event.getCode());
            }
        });

        worldScene.setOnKeyReleased(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                playerController.getWorld().getKeyObservable().notifyObserversReleased(event);
            }

        });

        primaryStage.setScene(worldScene);
        primaryStage.setTitle("PowPaw");
        primaryStage.setScene(worldScene);
        primaryStage.setResizable(false);
        primaryStage.show();
        loop.setPlayerController(playerController);
        loop.start();
    }
}
