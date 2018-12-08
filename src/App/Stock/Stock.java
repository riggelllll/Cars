package App.Stock;

import App.Cars.Car;
import App.Cars.Type.Type;

public class Stock implements Runnable{
    private Car car;
    private String name;
    private Type type;
    private boolean isEmpty;

    public Stock(String name, Type type) {
        this.name = name;
        this.type = type;
        isEmpty = true;
        car = null;
    }

    public void setCar(Car car){
        if (car == null) return;
        this.car = car;
        System.out.println("Машина " + this.car.getId() + " на складе " + type.toString());
        isEmpty = false;
    }

    public void loadCar(){
        if (car != null){
            while (car.getCurrentSize() != car.getMaxsize()){
                try {
                    car.setCurrentSize(10);
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            car.setEmpty(false);
            System.out.println("Машина " + car.getType() + " " + car.getId() +  " ЗАГРУЖЕНА и отправилась со склада");
            deleteCar();
            isEmpty = true;
        }
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public Car getCar() {
        return car;
    }

    public void deleteCar(){
        car = null;
    }

    public Type getType() {
        return type;
    }

    @Override
    public void run() {
        loadCar();
    }
}
