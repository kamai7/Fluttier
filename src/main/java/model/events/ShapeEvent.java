package model.events;

import model.shapes.Shape;

public class ShapeEvent extends Event<Shape> {

    public ShapeEvent(Shape e) {
        super(e);
    }

    public String toString(){
        return "ShapeEvent:" + event.toString();
    }
    
}
