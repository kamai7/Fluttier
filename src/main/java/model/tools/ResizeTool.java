package model.tools;

import model.ShapeSelection;
import model.events.PosEvent;
import model.events.ShapeEvent;
import model.events.ToggleEvent;
import references.Icons;
import utils.ReadOnlyVect;
import utils.Vect;

public class ResizeTool extends Tool<ShapeSelection> {

    private ReadOnlyVect startPos;

    public ResizeTool(ShapeSelection property) {
        super(property);
    }

    @Override
    public void execute(PosEvent event) {
        if (startPos == null){
            startPos = new ReadOnlyVect(event.get());
        }

        Vect factor = event.get().getSub(property.getPos());
        factor.div(startPos.getSub(property.getPos()));

        property.resize(factor);
    }

    @Override
    public void execute(ShapeEvent event) {}

    @Override
    public void execute(ToggleEvent event) {}

    @Override
    public void close() {
        property.apply();
        startPos = null;
    }

    @Override
    public String getName() {
        return "resize";
    }

    @Override
    public Icons getIcon() {
        return Icons.RESIZE_TOOL;
    }

}
