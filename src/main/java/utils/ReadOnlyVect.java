package utils;

import java.util.Arrays;

public class ReadOnlyVect {

    protected double x;
    protected double y;

    public ReadOnlyVect(ReadOnlyVect v) {
        this(v.x, v.y);
    }

    public ReadOnlyVect(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public ReadOnlyVect(double a){
        this(a, a);
    }

    public static ReadOnlyVect zero(){
        return new ReadOnlyVect(0);
    }

    public double x(){
        return x;
    }

    public double y(){
        return y;
    }

    public Vect getMult(double n){
        return new Vect(x*n, y*n);
    }

    public Vect getMult(ReadOnlyVect v){
        return new Vect(x*v.x, y*v.y);
    }

    public Vect getDiv(double n){
        return new Vect(x/n, y/n);
    }

    public Vect getDiv(ReadOnlyVect v){
        return new Vect(x/v.x, y/v.y);
    }

    public Vect getAdd(ReadOnlyVect v){
        return new Vect(x+v.x, y+v.y);
    }

    public Vect getSub(ReadOnlyVect v){
        return new Vect(x-v.x, y-v.y);
    }

    public double getLength(){
        return Math.sqrt(x*x + y*y);
    }

    public Vect getNormalized(){
        double mag = getLength();
        return new Vect(x/mag, y/mag);
    }

    public Vect getAbs(){
        return new Vect(Math.abs(x), Math.abs(y));
    }

    @Override
    public String toString(){
        return "(x:" + x + ", y:" + y + ")";
    }

    @Override
    public int hashCode(){
        Object[] o = {x,y};
        return Arrays.deepHashCode(o);
    }

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof ReadOnlyVect)) return false;
        ReadOnlyVect casted = (ReadOnlyVect) o;
        return x == casted.x && y == casted.y;
    }
    
}
