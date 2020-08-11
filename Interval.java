import java.util.Scanner;

public class Interval {

    public static void main(String[] args) {
        String stringNumber;

        Scanner inputNumber = new Scanner(System.in);
        System.out.println("Введите число от в диапазоне [ 0 - 100 ]");

        stringNumber = inputNumber.next();                   // запись введенного значения в переменную типа стринг

        if (stringNumber.contains(",")){                    // проверка на запятую. В случае если клиент использует запятую как разделитель целой и дробной части
            ReplaceSymbol replace = new ReplaceSymbol();
            Convert convert = new Convert();
            Operations operations = new Operations();

            operations.getInterval(convert.stringToDouble(replace.comma(stringNumber)));     // метод getInterval проверяет в какой диапазон попадает число
                                                                                      // метод stringToDouble конвертирует string в double
                                                                                      // метод comma заменяет запятые на точке в переменной string
        } else {
            Convert Convert = new Convert();
            Operations operations = new Operations();

            operations.getInterval(Convert.stringToDouble(stringNumber));                   // метод getInterval проверяет в какой диапазон попадает число
        }                                                                            // метод stringToDouble конвертирует string в double
    }
}

class ReplaceSymbol {

     String comma (String stringNumber){
        stringNumber = stringNumber.replace(",", ".");              // замена запятой на точку в переменной типа string
        return stringNumber;
    }
}

class Convert {
    private double number;

     Double stringToDouble (String stringNumber)  {
        try {                                                    // обрабатывает ошибку если конвертация в double неудачна
            this.number = Double.parseDouble(stringNumber);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат значения");      // вывод сообщения если конвертация в double неудачна
            System.exit(0);                       // остановка потока
        }
        return this.number;
    }
}

class Operations {

     void getInterval (double number){
        if ( number >= 0 && number <= 14 ){
            System.out.println("Указано число в диапазоне [ 0 - 14 ]");
        }  else if ( number >= 15 && number <= 35 ){
            System.out.println("Указано число в диапазоне [ 15 - 35 ]");
        } else if ( number >= 36 && number <= 50 ){
            System.out.println("Указано число в диапазоне [ 36 - 50 ]");
        } else if ( number >= 51 && number <= 100 ){
            System.out.println("Указано число в диапазоне [ 51 - 100 ]");
        } else {
            System.out.println("Ошибка: указанное число не соответствует диапазону [ 0 - 100 ]");
        }
    }
}








