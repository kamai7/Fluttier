package view.workspace.shapes;

import contracts.workspace.shapes.ShapeViewContract;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import presenters.workspace.ShapePresenter;
import utils.Colors;
import view.nodes.CenteredPane;

public abstract class ShapeView<S extends Shape> extends CenteredPane implements ShapeViewContract{

    protected final S view;
    protected ShapePresenter presenter;

    public ShapeView(S view){
        setPrefHeight(USE_COMPUTED_SIZE);
        setPrefWidth(USE_COMPUTED_SIZE);
        getChildren().add(view);
        StackPane.setAlignment(view, Pos.CENTER);

        this.view = view;

        view.setOnMouseClicked(this::onMouseClicked);
    }

    private void onMouseClicked(MouseEvent event){
        if (event.getButton() == MouseButton.PRIMARY && event.getTarget() == view){
            presenter.clicked();
        }
    }

    public void setContent(Node node){
        getChildren().clear();
        getChildren().add(node);
        StackPane.setAlignment(node, Pos.CENTER);
    }

    public S getShapeView(){
        return view;
    }

    @Override
    public void setFill(Color c) {
        view.setFill(c);
    }

    @Override
    public void setBorderColor(Color c){
        view.setStroke(c);
    }

    @Override
    public void setBorderWidth(double w){
        view.setStrokeWidth(w);
    }


    @Override
    public void setPresenter(ShapePresenter p) {
        if (p == null){
            throw new IllegalArgumentException(Colors.red("presenter is null"));
        }
        this.presenter = p;
    }
}
