import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {

        inputArray(); // вызов метода для
        bubbleSort(array);

    }

    private static void inputArray() {
        Scanner input = new Scanner(System.in);

        System.out.println("Требуется ввести " + array.length + " чисел");
        int counter = 1;               // счетчик используется в sout для отображения номера числа в цикле for
        try {               // отлов ошибки
            for (int i = 0; i < array.length; i++) {                // цикл отрабатывает кол-во раз, равное размеру массива
                System.out.println("Введите число №" + counter);
                array[i] = input.nextInt();             // инициализация ячеек массива
                counter++;
            }
        } catch (InputMismatchException e) {         // если была ошибка в блоке try - то выводим сообщение об ошибке и останавливаем процесс
            System.out.println("Ошибка: неверный формат числа");
            System.exit(0);
        }
        System.out.println("Изначальный вид массива " + Arrays.toString(array));
    }

    private static int[] array = new int[10];      // создание массива размером 10 ячеек

    private static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {         // если число слева больше числа справа
                    int temp = array[j];            // в переменную temp записываем значение ячейки j
                    array[j] = array[j + 1];          // в левую ячейку записываем значение правой ячейки
                    array[j + 1] = temp;              // в правую ячейку записываем значение переменной temp. Поменяли местами значение ячеек j и j+1
                }
            }
        }
        System.out.println("Результат сортировки: " + Arrays.toString(array));
    }
}
