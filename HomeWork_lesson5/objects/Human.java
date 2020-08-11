package objects;

public class Human {

    private String name;
    private String dogName;

    public Human (String name){
        this.name = name;
    }

    public Human (String name, Dog dog){        // конструктор создания человека, если он является хозяином собаки
        this.name = name;
        this.dogName = dog.getName();
    }

    public String getName() {
        return name;
    }

    public String getDogName() {
        return dogName;
    }
}
