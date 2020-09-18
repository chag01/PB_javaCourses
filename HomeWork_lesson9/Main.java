import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        House<Dog> house = new House<>();
        house.set(new Dog("Bobik"));
        Dog dog = house.get();
        System.out.println(dog.getName());

        House<Cat> house1 = new House<>();
        house1.set(new Cat("Murka"));
        Cat cat = house1.get();
        System.out.println(cat.getName());

        TripleHouse<Dog, Dog, Cat> tripleHouse = new TripleHouse<>();
        tripleHouse.set1(new Dog("Sharik"));
        Dog dog2 = new Dog("Ruff");
        tripleHouse.set2(dog2);
        tripleHouse.set3(new Cat("Vasya"));
        Dog dog1 = tripleHouse.get1();
        System.out.println(dog1.getName());

        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Amur"));
        animals.add(new Cat("Bars"));
        animals.add(new Cat("Blade"));
        animals.add(new Dog("Ali"));


        AnimalShelter shelter = new AnimalShelter();
        shelter.addAll(animals);    // добавление списка животных

        showName(animals);

    }

    private static void showName(List<? extends Animal> list) {
        for (Animal animal : list) {
            System.out.println("Имя животного: " + animal.getName());
        }
    }

}


