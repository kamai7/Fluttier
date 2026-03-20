package model.tools;

import references.Icons;
import model.events.PosEvent;
import model.events.ShapeEvent;
import model.events.ToggleEvent;

public abstract class Tool<P> {

    protected final P property;

    public Tool(P property){
        if (property == null){
            throw new IllegalArgumentException("the property cannot be null");
        }
        this.property = property;
    }

    public abstract void execute(PosEvent event);

    public abstract void execute(ShapeEvent event);

    public abstract void execute(ToggleEvent event);

    public abstract void close();

    public abstract String getName();

    public abstract Icons getIcon();
    
}
