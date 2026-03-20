package model.events;
import model.tools.Togglable;

public class ToggleEvent extends Event<Enum<? extends Togglable>> {

    public ToggleEvent(Enum<? extends Togglable> e) {
        super(e);
    }

    public String toString(){
        return "ToggleEvent:" + event.toString();
    }
}
