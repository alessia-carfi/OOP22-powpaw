package powpaw.controller.impl;

import java.util.List;

import powpaw.controller.api.MapController;
import powpaw.controller.api.ScreenController;
import powpaw.model.impl.BlockImpl;
import powpaw.model.impl.CreateMap;

/**
 * Class MapController that creates and sets the map entities and their
 * respective proportions with the screen size.
 * 
 * @author Giacomo Grassetti
 */

public class MapControllerImpl implements MapController {

    private final List<BlockImpl> terrains;

    /**
     * Costrutor of MapController class.
     */
    public MapControllerImpl() {
        final CreateMap worldMap = new CreateMap();
        this.terrains = worldMap.getTerrains();
        setProportions();
    }

    /**
     * Method to sets the proportions of terrains based on the screen size.
     */
    private void setProportions() {
        this.terrains.stream().forEach(b -> {
            b.setX(b.getPosition().getX() * (ScreenController.SIZE_HD_W / ScreenController.NUM_BLOCK_W));
            b.setY(b.getPosition().getY() * (ScreenController.SIZE_HD_H / ScreenController.NUM_BLOCK_H));
            b.setWidth(b.getWidth() * (ScreenController.SIZE_HD_W / ScreenController.NUM_BLOCK_W));
            b.setHeight(b.getHeight() * (ScreenController.SIZE_HD_H / ScreenController.NUM_BLOCK_H));
        });
    }

    @Override
    public List<BlockImpl> getPlatforms() {
        return this.terrains;
    }

}
