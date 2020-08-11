package objects;

public class Bus {

    private String number;           // номер автоубса
    private int averageSpeed;        // скорость автобуса
    private String driver;           // водитель автобуса
    private int countPassenger = 0;  // число людей в салоне
    private char onWay = 'N';        // автобус находится в пути

    private Stations stations = new Stations();


    /**
     * Проверяет что автобус сейчас стоит,а не едет
     * Проверяет что у автобуса есть водитель
     * Выполняет отправку автобуса, и выводит информацию о том, с какой и на какую остановку автобус выехал
     *
     */
    public void start (){
        if (onWay == 'N'){
            if (driver != null && !driver.isEmpty()){
                if (stations.getCountStation() > stations.busStations107.length -2){
                    System.out.println("Автобус находится на конечной остановке");
                } else {
                    System.out.println(number + " автобус выезжает c остановки: " + stations.getCurrentStation() + ". Следующая остановка: " + stations.getNextStation());
                    onWay = 'Y';
                }
            } else {
                System.out.println("Автобус не может ехать без водителя");
                System.exit(1);
            }
        } else {
            System.out.println("Автобус уже в пути");
        }
    }


    /**
     * Выполняет остановку автобуса и выводит информацию о том, на какой остановке находится автобус
     */
    public void stop(){
        if (stations.getCountStation() == stations.busStations107.length -1) {
            System.out.println(number +  " автобус остановился на конечной остановке: " + stations.getCurrentStation()
            + ". \nСпасибо что воспользовались нашими услугами. Средняя скорость на маршруте была около: " + averageSpeed + " км/ч."
            + " \nС Вами был водитель автобуса " + driver);
        } else {
            System.out.println(number + " автобус остановился на остановке: " + stations.getCurrentStation());
        }
        onWay = 'N';
    }


    /**
     * Отображает имя пассажира который зашел в салон и увеличивает счетчик
     */
    public void enterPassenger (Human human){
        System.out.println("В салон зашел пассажир: " + human.getName());
        countPassenger++;
    }


    /**
     * Отображает имя пассажира и его собаки которые зашли в салон и увеличивает счетчик
     * Проверяет зашла ли собака со своим хозяином
     */
    public void enterPassenger (Human human, Dog dog){
        if (human.getDogName().equals(dog.getName())){            // проверка что собака зашла со своим хозяином
            System.out.println("В салон зашел пассажир: " + human.getName() + ". И его собака: " + human.getDogName());
        } else {
            System.out.println("В салон зашел пассажир: " + human.getName() +
                    "\nВодитель не пустил в салон собаку по кличке: '" + dog.getName() + "' потому что она зашла без хозяина.");
        }
        countPassenger ++ ;
    }


    /**
     * Проверяет что собака зашла сама, соответственно без хозяина
     */
    public void enterPassenger (Dog dog){
            System.out.println("Водитель не пустил в салон собаку по кличке: '" + dog.getName() + "' потому что она зашла без хозяина.");
        }


    /**
     * Отображает имя пассажира и собаки которые вышли с салона,
     * Уменьшает счетчик пассажиров
     */
    public void leavePassenger (Human human){
        if (human.getDogName() == null || human.getDogName().isEmpty()) {
            System.out.println("Из салона вышел пассажир: " + human.getName());
        } else {
            System.out.println("Из салона вышел пассажир: " + human.getName() + ". И его собака по кличке: " + human.getDogName());
        }
        countPassenger -- ;
    }


    public void  showCountPassenger() {
        System.out.println("Количество людей в салоне: " + countPassenger);
    }

    public void setAverageSpeed(int averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
