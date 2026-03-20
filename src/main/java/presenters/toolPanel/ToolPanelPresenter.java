package presenters.toolPanel;

import java.util.List;

import contracts.toolPanel.ToolPanelNavigatorContract;
import contracts.toolPanel.ToolPanelViewContract;
import model.ShapeSelection;
import model.shapes.Shape;
import model.tools.Tool;
import model.tools.shapeTools.ShapeTool;
import services.tool.ToolSetServices;

public class ToolPanelPresenter {

    private final ToolPanelViewContract view;
    private final ToolSetServices toolService;

    public ToolPanelPresenter(ToolPanelViewContract view, ToolPanelNavigatorContract navigator, ToolSetServices toolSetService){
        this.view = view;
        this.toolService = toolSetService;
        List<ShapeTool<? extends Shape>> shapeToolsSet = toolService.getShapeToolsUseCase();
        List<Tool<ShapeSelection>> modifierToolsSet = toolService.getModifiersToolsUseCase();

        for (ShapeTool<? extends Shape> tool : shapeToolsSet){
            navigator.loadShapeTool(tool, toolSetService);
        }

        for (Tool<ShapeSelection> tool : modifierToolsSet){
            navigator.loadModifierTool(tool, toolSetService);
        }
        toolSetService.selectSelectTool();
    }
    
}
