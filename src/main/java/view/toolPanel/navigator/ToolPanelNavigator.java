package view.toolPanel.navigator;

import java.io.IOException;

import contracts.toolPanel.ToolPanelNavigatorContract;
import contracts.toolPanel.ToolViewContract;
import javafx.fxml.FXMLLoader;
import model.shapes.Shape;
import model.tools.Tool;
import model.tools.shapeTools.ShapeTool;
import presenters.toolPanel.ToolPresenter;
import services.tool.ToolServices;
import services.tool.ToolSetServices;
import view.navigator.Navigator;
import view.references.Fxml;
import view.toolPanel.ToolPanelView;

public class ToolPanelNavigator extends Navigator<ToolPanelView> implements ToolPanelNavigatorContract{

    public ToolPanelNavigator(ToolPanelView view) {
        super(view);
    }

    @Override
    public void loadShapeTool(ShapeTool<? extends Shape> tool, ToolSetServices service) {
        try{
            FXMLLoader loader = getLoader(Fxml.SHAPE_TOOL);
            view.addShapeTool(loader.load());
            loadTool(loader.getController(), tool, service);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void loadModifierTool(Tool<?> tool, ToolSetServices service) { 
        try{
            FXMLLoader loader = getLoader(Fxml.MODIFIER_TOOL);
            view.addModifierTool(loader.load());
            loadTool(loader.getController(), tool, service);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void loadTool(ToolViewContract v, Tool<?> tool, ToolSetServices service){
        ToolServices toolUseCase = new ToolServices(tool);
        ToolPresenter presenter = new ToolPresenter(v, service, toolUseCase);
        v.setPresenter(presenter);
    }
    
}
