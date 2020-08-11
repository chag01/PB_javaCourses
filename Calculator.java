import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
// разобраться почему 1.1 + 2.2 = 3.3000002 . Понять почему, либо сделать округление
        Scanner input = new Scanner(System.in);

        System.out.println("Введите первое число");
        Operand operand1 = new Operand();
        if (input.hasNextFloat()) {
            operand1.setOperand(input.nextFloat());
        } else {
            System.out.println("Ошибка: неверный формат числа");
            System.exit(0);
        }

        System.out.println("Введите второе число");
        Operand operand2 = new Operand();
        if (input.hasNextFloat()) {
            operand2.setOperand(input.nextFloat());
        } else {
            System.out.println("Ошибка: неверный формат числа");
            System.exit(0);
        }

        System.out.println("Укажите арифметическую операцию. Доступные: сложение + ; вычитание - ; умножение * ; деление / ");
        String sign = input.next();

        MathOperations operations = new MathOperations();

        switch (sign) {
            case "+":
                operations.addition(operand1.getOperand(), operand2.getOperand());
                break;
            case "-":
                operations.subtraction(operand1.getOperand(), operand2.getOperand());
                break;
            case "*":
                operations.multiply(operand1.getOperand(), operand2.getOperand());
                break;
            case "/":
                if (operand2.getOperand() == 0) {
                    System.out.println("Ошибка: деление на 0 невозможно");
                } else {
                    operations.divide(operand1.getOperand(), operand2.getOperand());
                }
                break;
            default: System.out.println("Ошибка: указана неверная арифметическая операция");
        }
    }
}

class Operand {
    private float operand;

     void setOperand(float operand){
        this.operand = operand;
    }

     float getOperand(){
        return operand;
    }
}

class MathOperations {

    void addition(float operand1, float operand2) {
        float result = operand1 + operand2;
        System.out.println("Результат = " + result);
    }

    void subtraction(float operand1, float operand2) {
        float result = operand1 - operand2;
        System.out.println("Результат = " + result);
    }

    void multiply(float operand1, float operand2) {
        float result = operand1 * operand2;
        System.out.println("Результат = " + result);
    }

    void divide(float operand1, float operand2) {
        float result = operand1 / operand2;
        System.out.println("Результат = " + result);
    }
}