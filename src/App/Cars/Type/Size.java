package App.Cars.Type;

public enum Size {

    SMALL(20), MIDDLE(50), LARGE(100);

    private int size;

    Size(int size){
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
