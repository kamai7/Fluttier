package view;

import contracts.MainViewContract;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import presenters.MainPresenter;
import utils.Colors;

public class MainView implements MainViewContract{

    @FXML
    private Label logLabel,
                  statusLabel;

    @FXML
    private AnchorPane workspaceAnchorPane,
                       sidebarAnchorPane;

    @SuppressWarnings("unused")
    private MainPresenter presenter;
    
    @FXML
    private void initialize(){
        System.out.println("MainView initialized");
    }

    // ------------------------

    @FXML
    private void copyLogMessageAction(){
        System.out.println("copy log");
    }

    @FXML
    private void viewFullLogAction(){
        System.out.println("view log");
    }

    // ------------------------

    @Override
    public void setPresenter(MainPresenter presenter) {
        if (presenter == null){
            throw new IllegalArgumentException(Colors.red("le présenteur est null"));
        }
        this.presenter = presenter;
    }

    @Override
    public void setStatusText(String text) {
        statusLabel.setText(text);
    }

    @Override
    public void setLogInfo(String message) {
        logLabel.setTextFill(Color.rgb(170, 170, 170));
        logLabel.setText(message);
    }

    @Override
    public void setLogWarning(String message) {
        logLabel.setTextFill(Color.YELLOW);
        logLabel.setText(message);
    }

    @Override
    public void setLogError(String message) {
        logLabel.setTextFill(Color.RED);
        logLabel.setText(message);
    }

    public void setWorkspaceContent(Node node){
        workspaceAnchorPane.getChildren().add(node);
        AnchorPane.setBottomAnchor(node, 0.0);
        AnchorPane.setTopAnchor(node, 0.0);
        AnchorPane.setRightAnchor(node, 0.0);
        AnchorPane.setLeftAnchor(node, 0.0);
    }

    public void setSidebarContent(Node node){
        sidebarAnchorPane.getChildren().add(node);
        AnchorPane.setBottomAnchor(node, 0.0);
        AnchorPane.setTopAnchor(node, 0.0);
        AnchorPane.setRightAnchor(node, 0.0);
        AnchorPane.setLeftAnchor(node, 0.0);
    }

}
