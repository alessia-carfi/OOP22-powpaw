package powpaw.view.impl;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import powpaw.controller.api.MapController;
import powpaw.controller.impl.MapControllerImpl;
import powpaw.model.impl.BlockImpl;
import powpaw.view.api.MapRender;

/**
 * Class creates a pane and draws blocks on it using a ImagePattern.
 * 
 * @author Giacomo Grassetti
 */
public class MapRenderImpl implements MapRender {

    private MapController mapController;
    private ArrayList<BlockImpl> terrains;
    private ImagePattern textureBlock;

    /**
     * Constructor of MapRenderImpl that gets the list of platforms from the
     * mapController object and assigns it to the terrains variable, and creates a
     * new ImagePattern object with the block image
     */
    public MapRenderImpl() {
        this.mapController = new MapControllerImpl();
        this.terrains = mapController.getPlatforms();
        this.textureBlock = new ImagePattern(new Image("/block.png"));
    }

    /**
     * Method that creates a Pane and draws blocks on it.
     * 
     * @return A Pane object.
     */
    @Override
    public Pane createPane() {
        Pane worldPane = new Pane();
        drawBlocks();
        return worldPane;
    }

    private void drawBlocks() {
        this.terrains.stream().forEach(b -> b.getHitbox().getShape().setFill(this.textureBlock));
    }

    /**
     * Getters for an ArrayList of BlockImpl representing terrains.
     * 
     * @return An ArrayList of BlockImpl
     */
    @Override
    public ArrayList<BlockImpl> getTerrains() {
        return this.terrains;
    }

}