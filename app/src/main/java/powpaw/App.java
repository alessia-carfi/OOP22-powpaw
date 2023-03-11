/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package powpaw;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import powpaw.view.api.GameInterface;
import powpaw.view.api.StartMenu;

public class App extends Application {
    private StartMenu menu;
    private Scene sceneMenu;
    private Scene sceneGame;
    private final Stage stage;
    private GameInterface game;

    public App(){
        stage = new Stage();
    }

    public static void main(String[] args) {
        Application.launch(App.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        getMenu();
    }

    public void getGame() throws Exception {
        this.stage.close();
        game = new GameInterface();
        sceneGame = new Scene(game, 500, 300);
        this.stage.setScene(sceneGame);
        this.stage.setTitle("PowPaw");
        this.stage.show();
    }

    public void getMenu() {
        menu = new StartMenu();
        sceneMenu = new Scene(menu, 500, 300);
        this.stage.setScene(sceneMenu);
        this.stage.show();
    }
    public Stage getStage(){
        return this.stage;
    }
}
