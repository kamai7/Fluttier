package contracts.toolPanel;

import model.shapes.Shape;
import model.tools.Tool;
import model.tools.shapeTools.ShapeTool;
import services.tool.ToolSetServices;

public interface ToolPanelNavigatorContract {
    
    public void loadShapeTool(ShapeTool<? extends Shape> tool, ToolSetServices service);

    public void loadModifierTool(Tool<?> tool, ToolSetServices service);

}
