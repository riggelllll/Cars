package App;

import App.Cars.Car;
import App.Cars.Type.Type;
import App.Tasks.CarGenerator;
import App.Tunnel.Tunnel;

public class Main {

    public static void main(String[] args) {

        CarGenerator generator = new CarGenerator(10);
        generator.generateCars(3);
        Tunnel tunnel = new Tunnel();
        for (int i = 0; i < 3; i++){
            tunnel.setCarInTunnel(generator.getCarFromQueue());
        }
        Car car1 = tunnel.getCarFromTunnel(Type.MILK);
        Car car2 = tunnel.getCarFromTunnel(Type.BREAD);
        System.out.println("Hello");
    }
}
