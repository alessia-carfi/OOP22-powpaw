/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package powpaw;

import javafx.application.Application;
import javafx.stage.Stage;
import powpaw.view.api.WordRender;
import powpaw.view.impl.WordRenderImpl;

public class App extends Application {
    private GameLoop loop = new GameLoop();
    private WordRender wordRender = new WordRenderImpl();

    public static void main(String[] args) {
        Application.launch(App.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setScene(wordRender.render());
        primaryStage.setTitle("PowPaw");
        primaryStage.setResizable(false);
        primaryStage.show();
        wordRender.setKeyCommands();
        loop.setPlayerController(wordRender.getPlayerController());
        loop.setWeaponController(wordRender.getWeaponController());
        loop.setPowerUpController(wordRender.getPowerUpController());
        loop.start();
    }
}
