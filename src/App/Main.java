package App;

import App.Cars.Car;
import App.Cars.Type.Type;
import App.Tasks.CarGenerator;
import App.Tasks.Dispatcher;
import App.Tunnel.Tunnel;

public class Main {

    public static void main(String[] args) throws Exception{



        Dispatcher dispatcher = new Dispatcher(10);
        dispatcher.run();
    }
}
