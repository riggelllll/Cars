package App.Cars;

import App.Cars.Type.Size;
import App.Cars.Type.Type;

public class Car {
    private Type type;
    private Size size;
    private int currentSize;
    private int id;
    private boolean isEmpty;

    Car(Type type, Size size, int id){
        this.type = type;
        this.size = size;
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public Size getSize() {
        return size;
    }

    public int getId() {
        return id;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public int getCurrentSize() {
        return currentSize;
    }
}
