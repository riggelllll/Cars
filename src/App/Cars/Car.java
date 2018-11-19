package App.Cars;

import App.Cars.Type.Size;
import App.Cars.Type.Type;

public class Car {
    private Type type;
    private Size maxSize;
    private int currentSize;
    private int id;
    private boolean isEmpty;

    public Car(Type type, Size size, int id){
        this.type = type;
        this.maxSize = size;
        this.id = id;
        isEmpty = true;
        currentSize = 0;
    }

    public Type getType() {
        return type;
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

    public void setCurrentSize(int currentSize) {
        this.currentSize+= currentSize;
    }

    public int getMaxsize() {
        return maxSize.getSize();
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
