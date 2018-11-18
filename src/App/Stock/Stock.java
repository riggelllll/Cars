package App.Stock;

import App.Cars.Car;
import App.Cars.Type.Type;

public class Stock {
    private Car car;
    private String name;
    private Type type;
    private boolean isEmpty;

    public Stock(String name, Type type) {
        this.name = name;
        this.type = type;
        isEmpty = true;
    }

    public void setCar(Car car){
        this.car = car;
    }

    public synchronized void loadCar() throws InterruptedException {
        while (car.getCurrentSize() != car.getMaxsize()){
            car.setCurrentSize(10);
            Thread.sleep(1000);
        }
        System.out.println("Машина " + car.getType() + " " + car.getSize() +  " ЗАГРУЖЕНА и отправилась со склада");
        car = null;
    }




}
