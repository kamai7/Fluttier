package view.workspace;

import static java.util.Map.entry;

import java.util.Map;
import java.util.function.Supplier;
import model.shapes.Ellipse;
import model.shapes.Rectangle;
import model.shapes.Shape;
import view.workspace.shapes.EllipseView;
import view.workspace.shapes.RectangleView;
import view.workspace.shapes.ShapeView;

public class ShapeMapper {
    private static Map<Class<? extends Shape> , Supplier<ShapeView<? extends javafx.scene.shape.Shape>>> map = Map.ofEntries(
        entry(Ellipse.class, EllipseView::new),
        entry(Rectangle.class, RectangleView::new)
    );

    public static ShapeView<? extends javafx.scene.shape.Shape> map(Shape s){
        return map.get(s.getClass()).get();
    }
    
}
