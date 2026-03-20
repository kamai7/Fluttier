package view.workspace.navigator;

import contracts.workspace.WorkspaceNavigatorContract;
import model.shapes.Shape;
import presenters.workspace.SelectionPresenter;
import presenters.workspace.ShapePresenter;
import services.ShapeServices;
import services.WorkspaceServices;
import services.tool.ToolSetServices;
import view.navigator.Navigator;
import view.workspace.SelectionView;
import view.workspace.ShapeMapper;
import view.workspace.WorkspaceView;
import view.workspace.shapes.ShapeView;

public class WorkspaceNavigator extends Navigator<WorkspaceView> implements WorkspaceNavigatorContract{

    private SelectionView selectionView;

    public WorkspaceNavigator(WorkspaceView view) {
        super(view);
    }

    @Override
    public void loadShape(Shape s, WorkspaceServices workspace, ToolSetServices toolsetServices) {
        ShapeView<? extends javafx.scene.shape.Shape> newView = ShapeMapper.map(s);
        view.addShape(newView);
        ShapeServices service = new ShapeServices(s);
        ShapePresenter presenter = new ShapePresenter(newView, service, workspace, toolsetServices);
        newView.setPresenter(presenter);
    }

    @Override
    public void loadSelection(WorkspaceServices workspaceServices, ToolSetServices toolsetServices) {
        selectionView = new SelectionView();
        SelectionPresenter presenter = new SelectionPresenter(selectionView, workspaceServices, toolsetServices);
        selectionView.setPresenter(presenter);
        view.addSelection(selectionView);
    }

    @Override
    public void removeSelection() {
        view.removeNode(selectionView);
    }

    @Override
    public void removeShape(ShapeView<?> s) {
        view.removeNode(s.getShapeView());
    }
}
