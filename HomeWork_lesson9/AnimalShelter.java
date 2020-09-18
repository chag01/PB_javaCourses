import java.util.ArrayList;
import java.util.List;

public class AnimalShelter <T extends Animal> {
    private List<T> animals;

    public  AnimalShelter() {
        animals = new ArrayList<>();
    }

    public void addAll (List<T> list){
        animals.addAll(list);
    }


}
