package model.shapes;

import java.util.Arrays;

import javafx.scene.paint.Color;
import utils.ReadOnlyVect;
import utils.Vect;

public class Ellipse extends Shape{

    private final Vect radius;

    public Ellipse(ReadOnlyVect pos, ReadOnlyVect radius , Color fill, double borderW, Color borderC) {
        super(pos, fill, borderW, borderC);
        this.radius = new Vect(radius);
    }

    @Override
    public String toString() {
        return "Circle [pos:" + pos + "]";
    }

    @Override
    public void setDimens(ReadOnlyVect v) {
        setRadius(v.getDiv(2));
    }

    public void setRadius(ReadOnlyVect v){
        if (v.x() < 0 || v.y() < 0){
            throw new IllegalArgumentException("the radius must be positive: " + v);
        }
        this.radius.copy(v);
    }

    @Override
    public ReadOnlyVect getDimens() {
        return new ReadOnlyVect(radius.getMult(2));
    }

    @Override
    public Ellipse duplicate() {
        return new Ellipse(pos, radius, fillColor, borderWidth, borderColor);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(hashTab(new Object[]{radius}));
    }
    
}
