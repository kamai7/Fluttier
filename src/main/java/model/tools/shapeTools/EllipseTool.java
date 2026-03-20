package model.tools.shapeTools;

import java.util.List;

import model.events.PosEvent;
import model.shapes.Ellipse;
import model.shapes.Shape;
import references.Icons;
import utils.ReadOnlyVect;
import utils.Vect;

public class EllipseTool extends ShapeTool<Ellipse> {

    public EllipseTool(List<Shape> property) {
        super(property);
    }

    @Override
    public Ellipse create(PosEvent event) {
        Vect dimens = new Vect(DEFAULT_SIZE/2);
        return new Ellipse(event.get(), dimens, DEFAULT_FILL_COLOR, DEFAULT_BORDER_WIDTH, DEFAULT_BORDER_COLOR);
    }

    @Override
    public void edit(PosEvent event) {
        double r = euclidianDistance(shape.getPos(), event.get());
        shape.setRadius(new Vect(r));
    }

    private double euclidianDistance(ReadOnlyVect start, ReadOnlyVect end){
        double offsetX = end.x() - start.x();
        double offsetY = end.y() - start.y();
        return Math.sqrt((offsetX*offsetX) + (offsetY * offsetY));
    }

    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public Icons getIcon() {
        return Icons.CIRCLE_TOOL;
    }
}
