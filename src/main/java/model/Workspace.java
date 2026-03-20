package model;

import java.util.ArrayList;
import java.util.List;
import model.shapes.Shape;
import model.tools.Tool;

public class Workspace {

    private List<Shape> shapes;
    private ShapeSelection selection;
    private Tool<?> tool;

    public Workspace(){
        shapes = new ArrayList<>();
        selection = new ShapeSelection();
    }

    public void setTool(Tool<?> tool) {
        this.tool = tool;
    }

    public Tool<?> getTool(){
        return tool;
    }

    public int getShapeCount(){
        return shapes.size();
    }

    public ShapeSelection getSelection(){
        return selection;
    }

    public List<Shape> getShapes(){
        return shapes;
    }
    
}
