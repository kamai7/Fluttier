package view.nodes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.StackPane;

public class CenteredPane extends StackPane{

    private final DoubleProperty posX;
    private final DoubleProperty posY;

    public CenteredPane(){
        this.posX = new SimpleDoubleProperty();
        this.posY = new SimpleDoubleProperty();
        layoutXProperty().bind(posX.subtract(widthProperty().divide(2)));
        layoutYProperty().bind(posY.subtract(heightProperty().divide(2)));
    }

    public void setPos(double x, double y) {
        posX.set(x);
        posY.set(y);
    }

    public double getX(){
        return posX.get();
    }

    public double getY(){
        return posY.get();
    }
    
}
