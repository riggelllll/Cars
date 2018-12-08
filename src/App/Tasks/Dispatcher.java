package App.Tasks;

import App.Cars.Type.Type;
import App.Stock.Stock;
import App.Tunnel.Tunnel;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Dispatcher{
    private CarGenerator carGenerator;
    private Tunnel tunnel;
    private ArrayList<Stock>stocks;
    public ExecutorService service;

    private static final int STOCKS_AMOUNT = 3;

    public Dispatcher(int maxCarsInQueue){
        carGenerator = new CarGenerator(maxCarsInQueue);
        tunnel = new Tunnel();
        stocks = new ArrayList<>(STOCKS_AMOUNT);
        init();
        service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        service.execute(taskDispatcher);
        service.execute(stocks.get(0));
        service.execute(stocks.get(1));
        service.execute(stocks.get(2));
    }

    private void init(){
        carGenerator.generateCars(carGenerator.getMaxCarsAmount());
        stocks.add(new Stock("Склад", Type.BREAD));
        stocks.add(new Stock("Склад", Type.MILK));
        stocks.add(new Stock("Склад", Type.SAUSAGE));
    }

    Runnable taskDispatcher = ()->{
        work();
    };

    public void work() {
        boolean running = true;


        while (running){
            for(Stock stock : stocks){
                //START
                if (stock.isEmpty()){//На складе нет машины
                    if (tunnel.isFull()){//В тонеле есть машины и он полон
                        if (tunnel.isHaveType(stock.getType())){//Если соответствует типу машина
                            setAndLoadInStock(stock);
                        }else {//машина не соответствует типу
                            continue;
                        }
                    }else {//тонель не полон
                        if(carGenerator.isFull()){//В очереди есть машины
                            addCarsToTunnel();
                            if (tunnel.isHaveType(stock.getType())){//Если соответствует типу машина
                                setAndLoadInStock(stock);
                            }else {//машина не соответствует типу
                                continue;
                            }
                        }else {//в очереди нет машин
                            carGenerator.generateCars(carGenerator.getMaxCarsAmount() - carGenerator.getCarsCounter());
                            addCarsToTunnel();
                            if (tunnel.isHaveType(stock.getType())){//Если соответствует типу машина
                                setAndLoadInStock(stock);
                            }else {//машина не соответствует типу
                                continue;
                            }
                        }

                    }
                }else {//На складе есть машина
                    if (stock.getCar().isEmpty()){//Машина пуста
                        stock.loadCar();
                    }else {//Машина загружена
                        stock.deleteCar();
                    }
                }
             //END
            }
        }
    }

    private void addCarsToTunnel(){
        for (int i = tunnel.getCarsCounter(); i < tunnel.get_MAX_CARS_AMOUNT(); i++){//Добавить машины в тонель
            tunnel.setCarInTunnel(carGenerator.getCarFromQueue());
        }
    }

    private void setAndLoadInStock(Stock stock){
        stock.setCar(tunnel.getCarFromTunnel(stock.getType()));
    }

}
