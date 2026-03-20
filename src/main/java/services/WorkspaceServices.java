package services;

import model.ShapeSelection;
import model.Workspace;
import model.events.PosEvent;
import model.events.ShapeEvent;
import model.events.ToggleEvent;
import model.shapes.Shape;
import model.tools.SelectTool;
import utils.Colors;
import utils.listener.*;

public class WorkspaceServices {

    private final Workspace model;
    private final Subject<ShapeSelection> selectionListener;
    private final Subject<Shape> newShapeListener;

    public WorkspaceServices(Workspace model){
        if (model == null){
            throw new IllegalArgumentException(Colors.red("the given workspace is null"));
        }
        this.model = model;
        this.selectionListener = new Subject<>(model.getSelection());
        this.newShapeListener = new Subject<>();
    }

    // events

    public Shape drawUseCase(double x, double y){
        posEvent(x, y);
        return model.getShapes().getLast();
    }

    public void resizeUseCase(double x, double y){
        posEvent(x, y);
        selectionListener.changed();
    }

    public void moveUseCase(double x, double y){
        posEvent(x, y);
        selectionListener.changed();
    }

    public void endUseCase(){
        model.getTool().close();
    }

    private void posEvent(double x, double y){
        PosEvent e = new PosEvent(x,y);
        model.getTool().execute(e);
    }

    // getters

    public ShapeSelection getSelectionUseCase(){
        return selectionListener.get();
    }

    public Workspace getWorkspaceUseCase(){
        return model;
    }

    // listeners

    public void selectShapeUseCase(Shape s){
        ShapeEvent e = new ShapeEvent(s);
        model.getTool().execute(e);
        selectionListener.changed();
    }

    public void clearSelection(){
        model.getSelection().clear();
        selectionListener.changed();
    }

    public void addSelectionListener(Observer<ShapeSelection> o){
        selectionListener.addObserver(o);
    }

    public void addNewShapeListener(Observer<Shape> o){
        newShapeListener.addObserver(o);
    }

    public void removeNewShapeObserver(Observer<Shape> o){
        newShapeListener.removeObserver(o);
    }

    public void setNewShapeUseCase(Shape s){
        newShapeListener.set(s);
    }

    public void notifyNewShapeChangedUseCase(){
        newShapeListener.changed();
    }

    // setters

    public void setSelectMultiple(){
        ToggleEvent e = new ToggleEvent(SelectTool.SelectionMode.MULTIPLE);
        model.getTool().execute(e);
    }

    public void setSelectSingle(){
        ToggleEvent e = new ToggleEvent(SelectTool.SelectionMode.SINGLE);
        model.getTool().execute(e);
    }
    
}
