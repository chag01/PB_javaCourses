
import java.util.Random;
import java.util.Scanner;

public class Bingo {

    private static int inputNumber;
    private static int randomNumber;
    private static int counter = 1;
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {


        generateRandomNumber();

        do {
            inputNumber();
            checkEquals(inputNumber, randomNumber);
        } while (inputNumber != randomNumber);

    }


    private static void inputNumber() {
        String inputValue = input.next();
        if(inputValue.equalsIgnoreCase("exit")) {
            end();
        } else {
            try {
                inputNumber = Integer.parseInt(inputValue);
            } catch (NumberFormatException e){
                System.err.println("Неверный формат значения");
                end();
            }
        }
    }


    private static void generateRandomNumber(){
        Random random = new Random();
        randomNumber = random.nextInt(100);       // генерация рандомного числа
        System.out.println("Я загадал число от 0 до 100. Попробуй угадать!" + "\nДля завершения программы напишите 'exit'");
//        System.out.println("Загаданное число = " + randomNumber); // строка для тестов
    }

    private static void end () {
        System.out.println("Заверщение программы");
        System.exit(0);
    }

    private static void checkEquals(int inputNumber, int randomNumber) {

        if (inputNumber != randomNumber) {
            if (inputNumber > randomNumber) {
                System.out.println("Неудача! Попробуйте ещё раз. Ваше число больше чем загаданное ");
                counter++;

            } else {
                System.out.println("Неудача! Попробуйте ещё раз. Ваше число меньше чем загаданное ");
                counter++;
            }
        } else {
            System.out.println("Поздравляем! Вы угадали число с " + counter + "ой попытки.");
        }
    }
}

