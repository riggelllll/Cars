package App.Tasks;

import App.Cars.Car;
import App.Cars.Type.Type;
import App.Stock.Stock;
import App.Tunnel.Tunnel;

import java.util.ArrayList;

public class Dispatcher {
    CarGenerator carGenerator;
    Tunnel tunnel;
    ArrayList<Stock>stocks;

    private static final int STOCKS_AMOUNT = 3;

    public Dispatcher(int maxCarsInQueu){
        carGenerator = new CarGenerator(maxCarsInQueu);
        tunnel = new Tunnel();
        stocks = new ArrayList<>(STOCKS_AMOUNT);

    }

    private void init(){
        carGenerator.generateCars(carGenerator.getMaxCarsAmount());
        stocks.add(new Stock("Склад", Type.BREAD));
        stocks.add(new Stock("Склад", Type.MILK));
        stocks.add(new Stock("Склад", Type.SAUSAGE));
    }

    public void run()throws Exception{
        init();

        while (true){
            for(Stock stock : stocks){
                //START
                if (stock.isEmpty()){//На складе нет машины
                    if (tunnel.isFull()){//В тонеле есть машины и он полон
                        if (tunnel.getCarFromTunnel(stock.getType()) != null){//Если соответствует типу машина
                            setAndLoadInStock(stock);
                        }else {//машина не соответствует типу
                            return;
                        }
                    }else {//тонель не полон
                        if(carGenerator.isFull()){//В очереди есть машины
                            addCarsToTunnel();
                            if (tunnel.getCarFromTunnel(stock.getType()) != null){//Если соответствует типу машина
                                setAndLoadInStock(stock);
                            }else {//машина не соответствует типу
                                return;
                            }
                        }else {//в очереди нет машин
                            carGenerator.generateCars(carGenerator.getMaxCarsAmount() - carGenerator.getCarsCounter());
                            addCarsToTunnel();
                            setAndLoadInStock(stock);
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

    private void setAndLoadInStock(Stock stock) throws Exception{
        stock.setCar(tunnel.getCarFromTunnel(stock.getType()));
        stock.loadCar();
    }







}
