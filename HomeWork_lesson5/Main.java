import objects.*;

public class Main {

    public static void main(String[] args) {

        Bus bus = new Bus();
        bus.setNumber("107");           // присваиваем номер автобуса
        bus.setDriver("Денис");         // присваиваем водителя автобуса
        bus.setAverageSpeed(60);        // присваиваем среднюю скорость автобуса


        System.out.println("---------------------------------------");
        bus.start();    // автобус выезжает с 1й остановки
        bus.start();    // попытка повторно отправить автобус на следующую остановку, пока он ещё не остановился
        bus.showCountPassenger();       // отображает количество человек в салоне
        bus.stop();     // автобус останавливается на 2ой остановке

        Dog dog1 = new Dog("Шарик");

        Human human1 = new Human("Аристарх", dog1);         // создание человека являющегося владельцем собаки dog1

        bus.enterPassenger(human1,dog1);    // в автобус заходит человек и его собака
        bus.showCountPassenger();       // отображает количество человек в салоне
        bus.start();                // автобус выезжает со 2й остановки


        System.out.println("---------------------------------------");
        bus.stop();                 // автобус останаливается на 3й остановке
        bus.leavePassenger(human1);  // из автобуса выходит человек который заходил с собакой

        Dog dog2 = new Dog("Бублик");           // создание собаки без хозяина
        bus.enterPassenger(dog2);       // в автобус пытается зайти собака без хозяина
        bus.showCountPassenger();       // отображает количество человек в салоне
        bus.start();            // автобус выезжает c 3й остановки


        System.out.println("---------------------------------------");
        bus.stop();             // автобус останаливается на 4 остановке

        Human human2 = new Human("Аркадий");
        bus.enterPassenger(human2);

        Human human3 = new Human("Игнат");
        bus.enterPassenger(human3);

        Human human4 = new Human("Ибрагим");
        bus.enterPassenger(human4);

        Human human5 = new Human("Людвиг");
        bus.enterPassenger(human5);

        bus.showCountPassenger();       // отображает количество человек в салоне
        bus.start();            // автобус выезжает с 4й остановки


        System.out.println("---------------------------------------");
        bus.stop();             // автобус останаливается на 5 остановке
        bus.leavePassenger(human2);     // из автобуса выходит человек
        bus.leavePassenger(human3);     // из автобуса выходит человек
        bus.leavePassenger(human4);     // из автобуса выходит человек
        bus.leavePassenger(human5);     // из автобуса выходит человек
        bus.showCountPassenger();       // отображает количество человек в салоне


        System.out.println("---------------------------------------");
        bus.start();                // попытка отправить автобус на следующую несуществующую остановку
        }
    }


