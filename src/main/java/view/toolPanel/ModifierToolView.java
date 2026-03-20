package view.toolPanel;

import contracts.toolPanel.ToolViewContract;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import presenters.toolPanel.ToolPresenter;
import references.Icons;
import view.references.IconsReferences;

public class ModifierToolView implements ToolViewContract{

    @FXML
    private ImageView toolImageView;

    @FXML
    private Tooltip toolToolTip;

    @FXML
    private Button toolButton;

    private ToolPresenter presenter;

    @FXML
    private void initialize(){
        System.out.println("Modifier tool initialized");
        toolToolTip.setShowDelay(Duration.seconds(0.5));
        toolButton.getStyleClass().add("fragment-bordered-unactive");
    }

    @FXML
    private void toolClicked(){
        presenter.onMouseClicked();
    }


    @Override
    public void setPresenter(ToolPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setName(String name) {
        toolToolTip.setText(name);
    }

    @Override
    public void setIcon(Icons icon) {
        Image img = IconsReferences.get(icon);
        toolImageView.setImage(img);
    }

    @Override
    public void setSelected() {
        toolButton.getStyleClass().removeAll("fragment-bordered-unactive");
        toolButton.getStyleClass().add("fragment-active");
    }

    @Override
    public void setUnselected() {
        toolButton.getStyleClass().removeAll("fragment-active");
        toolButton.getStyleClass().add("fragment-bordered-unactive");
    }
    
}
