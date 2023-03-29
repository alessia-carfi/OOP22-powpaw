package powpaw.view.api;

import javafx.scene.Scene;
import powpaw.controller.impl.PlayerController;
import powpaw.controller.impl.PowerUpController;
import powpaw.controller.impl.WeaponController;
import powpaw.view.impl.MapRender;

public interface WordRender {

    PlayerController getPlayerController();

    WeaponController getWeaponController();

    PowerUpController getPowerUpController();

    MapRender getMapRender();

    Scene render();

    void setKeyCommands();
}
