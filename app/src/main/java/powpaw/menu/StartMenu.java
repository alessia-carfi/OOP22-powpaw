package powpaw.menu;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import powpaw.core.controller.StaticGameState;

/**
 * Start menu view.
 * 
 * @author Simone Collorà
 */

public class StartMenu extends GridPane {
    private static final int GAP = 15;
    private static final int DIVIDE = 4;
    private static final int MAXWIDTHB = 300;
    private static final int MAXHEIGHTB = 70;
    private static final int COLUMNIND= 0;
    private static final int ROWINDFIRB= 0;
    private static final int ROWINDSECB= 1;


    /**
     * Start menu costructor.
     */
    public StartMenu() {
        setAlignment(Pos.CENTER);
        setBackground(Background.fill(new ImagePattern(new Image("/background_menu.png"))));
        final Button start = new Button("START");
        final Button exit = new Button("EXIT");
        setVgap(GAP);
        setHgap(GAP);
        start.prefWidthProperty().bind(widthProperty().divide(DIVIDE));
        start.prefHeightProperty().bind(heightProperty().divide(DIVIDE));
        exit.prefWidthProperty().bind(widthProperty().divide(DIVIDE));
        exit.prefHeightProperty().bind(heightProperty().divide(DIVIDE));
        start.setMaxSize(MAXWIDTHB, MAXHEIGHTB);
        exit.setMaxSize(MAXWIDTHB, MAXHEIGHTB);
        add(start, COLUMNIND, ROWINDFIRB);
        add(exit, COLUMNIND, ROWINDSECB);
        start.setOnAction(e -> StaticGameState.getGameStateView().showCharacterCreation());
        exit.setOnAction(e -> {
            Platform.exit();
        });
    }
}
