package model.tools.shapeTools;

import java.util.List;

import javafx.scene.paint.Color;
import model.events.PosEvent;
import model.events.ShapeEvent;
import model.events.ToggleEvent;
import model.shapes.Shape;
import model.tools.Tool;

public abstract class ShapeTool<S extends Shape> extends Tool<List<Shape>>{

    protected S shape;
    public final static double DEFAULT_SIZE = 100.0;
    public final static Color DEFAULT_FILL_COLOR = new Color(1.0, 0.7, 0.0, 1);
    public final static Color DEFAULT_BORDER_COLOR = Color.BLACK;
    public final static double DEFAULT_BORDER_WIDTH = 5;

   public ShapeTool(List<Shape> property) {
        super(property);
    }

    public final void execute(PosEvent event){
        if (this.shape == null){
            shape = create(event);
            property.add(shape);
        }else{
            edit(event);
        }
    }

    public final void execute(ShapeEvent e){}

    public final void execute(ToggleEvent e){}

    protected abstract void edit(PosEvent pos);

    protected abstract S create(PosEvent pos);

    public void close(){
        shape = null;
    }

}
