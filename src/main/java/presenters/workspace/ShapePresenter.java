package presenters.workspace;

import contracts.workspace.shapes.ShapeViewContract;
import model.ShapeSelection;
import model.shapes.Shape;
import services.ShapeServices;
import services.WorkspaceServices;
import services.tool.ToolSetServices;
import utils.ReadOnlyVect;
import utils.listener.Observer;

public class ShapePresenter {
    
    protected final ShapeViewContract view;
    protected final ShapeServices services;
    protected final ToolSetServices toolSetServices;
    protected final WorkspaceServices workspaceServices;

    protected Observer<Shape> newShapeListener;

    public ShapePresenter(ShapeViewContract view, ShapeServices services, WorkspaceServices workspaceServices, ToolSetServices toolSetServices){
        this.view = view;
        this.toolSetServices = toolSetServices;
        this.services = services;
        this.workspaceServices = workspaceServices;

        Shape s = services.getShapeUseCase();
        ReadOnlyVect dimens = s.getDimens();
        ReadOnlyVect pos = s.getPos();
        view.setdimens(dimens.x(), dimens.y());
        view.setPos(pos.x(), pos.y());
        view.setBorderColor(s.getBordeColor());
        view.setBorderWidth(s.getBorderWidth());
        view.setFill(s.getFillColor());

        newShapeListener = new Observer<Shape>() {

            @Override
            public void onChange(Shape t) {
                onShapeChanged(s);
            }
            
        };
        
        workspaceServices.addSelectionListener(this::onSelectedShapeChanged);
        workspaceServices.addNewShapeListener(newShapeListener);
    }

    private void onSelectedShapeChanged(ShapeSelection selection){
        if (selection.contains(services.getShapeUseCase())){
            ReadOnlyVect pos = services.getShapeUseCase().getPos();
            ReadOnlyVect dimens = services.getShapeUseCase().getDimens();
            view.setPos(pos.x(), pos.y());
            view.setdimens(dimens.x(), dimens.y());
        }
    }

    private void onShapeChanged(Shape s){
        if(s == null){
            workspaceServices.removeNewShapeObserver(newShapeListener);
        }else{
            ReadOnlyVect dimens = services.getShapeUseCase().getDimens();
            view.setdimens(dimens.x(), dimens.y());
        }
    }

    public void clicked(){
        if (toolSetServices.isSelectTool()){
            workspaceServices.selectShapeUseCase(services.getShapeUseCase());
        }
    }

}
