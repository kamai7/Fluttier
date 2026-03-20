package model;

import java.util.Arrays;
import java.util.List;
import model.shapes.Shape;
import model.tools.MoveTool;
import model.tools.ResizeTool;
import model.tools.SelectTool;
import model.tools.Tool;
import model.tools.shapeTools.EllipseTool;
import model.tools.shapeTools.RectangleTool;
import model.tools.shapeTools.ShapeTool;
import utils.Colors;

public class ToolsFactory {

    private static EllipseTool EllipseTool;
    private static RectangleTool RectangleTool;

    private static SelectTool SelectTool;
    private static MoveTool MoveTool;
    private static ResizeTool ResizeTool;

    public static List<ShapeTool<? extends Shape>> createShapeTools(Workspace workspace){
        EllipseTool = new EllipseTool(workspace.getShapes());
        RectangleTool = new RectangleTool(workspace.getShapes());
        return Arrays.asList(
            EllipseTool,
            RectangleTool
        );
    }

    public static List<Tool<ShapeSelection>> createModifiersTools(Workspace workspace){
        SelectTool = new SelectTool(workspace.getSelection());
        MoveTool = new MoveTool(workspace.getSelection());
        ResizeTool = new ResizeTool(workspace.getSelection());
        return Arrays.asList(
            SelectTool,
            MoveTool,
            ResizeTool
        );

    }

    private static void checkinitialized(Tool<?> tool){
        if (tool == null){
            throw new RuntimeException(Colors.red("this tool is not initialized, you must execute the create methods before"));
        }
    }

    public static EllipseTool getEllipseTool(){
        checkinitialized(EllipseTool);
        return EllipseTool;
    }

    public static RectangleTool getRectangleTool(){
        checkinitialized(RectangleTool);
        return RectangleTool;
    }


    public static MoveTool getMoveTool(){
        checkinitialized(MoveTool);
        return MoveTool;
    }

    public static SelectTool getSelectTool(){
        checkinitialized(SelectTool);
        return SelectTool;
    }

    public static ResizeTool getResizeTool(){
        checkinitialized(ResizeTool);
        return ResizeTool;
    }
    
}
