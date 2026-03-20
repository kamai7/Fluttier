package model.shapes;

import java.util.Arrays;

import javafx.scene.paint.Color;
import utils.Colors;
import utils.ReadOnlyVect;
import utils.Vect;

public class Rectangle extends Shape{

    private final Vect dimens;

    public Rectangle(ReadOnlyVect pos, ReadOnlyVect dimens, Color fill, double borderW, Color borderC) {
        super(pos, fill, borderW, borderC);
        this.dimens = new Vect(dimens);
    }

    @Override
    public void setDimens(ReadOnlyVect d){
        if (d == null){
            throw new IllegalArgumentException(Colors.red("the dimens vector is null"));
        }
        this.dimens.copy(d);
    }

    @Override
    public ReadOnlyVect getDimens() {
        return new ReadOnlyVect(dimens);
    }

    @Override
    public String toString() {
        return "Rectangle [pos:" + pos + "]";
    }

    @Override
    public Rectangle duplicate() {
        return new Rectangle(pos, dimens, fillColor, borderWidth, borderColor);
    }
    
    @Override
    public int hashCode() {
        return Arrays.deepHashCode(hashTab(new Object[]{dimens}));
    }
}
