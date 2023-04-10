package powpaw.view.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Pair;
import powpaw.controller.impl.StaticGameState;
import powpaw.controller.impl.StatsControllerImpl;
import powpaw.controller.impl.StaticStats;
import powpaw.model.api.StatsBuilder;
import powpaw.model.impl.StatsBuilderImpl;

/**
 * Stats Setting Menu view.
 * 
 * 
 * @author Simone Collorà
 */
public class StatsSettingMenu extends GridPane {

    private static final int NUMSTATISTICS = 3;
    private static final int STATINIT = 5;
    private static final int POINTSSTART = 7;
    private static final int POINTSEND = 0;
    private static final int LABELCOLUMN = 0;
    private static final int ATTACKROW = 1;
    private static final int DEFENCEROW = 2;
    private static final int SPEEDROW = 3;
    private static final int COLUMNP1 = 3;
    private static final int COLUMNP2 = 7;
    private static final int GAP = 15;
    private static final List<String> STATLIST = new ArrayList<>(
            Arrays.asList(new String[] { "ATTACK", "DEFENCE", "SPEED" }));
    private Button finish;
    private Button exit;
    private final List<Pair<Button, String>> plusButtonsP1;
    private final List<Pair<Button, String>> minusButtonsP1;
    private final List<Pair<Button, String>> plusButtonsP2;
    private final List<Pair<Button, String>> minusButtonsP2;
    private int attackPointsP1;
    private int defencePointsP1;
    private int speedPointsP1;
    private int attackPointsP2;
    private int defencePointsP2;
    private int speedPointsP2;
    private final Label att;
    private final Label def;
    private final Label spe;
    private final Label p1 = new Label("Player 1: ");
    private final Label p2 = new Label("Player 2: ");
    private final Text attackTextP1;
    private final Text defenceTextP1;
    private final Text speedTextP1;
    private final Text attackTextP2;
    private final Text defenceTextP2;
    private final Text speedTextP2;
    private int pointsLeftP1;
    private int pointsLeftP2;
    private final Text pointLeftP1Text = new Text("Points left:" + pointsLeftP1);
    private final Text pointLeftP2Text = new Text("Points left:" + pointsLeftP2);
    private StatsBuilder statsP1 = new StatsBuilderImpl();
    private StatsBuilder statsP2 = new StatsBuilderImpl();
    private StatsControllerImpl control = new StatsControllerImpl();

    /**
     * StatsSetting costructor.
     */
    public StatsSettingMenu() {
        att = new Label("Attack: ");
        def = new Label("Defence: ");
        spe = new Label("Speed: ");
        plusButtonsP1 = new ArrayList<>();
        minusButtonsP1 = new ArrayList<>();
        plusButtonsP2 = new ArrayList<>();
        minusButtonsP2 = new ArrayList<>();
        attackPointsP1 = STATINIT;
        defencePointsP1 = STATINIT;
        speedPointsP1 = STATINIT;
        attackPointsP2 = STATINIT;
        defencePointsP2 = STATINIT;
        speedPointsP2 = STATINIT;
        pointsLeftP1 = StaticStats.getLimit() - (attackPointsP1 + defencePointsP1 + speedPointsP1);
        pointsLeftP2 = StaticStats.getLimit() - (attackPointsP2 + defencePointsP2 + speedPointsP2);
        initButton();
        setButtonDimension();
        attackTextP1 = new Text(Integer.toString(attackPointsP1));
        defenceTextP1 = new Text(Integer.toString(defencePointsP1));
        speedTextP1 = new Text(Integer.toString(speedPointsP1));
        attackTextP2 = new Text(Integer.toString(attackPointsP2));
        defenceTextP2 = new Text(Integer.toString(defencePointsP2));
        speedTextP2 = new Text(Integer.toString(speedPointsP2));
        setAlignment(Pos.CENTER);
        setVgap(GAP);
        setHgap(GAP);
        addPosition();
        exit.setOnAction(e -> {
            exit.getScene().setRoot(new StartMenu());
        });
        add(p1, 1, LABELCOLUMN);
        add(p2, 5, LABELCOLUMN);
        for (int i = 0; i < STATLIST.size(); i++) {

            switch (STATLIST.get(i)) {
                case "ATTACK":
                    plusButtonsP1.get(i).getKey().setOnAction(e -> {
                        attackPointsP1 = updateStatPlus(attackPointsP1, attackTextP1);
                        updatePointsLeft();
                    });
                    minusButtonsP1.get(i).getKey().setOnAction(e -> {
                        attackPointsP1 = updateStatMinus(attackPointsP1, attackTextP1);
                        updatePointsLeft();
                    });
                    plusButtonsP2.get(i).getKey().setOnAction(e -> {
                        attackPointsP2 = updateStatPlus(attackPointsP2, attackTextP2);
                        updatePointsLeft();
                    });
                    minusButtonsP2.get(i).getKey().setOnAction(e -> {
                        attackPointsP2 = updateStatMinus(attackPointsP2, attackTextP2);
                        updatePointsLeft();
                    });
                    updatePointsLeft();
                    break;
                case "DEFENCE":
                    plusButtonsP1.get(i).getKey().setOnAction(e -> {
                        defencePointsP1 = updateStatPlus(defencePointsP1, defenceTextP1);
                        updatePointsLeft();
                    });
                    minusButtonsP1.get(i).getKey().setOnAction(e -> {
                        defencePointsP1 = updateStatMinus(defencePointsP1, defenceTextP1);
                        updatePointsLeft();
                    });
                    plusButtonsP2.get(i).getKey().setOnAction(e -> {
                        defencePointsP2 = updateStatPlus(defencePointsP2, defenceTextP2);
                        updatePointsLeft();
                    });
                    minusButtonsP2.get(i).getKey().setOnAction(e -> {
                        defencePointsP2 = updateStatMinus(defencePointsP2, defenceTextP2);
                        updatePointsLeft();
                    });
                    break;
                case "SPEED":
                    plusButtonsP1.get(i).getKey().setOnAction(e -> {
                        speedPointsP1 = updateStatPlus(speedPointsP1, speedTextP1);
                        updatePointsLeft();
                    });
                    minusButtonsP1.get(i).getKey().setOnAction(e -> {
                        speedPointsP1 = updateStatMinus(speedPointsP1, speedTextP1);
                        updatePointsLeft();
                    });
                    plusButtonsP2.get(i).getKey().setOnAction(e -> {
                        speedPointsP2 = updateStatPlus(speedPointsP2, speedTextP2);
                        updatePointsLeft();
                    });
                    minusButtonsP2.get(i).getKey().setOnAction(e -> {
                        speedPointsP2 = updateStatMinus(speedPointsP2, speedTextP2);
                        updatePointsLeft();
                    });
                    break;
                default:
                    break;
            }
        }
        finish.setOnAction(e -> {
            setAllStats();
            StaticStats.buildStatsP1(statsP1);
            StaticStats.buildStatsP2(statsP2);
            StaticGameState.getGameStateView().showGame();
        });
    }

    /**
     * Initialize buttons.
     */
    private void initButton() {
        for (int i = 0; i < NUMSTATISTICS; i++) {
            plusButtonsP1.add(new Pair<Button, String>(new Button("+"), STATLIST.get(i)));
            plusButtonsP2.add(new Pair<Button, String>(new Button("+"), STATLIST.get(i)));
            minusButtonsP1.add(new Pair<Button, String>(new Button("-"), STATLIST.get(i)));
            minusButtonsP2.add(new Pair<Button, String>(new Button("-"), STATLIST.get(i)));
            minusButtonsP1.get(i).getKey().setDisable(true);
            minusButtonsP2.get(i).getKey().setDisable(true);
        }
        exit = new Button("MENU");
        finish = new Button("Finish");
    }

    /**
     * Set Button dimension.
     */
    private void setButtonDimension() {
        for (int i = 0; i < NUMSTATISTICS; i++) {
            plusButtonsP1.get(i).getKey().prefWidthProperty().bind(widthProperty().divide(5));
            plusButtonsP1.get(i).getKey().prefHeightProperty().bind(heightProperty().divide(5));
            plusButtonsP1.get(i).getKey().setMaxSize(50, 50);
            plusButtonsP2.get(i).getKey().prefWidthProperty().bind(widthProperty().divide(5));
            plusButtonsP2.get(i).getKey().prefHeightProperty().bind(heightProperty().divide(5));
            plusButtonsP2.get(i).getKey().setMaxSize(50, 50);
            minusButtonsP1.get(i).getKey().prefWidthProperty().bind(widthProperty().divide(5));
            minusButtonsP1.get(i).getKey().prefHeightProperty().bind(heightProperty().divide(5));
            minusButtonsP1.get(i).getKey().setMaxSize(50, 50);
            minusButtonsP2.get(i).getKey().prefWidthProperty().bind(widthProperty().divide(5));
            minusButtonsP2.get(i).getKey().prefHeightProperty().bind(heightProperty().divide(5));
            minusButtonsP2.get(i).getKey().setMaxSize(50, 50);
        }
        exit.prefWidthProperty().bind(widthProperty().divide(5));
        exit.prefHeightProperty().bind(heightProperty().divide(5));
        exit.setMaxSize(50, 50);
        finish.prefWidthProperty().bind(widthProperty().divide(5));
        finish.prefHeightProperty().bind(heightProperty().divide(5));
        finish.setMaxSize(50, 50);
    }

    /**
     * Set nodes positions.
     */
    private void addPosition() {
        add(att, LABELCOLUMN, ATTACKROW);
        add(def, LABELCOLUMN, DEFENCEROW);
        add(spe, LABELCOLUMN, SPEEDROW);
        for (int i = 0; i < NUMSTATISTICS; i++) {
            add(minusButtonsP1.get(i).getKey(), 1, i + 1);
            add(plusButtonsP1.get(i).getKey(), 2, i + 1);
            add(minusButtonsP2.get(i).getKey(), 5, i + 1);
            add(plusButtonsP2.get(i).getKey(), 6, i + 1);
        }
        add(attackTextP1, COLUMNP1, ATTACKROW);
        add(defenceTextP1, COLUMNP1, DEFENCEROW);
        add(speedTextP1, COLUMNP1, SPEEDROW);
        add(attackTextP2, COLUMNP2, ATTACKROW);
        add(defenceTextP2, COLUMNP2, DEFENCEROW);
        add(speedTextP2, COLUMNP2, SPEEDROW);
        add(pointLeftP1Text, 1, 5);
        add(pointLeftP2Text, 5, 5);
        add(exit, 0, 10);
        add(finish, 10, 10);
    }

    /**
     * Set all stats.
     */
    private void setAllStats() {
        statsP1.setAttack(attackPointsP1);
        statsP1.setDefence(defencePointsP1);
        statsP1.setSpeed(speedPointsP1);
        statsP2.setAttack(attackPointsP2);
        statsP2.setDefence(defencePointsP2);
        statsP2.setSpeed(speedPointsP2);
    }

    /**
     * Update stat when increased.
     * 
     * @param points old points
     * @param text   points text
     * @return new points increased
     */
    private int updateStatPlus(final int points, final Text text) {
        int newPoints = points;
        newPoints = control.increase(newPoints);
        text.setText(Integer.toString(newPoints));
        return newPoints;
    }

    /**
     * Update stat when decreased.
     * 
     * @param points old points
     * @param text   points text
     * @return new points decreased
     */
    private int updateStatMinus(final int points, final Text text) {
        int newPoints = points;
        newPoints = control.decrease(newPoints);
        text.setText(Integer.toString(newPoints));
        return newPoints;
    }

    /**
     * Update points left and update the text. If the pointsLeft are maximum(7 in
     * our case) minus button
     * are disabled and when points left are 0 the plus buttons are disabled.
     */
    private void updatePointsLeft() {
        pointsLeftP1 = StaticStats.getLimit() - (attackPointsP1 + defencePointsP1 + speedPointsP1);
        pointsLeftP2 = StaticStats.getLimit() - (attackPointsP2 + defencePointsP2 + speedPointsP2);
        pointLeftP1Text.setText("Points left:" + pointsLeftP1);
        pointLeftP2Text.setText("Points left:" + pointsLeftP2);

        for (int i = 0; i < plusButtonsP1.size(); i++) {
            plusButtonsP1.get(i).getKey().setDisable(pointsLeftP1 == POINTSEND);
            minusButtonsP1.get(i).getKey().setDisable(pointsLeftP1 == POINTSSTART);
            plusButtonsP2.get(i).getKey().setDisable(pointsLeftP2 == POINTSEND);
            minusButtonsP2.get(i).getKey().setDisable(pointsLeftP2 == POINTSSTART);
        }
    }
}
