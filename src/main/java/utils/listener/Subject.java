package utils.listener;

import java.util.HashSet;
import java.util.Set;

import utils.Colors;

public class Subject<T> {
    
    protected final Set<Observer<T>> observers;
    protected T value;

    public Subject(T initialValue){
        if (initialValue == null){
            throw new IllegalArgumentException(Colors.red("one of these given observer was actually null"));
        }
        this.observers = new HashSet<>();
        this.value = initialValue;
    }

    public Subject(){
        this.observers = new HashSet<>();
    }

    public void addObserver(Observer<T> o){
        if (o == null){
            throw new IllegalArgumentException(Colors.red("the given observer is actually null"));
        }
        observers.add(o);
    }

    public void removeObserver(Observer<T> o){
        if (o == null){
            throw new IllegalArgumentException(Colors.red("the given observer is actually null"));
        }
        observers.remove(o);
    }

    public void changed(){
        for(Observer<T> o: observers){
            o.onChange(value);
        }
    }

    public void set(T newValue){
        this.value = newValue;
        for(Observer<T> o: observers){
            o.onChange(value);
        }
    }

    public T get(){
        return value;
    }

}
