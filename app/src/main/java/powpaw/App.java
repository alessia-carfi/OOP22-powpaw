/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package powpaw;

import javafx.application.Application;
import javafx.stage.Stage;
import powpaw.controller.impl.StaticGameState;

public class App extends Application {
    public static void main(String[] args) {
        Application.launch(App.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StaticGameState.getGameStateView().showStartMenu();
    }
}
