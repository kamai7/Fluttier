package presenters.workspace;

import contracts.workspace.SelectionViewContract;
import model.ShapeSelection;
import services.WorkspaceServices;
import services.tool.ToolSetServices;
import utils.ReadOnlyVect;

public class SelectionPresenter {

    private final SelectionViewContract view;
    private final WorkspaceServices services;
    private final ToolSetServices toolSetServices;

    public SelectionPresenter(SelectionViewContract view, WorkspaceServices services, ToolSetServices toolSetServices){
        this.view = view;
        this.services = services;
        this.toolSetServices = toolSetServices;

        ShapeSelection selection = services.getSelectionUseCase();
        view.setPos(selection.getPos().x(), selection.getPos().y());
        view.setDimens(selection.getDimens().x(), selection.getDimens().y());
        services.addSelectionListener(this::onSelectionChanged);
    }

    private void onSelectionChanged(ShapeSelection selection){
        view.setPos(selection.getPos().x(), selection.getPos().y());
        view.setDimens(selection.getDimens().x(), selection.getDimens().y());
    }

    public void cornerResizeDragged(double x, double y){
        services.resizeUseCase(x, y);
    }

    public void verticalResizeDragged(double x, double y){
        ReadOnlyVect pos = services.getSelectionUseCase().getPos();
        ReadOnlyVect dimens = services.getSelectionUseCase().getDimens();
        services.resizeUseCase(pos.getSub(pos.getAdd(dimens.getDiv(2))).abs().x(), y);        
    }

    public void horizontalResizeDragged(double x, double y){
        
        ReadOnlyVect pos = services.getSelectionUseCase().getPos();
        ReadOnlyVect dimens = services.getSelectionUseCase().getDimens();
        services.resizeUseCase(x, pos.getSub(pos.getAdd(dimens.getDiv(2))).abs().y());
    }

    public void dragged(double x, double y){
        services.moveUseCase(x, y);
    }

    public void resizePressed(){
        if (!toolSetServices.isMoveToolTool()){
            toolSetServices.selectResizeTool();
        }
    }

    public void resizeReleased(){
        services.endUseCase();
    }

    public void contentPressed(){
        if (!toolSetServices.isMoveToolTool()){
            toolSetServices.selectMoveTool();
        }
    }

    public void contentReleased(){
        if (!toolSetServices.isSelectTool()){
            services.endUseCase();
            toolSetServices.selectSelectTool();
        }
    }
    
}
