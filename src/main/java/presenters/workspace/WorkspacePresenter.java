package presenters.workspace;

import contracts.workspace.WorkspaceNavigatorContract;
import contracts.workspace.WorkspaceViewContract;
import model.shapes.Shape;
import services.WorkspaceServices;
import services.tool.ToolSetServices;
import utils.Colors;

public class WorkspacePresenter {

    private final WorkspaceViewContract view;
    private final WorkspaceServices workspaceServices;
    private final WorkspaceNavigatorContract navigator;
    private final ToolSetServices toolSetServices;

    private boolean isSelection;

    public WorkspacePresenter(WorkspaceViewContract view, WorkspaceNavigatorContract navigator, WorkspaceServices workspaceServices, ToolSetServices toolSetServices){
        if (view == null) {
            throw new IllegalArgumentException(Colors.red("la vue est null"));
        }
        this.view = view;
        this.workspaceServices = workspaceServices;
        this.navigator = navigator;
        this.toolSetServices = toolSetServices;

        this.isSelection = false;
    }

    public void mousePressed(double x, double y){
        if (toolSetServices.isShapeTool()){
            Shape s = workspaceServices.drawUseCase(x, y);
            workspaceServices.setNewShapeUseCase(s);
            navigator.loadShape(s, workspaceServices, toolSetServices);
        }
    }

    public void mouseDragged(double x, double y){
        if (toolSetServices.isShapeTool()){
            workspaceServices.drawUseCase(x, y);
            workspaceServices.notifyNewShapeChangedUseCase();
        }
    }

    public void mouseReleased(){
        if (toolSetServices.isShapeTool()){
            workspaceServices.endUseCase();
            workspaceServices.setNewShapeUseCase(null);
        }
    }

    public void mouseClicked(){
        if (toolSetServices.isSelectTool()){

            if(workspaceServices.getSelectionUseCase().isEmpty()){
                if (isSelection){
                    navigator.removeSelection();
                    isSelection = false;
                }
            }else{
                if (!isSelection){
                    navigator.loadSelection(workspaceServices, toolSetServices);
                    isSelection = true;
                }
            }
        }
    }
    public void mouseClickedWorkspaceOnly(){
        if (toolSetServices.isSelectTool()){
            workspaceServices.clearSelection();
        }
    }

    public void onShiftKeyPressed(){
        if (toolSetServices.isSelectTool()){
            workspaceServices.setSelectMultiple();
        }
    }

    public void onShiftKeyReleased(){
        if (toolSetServices.isSelectTool()){
            workspaceServices.setSelectSingle();
        }
    }
}
