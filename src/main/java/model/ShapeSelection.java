package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import model.shapes.Shape;
import utils.ReadOnlyVect;
import utils.Vect;

public class ShapeSelection implements Iterable<Shape>{
    
    private List<Shape> initialShapeSelection;
    private final List<Shape> selection;
    private Vect dimens;
    private Vect pos;

    public ShapeSelection(){
        this.selection = new ArrayList<>();
        this.initialShapeSelection = new ArrayList<>();
        dimens = Vect.zero();
        pos = Vect.zero();
    }

    // set operations

    public void add(Shape... s){
        for (Shape e: s){
            selection.add(e);
        }
        updateInitialSelection();
        calcDimens();
        calcPos();
    }

    public void add(Collection<Shape> s){
        selection.addAll(s);
        updateInitialSelection();
        calcDimens();
        calcPos();
    }

    public boolean contains(Object o){
        return selection.contains(o);
    }

    public void remove(Shape o){
        selection.remove(o);
        updateInitialSelection();
        calcDimens();
        calcPos();
    }

    public void clear(){
        selection.clear();
        updateInitialSelection();
        calcDimens();
        calcPos();
    }

    public boolean isEmpty(){
        return selection.isEmpty();
    }

    @Override
    public Iterator<Shape> iterator() {
        return selection.iterator();
    }

    public int size(){
        return selection.size();
    }

    public String toString(){
        return selection.toString();
    }

    // selection operations

    public ReadOnlyVect getPos(){
        return new ReadOnlyVect(pos);
    }

    public ReadOnlyVect getDimens(){
        return new ReadOnlyVect(dimens);
    }

    public void setPos(ReadOnlyVect newPos){
        Vect offset = new Vect(newPos.getSub(pos));
        for(Shape s: selection){
            s.getPos().add(offset);
        }
        calcPos();
    }

    public void resize(ReadOnlyVect factor){
        for (int i = 0; i < selection.size(); i++){
            Vect posFromCenter = initialShapeSelection.get(i).getPos().getSub(pos);
            posFromCenter.mult(factor);

            selection.get(i).setPos(posFromCenter.add(pos));
            selection.get(i).setDimens(initialShapeSelection.get(i).getDimens().getMult(factor).abs());
        }
        calcDimens();
    }

    public void apply(){
        updateInitialSelection();
    }

    // private class operations

    private void calcDimens(){
        Bounds b = calcBounds();
        dimens.setX(b.right - b.left);
        dimens.setY(b.bottom - b.top);
    }

    private void calcPos(){
        Bounds b = calcBounds();
        pos.setX((b.left + b.right)/2);
        pos.setY((b.top + b.bottom)/2);
    }

    private Bounds calcBounds(){
        double top = 0;
        double left = 0;
        double right = 0;
        double bottom = 0;
        boolean initialized = false;
        for (Shape s: selection){
            if (initialized){
                if (s.getPos().y() - s.getDimens().y()/2 < top) {
                    top = s.getPos().y() - s.getDimens().y()/2;
                }
                if (s.getPos().x() - s.getDimens().x()/2 < left){ 
                    left = s.getPos().x() - s.getDimens().x()/2;
                }
                if (s.getPos().x() + s.getDimens().x()/2 > right) {
                    right = s.getPos().x() + s.getDimens().x()/2;
                }
                if (s.getPos().y() + s.getDimens().y()/2 > bottom) {
                    bottom = s.getPos().y() + s.getDimens().y()/2;
                }
            }else{
                top = s.getPos().y() - s.getDimens().y()/2;
                left = s.getPos().x() - s.getDimens().x()/2;
                right = s.getPos().x() + s.getDimens().x()/2;
                bottom = s.getPos().y() + s.getDimens().y()/2;
                initialized = true;
            }
        }
        return new Bounds(top, bottom, left, right);
    }

    private class Bounds{
        final double top;
        final double bottom;
        final double left;
        final double right;

        Bounds(double top, double bottom, double left, double right){
            this.top = top;
            this.bottom = bottom;
            this.left = left;
            this.right = right;
        }
    }

    private void updateInitialSelection(){
        initialShapeSelection = new ArrayList<>(selection.size());
        for (Shape s: selection){
            initialShapeSelection.add(s.duplicate());
        }
    }

}
