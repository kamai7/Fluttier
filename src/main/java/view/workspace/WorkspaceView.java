package view.workspace;

import contracts.workspace.WorkspaceViewContract;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import presenters.workspace.WorkspacePresenter;
import utils.Colors;

public class WorkspaceView implements WorkspaceViewContract{

    @FXML
    private Pane workspacePane;

    private WorkspacePresenter presenter;

    @FXML
    private void initialize(){
        System.out.println("workspace view initialized");
    }

    // --------------------

    public void initKeyListeners(){
        workspacePane.getScene().addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent k) {
                if (k.getCode() == KeyCode.SHIFT){
                    presenter.onShiftKeyPressed();
                }
            }
        });

        workspacePane.getScene().addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent k) {
                if (k.getCode() == KeyCode.SHIFT){
                    presenter.onShiftKeyReleased();
                }
            }
        });
    }

    @FXML
    private void onMousePressed(MouseEvent event){
        if (event.getButton() == MouseButton.PRIMARY){
            presenter.mousePressed(event.getX(), event.getY());
        }
    }

    @FXML
    private void onMouseDragged(MouseEvent event){
        if (event.getButton() == MouseButton.PRIMARY){
            presenter.mouseDragged(event.getX(), event.getY());
        }
    }

    @FXML
    private void onMouseReleased(MouseEvent event){
        if (event.getButton() == MouseButton.PRIMARY){
            presenter.mouseReleased();
        }
    }

    @FXML
    private void onMouseClicked(MouseEvent event){
        if (event.getButton() == MouseButton.PRIMARY && event.getTarget() == workspacePane){
            presenter.mouseClickedWorkspaceOnly();
        }
        if (event.getButton() == MouseButton.PRIMARY){
            presenter.mouseClicked();
        }
    }

    // --------------------

    public void addShape(Node node){
        workspacePane.getChildren().add(node);
    }

    public void removeNode(Node node){
        workspacePane.getChildren().remove(node);
    }

    public void addSelection(SelectionView node){
        workspacePane.getChildren().add(0, node);
        node.setWorkspace(workspacePane);
    }

    @Override
    public void setPresenter(WorkspacePresenter presenter) {
        if (presenter == null){
            throw new IllegalArgumentException(Colors.red("le présenteur est null"));
        }
        this.presenter = presenter;
    }
    
}
