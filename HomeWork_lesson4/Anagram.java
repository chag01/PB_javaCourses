import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Введите первую строку");
        String s1 = input.nextLine();

        System.out.println("Введите второую строку");
        String s2 = input.nextLine();

        // Аз есмь строка, живу я, мерой остр.
        // За семь морей ростка я вижу рост.
        // Я в мире - сирота.
        // Я в Риме - Ариост.

        if (sortAndRegex(s1).equals(sortAndRegex(s2)) ){        // метод sortAndRegex возвращает отсортированную строку с игнором регистра и символов препинания
            System.out.println("Строки являются анаграммой");
        } else {
            System.out.println("Не анаграмма");
        }
    }

    private static String sortAndRegex (String s) {
        String stringAfterRegex = s.replaceAll("[^A-Za-zА-Яа-я0-9)]", "");      // удаляются все символ кроме чисел и букв

        char[] chars = stringAfterRegex.toLowerCase().toCharArray();            // переводим всё в нижний регистр и записываем в массив символов
        Arrays.sort(chars);             // сортируем полученный массив символов по возрастанию

        String sorted = new String(chars);  // отсортированные символы помещаем в строку

        return sorted;
    }
}
