package services;

import model.shapes.Shape;

public class ShapeServices {

    private final Shape model;
    
    public ShapeServices(Shape model){
        this.model = model;
    }

    public Shape getShapeUseCase(){
        return model;
    } 
    
}
