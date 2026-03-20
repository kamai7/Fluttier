package view.workspace.shapes;

import javafx.scene.shape.Rectangle;
import view.workspace.shapes.RectangleView.FXRectangleView;

public class RectangleView extends ShapeView<FXRectangleView> {

    public RectangleView(){
        super(new FXRectangleView());
    }

    public static class FXRectangleView extends Rectangle {
        public FXRectangleView(){
            super(0, 0);
        }
    }

    @Override
    public void setdimens(double w, double h) {
        view.setWidth(w);
        view.setHeight(h);
    }
    
}
