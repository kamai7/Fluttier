package model.events;

import utils.ReadOnlyVect;

public class PosEvent extends Event<ReadOnlyVect>{

    public PosEvent(double x, double y) {
        super(new ReadOnlyVect(x, y));
    }

    public PosEvent(ReadOnlyVect v) {
        super(v);
    }

    public String toString(){
        return "PosEvent:" + event.toString();
    }
    
}
