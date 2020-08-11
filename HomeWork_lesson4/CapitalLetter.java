import java.util.Scanner;

public class CapitalLetter {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите значение");
        String s = input.nextLine().trim();


        String[] stringArray = s.split(" ");         // разбиение на массив строк, разделитель пробел

        StringBuilder sb = new StringBuilder();
        try {
            for (int i = 0; i < stringArray.length; i++) {          // цикл проходит по всем значениям массива
                stringArray[i] = stringArray[i].substring(0,1).toUpperCase() + stringArray[i].substring(1) + " ";
                // substring(0,1).toUpperCase() берет первый символ и переводит в верхний регистр
                // substring(1) + " " добавляет остальные символы и пробел в конце*/
                if (i == stringArray.length -1){            // если это последний элемент массива, то пробем удаляем
                    stringArray[i] = stringArray[i].trim();
                }
                sb.append(stringArray[i]);      // объединение элементов массива
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error");
            System.exit(1);
        }
        System.out.println(sb);
    }
}
