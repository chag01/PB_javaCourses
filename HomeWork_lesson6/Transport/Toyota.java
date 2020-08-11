package Transport;

public class Toyota extends Cars {

    public Toyota(String model, int maxSpeed, String fuel, String engine, String wheelDrive) {
        super(model, maxSpeed, fuel, engine, wheelDrive);
    }

    @Override
    public void engineStarts (){
        System.out.println("Двигатель объёмом " + getEngine()+ " автомобиля Toyota " + getModel() + " заводится");
    }

    @Override
    public void engineOn (){
        System.out.println("Двигатель объёмом " + getEngine() + " автомобиля Toyota " + getModel() + " заведен и настроен на максимальную скорость " + getMaxSpeed() +" км/ч");
    }

    @Override
    public void engineOf (){
        System.out.println("Двигатель" + getEngine()+ " автомобиля Toyota " + getModel() + " заглушен");
    }

    @Override
    public void fillUpFuel (){
        System.out.println("Toyota " + getModel() + " заправляется " + getFuel() + " бензином");
    }
}

