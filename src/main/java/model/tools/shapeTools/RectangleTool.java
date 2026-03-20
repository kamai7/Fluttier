package model.tools.shapeTools;

import java.util.List;

import model.events.PosEvent;
import model.shapes.Rectangle;
import model.shapes.Shape;
import references.Icons;
import utils.Vect;

public class RectangleTool extends ShapeTool<Rectangle> {

    public RectangleTool(List<Shape> property) {
        super(property);
    }

    @Override
    public Rectangle create(PosEvent event) {
        Vect dimens = new Vect(DEFAULT_SIZE);
        return new Rectangle(event.get(), dimens, DEFAULT_FILL_COLOR, DEFAULT_BORDER_WIDTH, DEFAULT_BORDER_COLOR);
    }

    @Override
    public void edit(PosEvent event) {
        Vect offset = event.get().getSub(shape.getPos()).abs();
        shape.setDimens(offset.mult(2));
    }
    
    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public Icons getIcon() {
        return Icons.RECTANGLE_TOOL;
    }
}
