package view.workspace;

import java.util.ArrayList;
import java.util.List;

import contracts.workspace.SelectionViewContract;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import presenters.workspace.SelectionPresenter;
import view.nodes.CenteredPane;
import view.workspace.shapes.ShapeView;


public class SelectionView extends CenteredPane implements SelectionViewContract{

    private final Pane shapePane;
    private Pane workspace;
    private final List<Node> handles;

    private SelectionPresenter presenter;

    public SelectionView() {
        getStyleClass().add("shape_container");

        shapePane = new Pane();
        shapePane.getStyleClass().add("shape-box");
        StackPane.setAlignment(shapePane, Pos.CENTER);
        StackPane.setMargin(shapePane, new Insets(5, 5, 5, 5));

        shapePane.setOnMouseDragged(this::shapeDragged);
        shapePane.setOnMousePressed(this::onMousePressedOnShape);
        shapePane.setOnMouseReleased(this::onMouseReleasedOnShape);

        handles = createResizeHandles();
        getChildren().add(shapePane);
        StackPane.setAlignment(shapePane, Pos.CENTER);
        getChildren().addAll(handles);
    }

    private List<Node> createResizeHandles() {
        List<Node> handles = new ArrayList<>(8);
        handles.add(createHandle(Cursor.NW_RESIZE, Pos.TOP_LEFT, this::topLeftDragged));
        handles.add(createHandle(Cursor.S_RESIZE, Pos.TOP_CENTER, this::topDragged));
        handles.add(createHandle(Cursor.SW_RESIZE, Pos.TOP_RIGHT, this::topRightDragged));
        handles.add(createHandle(Cursor.W_RESIZE, Pos.CENTER_LEFT, this::leftDragged));
        handles.add(createHandle(Cursor.W_RESIZE, Pos.CENTER_RIGHT, this::rightDragged));
        handles.add(createHandle(Cursor.SW_RESIZE, Pos.BOTTOM_LEFT, this::bottomLeftDragged));
        handles.add(createHandle(Cursor.S_RESIZE, Pos.BOTTOM_CENTER, this::bottomDragged));
        handles.add(createHandle(Cursor.NW_RESIZE, Pos.BOTTOM_RIGHT, this::bottomRightDragged));
        return handles;
    }

    public void setWorkspace(Pane workspace){
        this.workspace = workspace;
    }

    private Pane createHandle(Cursor cursor, Pos alignment, EventHandler<MouseEvent> handler) {
        Pane pane = new Pane();
        pane.getStyleClass().add("resize-marker");
        pane.setCursor(cursor);
        pane.setOnMouseDragged(handler);
        pane.setOnMousePressed(this::onMousePressedOnResize);
        pane.setOnMouseReleased(this::onMouseReleasedOnResize);
        StackPane.setAlignment(pane, alignment);
        return pane;
    }

    // Event handlers placeholders
    private void shapeDragged(MouseEvent event) {
        if(checkClick(event)){
            Point2D workspacePos = workspace.sceneToLocal(event.getSceneX(), event.getSceneY());
            presenter.dragged(workspacePos.getX(), workspacePos.getY());
        }
    }

    private void topLeftDragged(MouseEvent event) {
        if(checkClick(event)){
            Point2D workspacePos = workspace.sceneToLocal(event.getSceneX(), event.getSceneY());
            presenter.cornerResizeDragged(workspacePos.getX(), workspacePos.getY());
        }
    }

    private void topDragged(MouseEvent event) {
        if(checkClick(event)){
            Point2D workspacePos = workspace.sceneToLocal(event.getSceneX(), event.getSceneY());
            presenter.verticalResizeDragged(workspacePos.getX(), workspacePos.getY());
        }
    }

    private void topRightDragged(MouseEvent event) {
        if(checkClick(event)){
            Point2D workspacePos = workspace.sceneToLocal(event.getSceneX(), event.getSceneY());
            presenter.cornerResizeDragged(workspacePos.getX(), workspacePos.getY());
        }
    }

    private void leftDragged(MouseEvent event) {
        if(checkClick(event)){
            Point2D workspacePos = workspace.sceneToLocal(event.getSceneX(), event.getSceneY());
            presenter.horizontalResizeDragged(workspacePos.getX(), workspacePos.getY());
        }
    }

    private void rightDragged(MouseEvent event) {
        if(checkClick(event)){
            Point2D workspacePos = workspace.sceneToLocal(event.getSceneX(), event.getSceneY());
            presenter.horizontalResizeDragged(workspacePos.getX(), workspacePos.getY());
        }
    }

    private void bottomLeftDragged(MouseEvent event) {
        if(checkClick(event)){
            Point2D workspacePos = workspace.sceneToLocal(event.getSceneX(), event.getSceneY());
            presenter.cornerResizeDragged(workspacePos.getX(), workspacePos.getY());
        }
    }

    private void bottomDragged(MouseEvent event) {
        if(checkClick(event)){
            Point2D workspacePos = workspace.sceneToLocal(event.getSceneX(), event.getSceneY());
            presenter.verticalResizeDragged(workspacePos.getX(), workspacePos.getY());
        }
    }

    private void bottomRightDragged(MouseEvent event) {
        if(checkClick(event)){
            Point2D workspacePos = workspace.sceneToLocal(event.getSceneX(), event.getSceneY());
            presenter.cornerResizeDragged(workspacePos.getX(), workspacePos.getY());
        }
    }

    private void onMousePressedOnResize(MouseEvent e){
        if(checkClick(e)){
            presenter.resizePressed();
        }
    }

    private void onMouseReleasedOnResize(MouseEvent e){
        if(checkClick(e)){
            presenter.resizeReleased();
        }
    }

    private void onMousePressedOnShape(MouseEvent e){
        if(checkClick(e)){
            presenter.contentPressed();
        }
    }

    private void onMouseReleasedOnShape(MouseEvent e){
        if(checkClick(e)){
            presenter.contentReleased();
        }
    }

    private boolean checkClick(MouseEvent e){
        return e.getButton() == MouseButton.PRIMARY;
    }
    /* 
    public void addShape(ShapeView<?> s){
        
        s.setLayoutX(s.getLayoutX());
        s.setLayoutY(s.getLayou);
        shapePane.getChildren().add(s);
    }*/

    @Override
    public void setDimens(double w, double h) {
        shapePane.setPrefWidth(w + 10);
        shapePane.setPrefHeight(h + 10);
    }

    @Override
    public void setPresenter(SelectionPresenter presenter) {
        this.presenter = presenter;
    }
}
