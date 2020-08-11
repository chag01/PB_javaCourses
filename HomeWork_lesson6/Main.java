import Transport.*;

import java.lang.reflect.Constructor;

public class Main {
    //Автомобили. Создать иерархию классов для выбранной области с использованием наследования, 3-4 класса достаточно. Определить для каждого класса свой уникальный конструктор, методы и поля.
    //В классах переопределить методы toString, equals, hashCode
    //Создать Main в котором продемонстировать работу классов из предметной области, создать несколько объектов через new, создавать один об. с использованием рефлексии
    //Поместить собранные объекты в массив и выполнить над ними действия демострируюзщие работу полиморфизма
    // tesla. Метод charge, заряжается электрическом (переопределить)

 // Transport - Toyota, Tesla, BMW

    public static void main(String[] args) throws Exception {

        System.out.println("Объект transport");
        Transport transport = new Transport("default");
        engineStarts(transport);
        transport.engineOf();

        System.out.println("\nОбъект car");
        Cars car = new Cars();
        car.engineStarts();

        System.out.println("\nОбъект toyota");
        Toyota toyota = new Toyota("Camry", 210, "95", "2.0", "rear");
        toyota.engineStarts();
        toyota.engineOn();

        System.out.println("\nОбъект toyota1");
        Toyota toyota1 = new Toyota("Corolla", 180, "92", "1.3", "front");
        toyota1.fillUpFuel();

        System.out.println("\nОбъект tesla");
        Tesla tesla = new Tesla("model x", 250, "electro", "electro", "4WD", 220);
        engineStarts(tesla);
        tesla.fillUpFuel();

        // рефлексия
        Class clazz = Class.forName("Transport.Cars");
        Constructor constructor = clazz.getConstructor(new Class[]{});
        Object bmw = constructor.newInstance();

        System.out.println("\nОбъект Car1 созданный рефлексией");
        Cars car1 = (Cars) bmw;
        car1.engineStarts();

        System.out.println("\nМассив toyotas");
        Toyota[] toyotas = {toyota, toyota1};       // создание массива и помещение в него двух обьъектов
        for (Toyota toyota2 : toyotas ){
            toyota2.fillUpFuel();
        }

        System.out.println("\nпереопределенный toString");
        System.out.println(toyota);


        // создание объекта с такими же значениями как и объект toyota, отличие только в model
        Toyota toyota3 = new Toyota("Camry V2", 210, "95", "2.0", "rear");
        System.out.println("\nпереопределенный equals");
        System.out.println("toyota.equals(toyota3)): " + toyota.equals(toyota3));         // true
        System.out.println("toyota.equals(toyota1): " + toyota.equals(toyota1));         // false


        System.out.println("\nпереопределенный hashCode");
        System.out.println("toyota.hashCode: " + toyota.hashCode());        // hashCode toyota и toyota3 одинаковый, т.к. у них одно и тоже значение полей maxSpeed, fuel, engine
        System.out.println("toyota3.hashCode: " + toyota3.hashCode());
        System.out.println("toyota1.hashCode: " + toyota1.hashCode());

    }

    private static void engineStarts (Transport transport){  // статический метод
        transport.engineStarts();
        transport.engineOn();
    }
}
