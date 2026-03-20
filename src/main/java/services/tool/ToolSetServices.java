package services.tool;

import java.util.List;
import model.shapes.Shape;
import model.tools.MoveTool;
import model.tools.ResizeTool;
import model.tools.SelectTool;
import model.tools.Tool;
import model.tools.shapeTools.ShapeTool;
import utils.listener.*;
import model.ShapeSelection;
import model.ToolsFactory;
import model.Workspace;

public class ToolSetServices {

    private final Workspace model;
    private final Subject<Tool<?>> toolListener;

    public ToolSetServices(Workspace model){
        this.model = model;
        this.toolListener = new Subject<>();
    }

    public List<ShapeTool<? extends Shape>> getShapeToolsUseCase(){
        return ToolsFactory.createShapeTools(model);
    }

    public List<Tool<ShapeSelection>> getModifiersToolsUseCase(){
        return ToolsFactory.createModifiersTools(model);
    }

    // listeners

    public void changeToolUseCase(Tool<?> tool){
        model.setTool(tool);
        toolListener.set(tool);
    }

    public void addToolListener(Observer<Tool<?>> o){
        toolListener.addObserver(o);
    }

    // verifs

    public boolean isSelectTool(){
        return model.getTool() instanceof SelectTool;
    }

    public boolean isShapeTool(){
        return model.getTool() instanceof ShapeTool;
    }

    public boolean isMoveToolTool(){
        return model.getTool() instanceof MoveTool;
    }

    public boolean isResizeTool(){
        return model.getTool() instanceof ResizeTool;
    }

    // tools

    public void selectSelectTool(){
        changeToolUseCase(ToolsFactory.getSelectTool());
    }

    public void selectResizeTool(){
        changeToolUseCase(ToolsFactory.getResizeTool());
    }

    public void selectMoveTool(){
        changeToolUseCase(ToolsFactory.getMoveTool());
    }
    
}
