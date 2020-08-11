package objects;

public class Stations {

    private int countStation = 0;           // счетчик остановок

    public String[] busStations107 = new String []{             // массив остановок
            "ж/м Тополь - 3",                   //  0
            "ж/м Тополь - 2",                   //  1
            "ж/м Тополь - 1",                   //  2
            "Улица Космическая",                //  3
            "Победа - McDonalds"};              //  4

    public String getCurrentStation (){
        return busStations107[getCountStation()];           // возвращает название текущей остановки
    }


    public String getNextStation (){
        if (countStation < busStations107.length -1){           // увеличивает счетчик если автобус находится не наконечной остановке
            countStation ++;
        }
        return busStations107[getCountStation()];               // возвращает название остановки, после увеличения счетчика
    }

    public int getCountStation() {
        return countStation;
    }

}
