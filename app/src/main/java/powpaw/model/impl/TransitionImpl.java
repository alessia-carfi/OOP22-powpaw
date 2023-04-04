package powpaw.model.impl;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import powpaw.model.api.Hitbox;
import powpaw.model.api.Transition;

public class TransitionImpl implements Transition {

    private CreateMap map;

    public TransitionImpl() {
        this.map = new CreateMap();
    }

    @Override
    public Point2D fallTransition(Point2D pos) {
        if (!checkCollisionByPos(pos)) {
            return pos.add(0, 2);
        }
        return pos;
    }

    private boolean checkCollisionByPos(Point2D pos) {
        Rectangle tmp = new Rectangle(pos.getX(), pos.getY(), WeaponImpl.WIDTH, WeaponImpl.HEIGHT);
        for (BlockImpl obs : this.map.getTerrains()) {
            if (tmp.getBoundsInParent()
                    .intersects(obs.getHitbox().getShape().getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkPlayerCollisionByHitbox(Hitbox hitbox) {
        for (BlockImpl obs : this.map.getTerrains()) {
            if (hitbox.getShape().getBoundsInParent()
                    .intersects(obs.getHitbox().getShape().getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }
}