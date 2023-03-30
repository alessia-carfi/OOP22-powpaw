package powpaw.view.impl;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import powpaw.model.impl.BlockImpl;
import powpaw.model.impl.WeaponImpl;

public class WeaponRender {

    private WeaponImpl weapons;
    private ArrayList<BlockImpl> terrains;
    private Image image;
    private ImageView weaponSprite;

    public WeaponRender(WeaponImpl weapons) {
        this.weapons = weapons;
        this.image = new Image("/sword.png");
        this.weaponSprite = new ImageView(this.image);
    }

    public void setTerrains(ArrayList<BlockImpl> terrains) {
        this.terrains = terrains;
    }

    public ArrayList<BlockImpl> getTerrains() {
        return this.terrains;
    }

    public ImageView getWeaponSprite() {
        return this.weaponSprite;
    }

    public void render() {
        this.weaponSprite.setLayoutX(weapons.getPosition().getX());
        this.weaponSprite.setLayoutY(weapons.getPosition().getY());
        this.weaponSprite.setFitWidth(WeaponImpl.WIDTH);
        this.weaponSprite.setFitHeight(WeaponImpl.HEIGHT);

    }


}
