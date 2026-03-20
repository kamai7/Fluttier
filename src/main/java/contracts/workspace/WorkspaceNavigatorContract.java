package contracts.workspace;

import model.shapes.Shape;
import services.WorkspaceServices;
import services.tool.ToolSetServices;
import view.workspace.shapes.ShapeView;

public interface WorkspaceNavigatorContract {

    public void loadShape(Shape s, WorkspaceServices workspace, ToolSetServices toolsetServices);

    public void loadSelection(WorkspaceServices workspaceServices, ToolSetServices toolsetServices);

    public void removeSelection();

    public void removeShape(ShapeView<?> s);
    
}
