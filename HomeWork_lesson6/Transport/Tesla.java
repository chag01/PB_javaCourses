package Transport;

public class Tesla extends Cars {

    private int volt;

    public Tesla(String model, int maxSpeed, String fuel, String engine, String wheelDrive, int volt) {
        super(model, maxSpeed, fuel, engine, wheelDrive);
        this.volt = volt;
    }

    @Override
    public void engineStarts (){
        System.out.println("Электро двигатель Tesla " + getModel() + " заводится");
    }

    @Override
    public void engineOn (){
        System.out.println("Электро двигатель Tesla " + getModel() + " заведен и настроен на максимальную скорость " + getMaxSpeed() +" км/ч");
    }

    @Override
    public void engineOf (){
        System.out.println("Электро двигатель Tesla " + getModel() + " заглушен");
    }

    @Override
    public void fillUpFuel (){
        System.out.println("Электро двигатель Tesla " + getModel() + " заряжается от напряжения " + volt + " вольт");
    }
}
