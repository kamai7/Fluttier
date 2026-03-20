package view.toolPanel;

import contracts.toolPanel.ToolViewContract;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import presenters.toolPanel.ToolPresenter;
import references.Icons;
import view.references.IconsReferences;

public class ShapeToolView implements ToolViewContract{

    @FXML
    private ImageView iconImageView;

    @FXML
    private Label nameLabel;

    @FXML
    private HBox shapeToolHBox;

    private ToolPresenter presenter;

    // -----------------------

    @FXML
    private void initialize() {
        System.out.println("sidebar shape view item initalized");
        shapeToolHBox.getStyleClass().add("fragment-unactive");
    }

    // ---------------------

    @FXML
    private void onMouseClicked(MouseEvent event){
        if(event.getButton() == MouseButton.PRIMARY){
            presenter.onMouseClicked();
            event.consume();
        }
    }

    @Override
    public void setPresenter(ToolPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setName(String name) {
        nameLabel.setText(name);
    }

    @Override
    public void setIcon(Icons icon) {
        iconImageView.setImage(IconsReferences.get(icon));
    }

    @Override
    public void setSelected() {
        shapeToolHBox.getStyleClass().removeAll("fragment-unactive");
        shapeToolHBox.getStyleClass().add("fragment-active");
    }

    @Override
    public void setUnselected() {
        shapeToolHBox.getStyleClass().removeAll("fragment-active");
        shapeToolHBox.getStyleClass().add("fragment-unactive");
    }
    
    
}
