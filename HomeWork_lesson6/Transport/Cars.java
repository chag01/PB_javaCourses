package Transport;

public class Cars extends Transport {

    private String wheelDrive;

    public  Cars (){
        super("default Car");
    }           // дефолтный конструктор

    public Cars (String model, int maxSpeed, String fuel, String engine, String wheelDrive) {       // конструктор который принимает параметры
        super(model, maxSpeed, fuel, engine);
        this.wheelDrive = wheelDrive;
    }

    @Override
    public void engineStarts (){
        System.out.println("Двигатель автомобиля " + getModel() + " заводится");
    }

    @Override
    public void engineOn (){
        System.out.println("Двигатель объёмом " + getEngine() + " автомобиля " + getModel() + " заведен и настроен на максимальную скорость " + getMaxSpeed() +" км/ч");
    }

    @Override
    public void engineOf (){
        System.out.println("Двигатель" + getEngine()+ " автомобиля " + getModel() + " заглушен");
    }

    @Override
    public void fillUpFuel (){
        System.out.println("Автомобиль " + getModel() + " заправляется " + getFuel() + " бензином");
    }


}
