package view.workspace.shapes;

import contracts.workspace.shapes.EllipseViewContract;
import javafx.scene.shape.Ellipse;
import view.workspace.shapes.EllipseView.FXCircleView;

public class EllipseView extends ShapeView<FXCircleView> implements EllipseViewContract{

    public EllipseView(){
        super(new FXCircleView());
    }

    public static class FXCircleView extends Ellipse{
        public FXCircleView(){
            super(0,0);
        }
    }

    @Override
    public void setdimens(double w, double h) {
        view.setRadiusX(w/2);
        view.setRadiusY(h/2);
    }

    @Override
    public void setR(double r) {
        setdimens(r, r);
    }
    
}
