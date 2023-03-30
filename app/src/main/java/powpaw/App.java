/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package powpaw;

import javafx.application.Application;
import javafx.stage.Stage;
import powpaw.common.GameState;
import powpaw.view.api.GameStateView;
import powpaw.view.impl.GameStateViewImpl;

public class App extends Application {
    private GameState state = GameState.STATS;
    private GameStateView stateV = new GameStateViewImpl();

    public static void main(String[] args) {
        Application.launch(App.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        switch (state) {
            case START:
                stateV.showStartMenu();
                break;
            case STATS:
                stateV.showCharacterCreation();
                break;
            case GAME:
                stateV.showGame();
                break;
            case GAMEOVER:
                stateV.showGameOver();
                break;
        }
    }
}
