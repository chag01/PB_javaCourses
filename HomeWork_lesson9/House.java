public class House <D extends Animal>  {

    private D animal;

    public D get(){
        return animal;
    }

    public void set(D animal){
        this.animal = animal;
    }

}
