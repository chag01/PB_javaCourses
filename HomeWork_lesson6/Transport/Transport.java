package Transport;

import java.util.Objects;

public class Transport {
    private final String model;
    private int maxSpeed;
    private String fuel;
    private String engine;


    public Transport (String model, int maxSpeed, String fuel, String engine) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.fuel = fuel;
        this.engine = engine;
    }

    public Transport (String model){
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getFuel() {
        return fuel;
    }

    public String getEngine() {
        return engine;
    }

    public void engineStarts (){
        System.out.println("Транспорт " + model + " заводится");
    }

    public void engineOn (){
        System.out.println("Транспорт " + model +  " заведен");
    }

    public void engineOf (){
        System.out.println("Транспорт " + model + " заглушен");
    }

    public void fillUpFuel (){
        System.out.println("Заправка транспортом ");
    }

    @Override
    public String toString() {              // переопределение toString
        return "Transport{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", fuel='" + fuel + '\'' +
                ", engine='" + engine + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {                   // переопределение equals. Сравнивает по maxSpeed,fuel,engine
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return maxSpeed == transport.maxSpeed &&
                Objects.equals(fuel, transport.fuel) &&
                Objects.equals(engine, transport.engine);
    }

//    public boolean equals(Transport transport) {
//        return maxSpeed == transport.maxSpeed &&
//                Objects.equals(fuel, transport.fuel) &&
//                Objects.equals(engine, transport.engine);
//    }

    @Override
    public int hashCode() {             // переопределенный hashCode
        return Objects.hash(maxSpeed, fuel, engine);
    }
}
