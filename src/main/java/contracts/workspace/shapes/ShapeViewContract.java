package contracts.workspace.shapes;

import javafx.scene.paint.Color;
import presenters.workspace.ShapePresenter;

public interface ShapeViewContract {

    public void setPresenter(ShapePresenter p);
    
    public void setdimens(double w, double h);

    public void setPos(double x, double y);

    public void setFill(Color c);

    public void setBorderColor(Color c);

    public void setBorderWidth(double w);

    public double getWidth();

    public double getHeight();

    public double getX();

    public double getY();
    
}
