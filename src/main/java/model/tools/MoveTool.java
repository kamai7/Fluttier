package model.tools;

import model.ShapeSelection;
import model.events.PosEvent;
import model.events.ShapeEvent;
import model.events.ToggleEvent;
import references.Icons;
import utils.ReadOnlyVect;

public class MoveTool extends Tool<ShapeSelection>{
    private ReadOnlyVect cursorDistance = null;

    public MoveTool(ShapeSelection property) {
        super(property);
    }

    @Override
    public void execute(PosEvent event) {
        if (cursorDistance == null){
            cursorDistance = event.get().getSub(property.getPos());
        }
        property.setPos(event.get().getSub(cursorDistance));
    }

    @Override
    public void execute(ShapeEvent event) {}

    @Override
    public void execute(ToggleEvent event) {}

    @Override
    public void close() {
        cursorDistance = null;
    }

    @Override
    public String getName() {
        return "move";
    }

    @Override
    public Icons getIcon() {
        return Icons.MOVE_TOOL;
    }
    
}
