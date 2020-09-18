public class TripleHouse<A extends Animal, B extends Animal, C extends Animal> {
    private A animal1;
    private B animal2;
    private C animal3;

    public A get1() {
        return animal1;
    }

    public void set1(A animal1) {
        this.animal1 = animal1;
    }

    public B get2() {
        return animal2;
    }

    public void set2(B animal2) {
        this.animal2 = animal2;
    }

    public C get3() {
        return animal3;
    }

    public void set3(C animal3) {
        this.animal3 = animal3;
    }
}
