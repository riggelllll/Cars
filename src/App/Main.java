package App;

import App.Tasks.Dispatcher;

public class Main {

    public static void main(String[] args){
        Dispatcher dispatcher = new Dispatcher(10);
        dispatcher.service.shutdown();
    }
}
