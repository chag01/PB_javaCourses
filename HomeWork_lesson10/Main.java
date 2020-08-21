import java.util.*;

public class Main  {
    private static int choiceMenu;
    private static int addMenuPoint;  // переменая используется в методе addPersonMenu() для цикла while
    private static ArrayList<Person> personList = new ArrayList<>();
    private static int id = 0;
    private static String phone;
    private static int findMenuPoint; // переменая используется в методе findPersonMenu() для цикла while
    private static int removeMenuPoint; // переменая используется в методе removePersonMenu() для цикла while
    private static int editMenuPoint; // переменая используется в методе removePersonMenu() для цикла while
    private static Scanner input = new Scanner(System.in);
    private static int idForFind;
    private static String nameForFind;
    private static String phoneForFind;
    private static String nameForEdit;
    private static String phoneForEdit;
    private static String dateOfBirthForEdit;
    private static ArrayList<Person> personFounded = new ArrayList<>(); // список используется в методе findPersonMenu
    private static Person personForEdit;
    private static int fieldSort;


    public static void main(String[] args) {

        while (true) {
            showMenu();

            try {
                choiceMenu = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка. Неверно указан пункт меню");
                input.skip(".*\\n");  // костыль. без этого зацикливается  метод showMenu
                choiceMenu = 99; // костыль. присваиваю 99 , иначе по умолчанию choiceMenu = 0, срабатывает if(choiceMenu==0) и программа закрывается
            }

            if (choiceMenu == 1) {
                addMenuPoint = choiceMenu;
                addPersonMenu();
            }
            if (choiceMenu == 2) {
                showAllPersons();
            }
            if (choiceMenu == 3) {
                findMenuPoint = choiceMenu;
                findPersonMenu();
            }
            if (choiceMenu == 4) {
                editMenuPoint = choiceMenu;
                editPersonMenu();
            }
            if (choiceMenu == 5) {
                removeMenuPoint = choiceMenu;
                removePersonMenu();
            }
            if (choiceMenu == 0) {
                System.out.println("Завершение программы");
                System.exit(0);
            }
        }
    }


    private static void showMenu() {
        System.out.println("\nВыберите действие" +
                "\n1 - Добавить контакт" +
                "\n2 - Вывести на экран все контакты" +
                "\n3 - Поиск контакта" +
                "\n4 - Редактировать контакт" +
                "\n5 - Удаление контакта по ID" +
                "\n0 - Завершить работу");
    }


    private static void addPersonMenu() {
        while (addMenuPoint == 1) {
            Person person = new Person();

            System.out.println("Укажите ФИО");
            input.nextLine();
            person.setName(input.nextLine());

            System.out.println("Укажите номер телефона");
            phone = input.nextLine();
            person.setPhone(phone);

            System.out.println("Укажите дату рождения");
            person.setDateOfBirth(input.nextLine());

            person.setId(getNextId());

            personList.add(person);

            System.out.println("Хотите добавить ещё один контакт?( 1 - Добавить ещё; 0 - Выйти в меню )");
            try {
                addMenuPoint = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Неверно указан пункт меню");
                input.skip(".*\\n");
                addMenuPoint = 0; // меняем значение переменной что бы остаться в этом же цикле while. если не менять значение, то перейдёт на создание контакта
            }
        }
    }

    private static void findPersonMenu() {
        while (findMenuPoint != 0) {
            System.out.println("\nВыберите значение для поиска( 1 - Поиск по ID; 2 - Поиск ФИО; 3 - Поиск по номеру телефона; 0 - Выйти в меню )");
            findMenuPoint = input.nextInt();
            switch (findMenuPoint) {
                // find by ID
                case 1:
                    System.out.println("Введите ID");
                    try {
                        idForFind = input.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка. Неверно указано значение");
                        personFounded.removeAll(personFounded);
                        input.skip(".*\\n");
                    }

                    for (Person person : personList) {
                        if (person.getId() == idForFind) {
                            personFounded.add(person);
                        }
                    }
                    if (personFounded.size() != 0) {
                        System.out.println("Результат поиска по ID:");
                        personFounded.forEach(System.out::print);
                        personFounded.removeAll(personFounded);
                    } else {
                        System.out.println("Отсутствуют контакты по заданным условиям");
                    }
                    break;
                // find by NAME
                case 2:
                    System.out.println("Введите ФИО");
                    nameForFind = input.next();
                    for (Person person : personList) {
                        if (person.getName().toLowerCase().contains(nameForFind.toLowerCase())) {   // что бы осуществлялся поиск без учета регистра - привожу 2 значения в нижний регистр
                            personFounded.add(person);
                        }
                    }
                    if (personFounded.size() != 0) {
                        System.out.println("Результат поиска по ФИО:");
                        personFounded.forEach(System.out::print);
                        personFounded.removeAll(personFounded);
                    } else {
                        System.out.println("Отсутствуют контакты по заданным условиям");

                    }
                    break;
                // find by PHONE
                case 3:
                    System.out.println("Введите телефон");
                    phoneForFind = input.next();
                    for (Person person : personList) {
                        if (person.getPhone().contains(phoneForFind)) {
                            personFounded.add(person);
                        }
                    }
                    if (personFounded.size() != 0) {
                        System.out.println("Результат поиска по телефону:");
                        personFounded.forEach(System.out::print);
                        personFounded.removeAll(personFounded);
                    } else {
                        System.out.println("Отсутствуют контакты по заданным условиям");
                    }
                    break;
            }
        }
    }

    private static void editPersonMenu() {
        while (editMenuPoint != 0) {
            System.out.println("\nУкажите ID контакта которого хотите редактировать ( 0 - Выйти в меню )");
            try {
                editMenuPoint = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка. Неверно указано значение");
                input.skip(".*\\n");
                editMenuPoint = 0;
            }

            if (editMenuPoint != 0) {  // если в качестве ID указали не 0, то проходит по списку контактов, и если находит, записывает в personForEdit
                for (Person person : personList) {
                    if (person.getId() == editMenuPoint) {
                        personFounded.add(person);
                        personForEdit = personFounded.get(0);
                    }
                }

                if (personFounded.size() != 0) {    // если найден контакт для редактирования
                    System.out.println("\nКонтакт найден ( 1 - Редактировать ФИО; 2 - Редактировать номер телефона; 3 - Редактировать дату рождения; 0 - Выйти в меню )");
                    try {
                        editMenuPoint = input.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка. Неверно указано значение");
                        input.skip(".*\\n");
                        personFounded.remove(0);
                        break;
                    }

                    // проверка что указан верно пункт меню редактирования
                    if (editMenuPoint != 1 && editMenuPoint != 2 && editMenuPoint != 3 && editMenuPoint != 0) {
                        System.out.println("\nНеверно указан пунк меню");
                        personFounded.remove(0);   // очистка спика найденых клиентов, потому что затем мы возвращаемся к указанию ID клиента,
                        // если не очищать, то даже если ввести ID который не существует, то список заполнен ранее найденым клиентом,
                        // и программа пойдет на редактирование клиента.
                    } else {
                        switch (editMenuPoint) {
                            // edit NAME
                            case 1:
                                System.out.println("\nУкажите ФИО");
                                nameForEdit = input.next();
                                personForEdit.setName(nameForEdit);
                                System.out.println("Контакт успешно отредактирован");
                                personFounded.remove(0);
                                input.skip(".*\\n");
                                break;
                            // edit PHONE
                            case 2:
                                System.out.println("\nУкажите номер телефона");
                                phoneForEdit = input.next();
                                personForEdit.setPhone(phoneForEdit);
                                System.out.println("Контакт успешно отредактирован");
                                personFounded.remove(0);
                                input.skip(".*\\n");
                                break;
                            // edit dateOfBirth
                            case 3:
                                System.out.println("\nУкажите дату рождения");
                                dateOfBirthForEdit = input.next();
                                personForEdit.setDateOfBirth(dateOfBirthForEdit);
                                System.out.println("Контакт успешно отредактирован");
                                personFounded.remove(0);
                                input.skip(".*\\n");
                                break;
                        }
                    }
                } else {
                    System.out.println("Отсутствует контакт с ID: " + editMenuPoint);
                    input.skip(".*\\n");
//                    editMenuPoint=99;
                }

            } else {
                break;
            }

        }
    }


    private static void removePersonMenu() {
        while (removeMenuPoint != 0) {
            System.out.println("\nУкажите ID контакта который хотите удалить?( 0 - Выйти в меню )");
            try {
                removeMenuPoint = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Неверно указано значение");
                input.skip(".*\\n");
                break;
            }
            if (removeMenuPoint != 0) {
                int sizeListBeforeRemove = personList.size();
                try {
                    for (Person person : personList) {
                        if (person.getId() == removeMenuPoint) {
                            personList.remove(person);
                            System.out.println("Удален контакт c ID: " + person.getId() + ". ФИО: " + person.getName());
                        }
                    }
                } catch (ConcurrentModificationException e) {  // Если удален последний по списку, то возникает ошибка. Мы её ловим и игнорирует
                }
                int sizeListAfterRemove = personList.size();
                if (sizeListBeforeRemove == sizeListAfterRemove) {    // если до и после удаления размер листа не изменился, то выводим сообще о том что контакт не найден
                    System.out.println("Не найден контакт с ID " + removeMenuPoint);
                }
            }
            if (personList.size() == 0) {       // Если контакты в листе отсутствуют, то выводим сообщение и переходим в главное меню
                System.out.println("В списке отсутствуют контакты. Возвращение в главное меню.");
                break;
            }
        }
    }


    private static void showAllPersons() {
        if (personList.size() != 0) {
            System.out.println("\nВыберите по какому полю сортировать ( 1 - по ID; 2 - по ФИО ) ");
            try {
                fieldSort = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nОшибка. Неверно указан пункт меню");
                input.skip(".*\\n");
                fieldSort = 0; // присваем 0, так как если ранее было введено 1/2, то сортировка всё равно отобразится, даже если указать некорректное значение
            }

            switch (fieldSort) {
                case 1:
                    System.out.println("\nВывод на экран всех контактов:");
                    personList.sort(Comparator.comparing(Person::getId));
                    personList.forEach(System.out::print);
                    break;
                case 2:
                    System.out.println("\nВывод на экран всех контактов:");
                    personList.sort(Comparator.comparing(Person::getName));
                    personList.forEach(System.out::print);
                    break;
            }

        } else {
            System.out.println("\nСписок контактов пустой");
        }
    }

    private static int getNextId() {
        return ++id;
    }
}