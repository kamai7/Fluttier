package view.references;

import java.util.Map;
import static java.util.Map.entry;

import javafx.scene.image.Image;
import references.Icons;

public class IconsReferences {
    private static Map<Icons, Image> refTable = Map.ofEntries(
        entry(Icons.CIRCLE_TOOL, new Image("/img/circle.png")),
        entry(Icons.RECTANGLE_TOOL, new Image("/img/rectangle.png")),
        entry(Icons.MOVE_TOOL, new Image("/img/move_tool.png")),
        entry(Icons.RESIZE_TOOL, new Image("/img/resize_tool.png")),
        entry(Icons.SELECT_TOOL, new Image("/img/select_tool.png"))
    );

    public static Image get(Icons icon){
        return refTable.get(icon);
    }
}
