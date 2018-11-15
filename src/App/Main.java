package App;

import App.Tasks.CarGenerator;

public class Main {

    public static void main(String[] args) {

        CarGenerator gen = new CarGenerator(10);
        gen.generateCars();
        System.out.println(gen.getCars());
    }
}
