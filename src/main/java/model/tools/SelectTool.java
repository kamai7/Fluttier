package model.tools;

import model.ShapeSelection;
import references.Icons;
import model.events.PosEvent;
import model.events.ShapeEvent;
import model.events.ToggleEvent;

public class SelectTool extends Tool<ShapeSelection>{

    protected SelectionMode selectionMode;

    public SelectTool(ShapeSelection property) {
        super(property);
        selectionMode = SelectionMode.SINGLE;
    }

    @Override
    public void execute(ShapeEvent event) {
        if (selectionMode == SelectionMode.SINGLE) {
            property.clear();
        }
        if (property.contains(event.get())){
            property.remove(event.get());
        }else{
            property.add(event.get());
        }
        
    }

    @Override
    public void execute(PosEvent event) {
        
    }

    @Override
    public void execute(ToggleEvent event) {
        if (event.get() instanceof SelectionMode) {
            selectionMode = (SelectionMode) event.get();
        }
    }

    @Override
    public void close() {}

    @Override
    public String getName() {
        return "select";
    }

    @Override
    public Icons getIcon() {
        return Icons.SELECT_TOOL;
    }

    public enum SelectionMode implements Togglable{
        SINGLE,
        MULTIPLE
    }

}
