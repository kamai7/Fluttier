package model.shapes;

import javafx.scene.paint.Color;
import utils.Colors;
import utils.ReadOnlyVect;
import utils.Vect;

public abstract class Shape {

    protected final Vect pos;
    protected Color fillColor;
    protected double borderWidth;
    protected Color borderColor;

    protected Shape(ReadOnlyVect pos, Color fill, double borderW, Color borderC){
        this.pos = new Vect(pos);
        this.fillColor = fill;
        this.borderWidth = borderW;
        this.borderColor = borderC;
    }


    public Vect getPos(){
        return pos;
    }

    public void setPos(ReadOnlyVect v){
        this.pos.copy(v);
    }

    public Color getFillColor(){
        return fillColor;
    }

    public double getBorderWidth(){
        return borderWidth;
    }

    public Color getBordeColor(){
        return borderColor;
    }

    public void setFillColor(Color c){
        if (c == null) {
            throw new IllegalArgumentException(Colors.red("La couleur est nulle"));
        }
        this.fillColor = c;
    }

    public abstract String toString();

    public abstract void setDimens(ReadOnlyVect d);

    public abstract ReadOnlyVect getDimens();
    
    @Override
    public abstract int hashCode();

    protected Object[] hashTab(Object[] toAdd){
        Object[] current = {pos, fillColor, borderWidth, borderColor};
        Object[] ret = new Object[current.length + toAdd.length];
        
        for (int i = 0; i < current.length; i++){
            ret[i] = current[i];
        }
        for (int i = 0; i < toAdd.length; i++){
            ret[current.length + i - 1] = toAdd[i];
        }
        return ret;
    }

    public abstract <S extends Shape> S duplicate();
}
