package view.toolPanel;

import contracts.toolPanel.ToolPanelViewContract;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import presenters.toolPanel.ToolPanelPresenter;
import utils.Colors;

public class ToolPanelView implements ToolPanelViewContract{

    @FXML
    private ScrollPane modifiersScrollPane;

    @FXML
    private FlowPane modifiersFlowPane;
                       

    @FXML
    private VBox shapeVBox;

    private ToolPanelPresenter presenter;

    @FXML
    private void initialize() {
        System.out.println("sidebar view initialized");
        modifiersFlowPane.prefWidthProperty().bind(modifiersScrollPane.widthProperty());
    }

    public void addShapeTool(Node node){
        shapeVBox.getChildren().add(node);
        shapeVBox.getChildren().add(new Separator());
    }

    public void addModifierTool(Node node){
        modifiersFlowPane.getChildren().add(node);
    }

    // ---------------------------------

    // ---------------------------------

    @Override
    public void setPresenter(ToolPanelPresenter presenter) {
        if (presenter == null){
            throw new IllegalArgumentException(Colors.red("le présenteur est null"));
        }
        this.presenter = presenter;
    }
    
}