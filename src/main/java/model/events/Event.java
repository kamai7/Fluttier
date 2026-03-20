package model.events;

public abstract class Event<E> {
    
    protected final E event;

    protected Event(E e){
        this.event = e;
    }

    public E get(){
        return event;
    }

}
