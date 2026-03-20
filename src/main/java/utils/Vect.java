package utils;

public class Vect extends ReadOnlyVect{

    public Vect(double x, double y){
        super(x, y);
    }

    public Vect(ReadOnlyVect v){
        super(v);
    }

    public Vect(double a){
        super(a);
    }

    public static Vect zero(){
        return new Vect(0);
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public Vect mult(double n){
        x *= n;
        y *= n;
        return this;
    }

    public Vect mult(ReadOnlyVect v){
        x *= v.x;
        y *= v.y;
        return this;
    }

    public Vect div(double n){
        x /= n;
        y /= n;
        return this;
    }

    public Vect div(ReadOnlyVect v){
        x /= v.x;
        y /= v.y;
        return this;
    }

    public Vect add(ReadOnlyVect v){
        x += v.x;
        y += v.y;
        return this;
    }

    public Vect sub(ReadOnlyVect v){
        x -= v.x;
        y -= v.y;
        return this;
    }

    public Vect normalize(){
        double mag = getLength();
        x /= mag;
        y /= mag;
        return this;
    }

    public Vect abs(){
        x = Math.abs(x);
        y = Math.abs(y);
        return this;
    }

    public void copy(ReadOnlyVect v){
        this.x = v.x;
        this.y = v.y;
    }
}