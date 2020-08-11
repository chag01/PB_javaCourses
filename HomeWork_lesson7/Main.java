public class Main {

    public static void main(String[] args) {

        System.out.println("***************************\nДемонстрация методов объекта warrior");
        Warrior warrior = new Warrior(0,"John",7,"Меч");
        warrior.runStart();
        warrior.runStart();         // напишет что персонаж уже и так бежит
        warrior.runStop();
        warrior.hit();
        warrior.showInfo();
        warrior.getId();

        System.out.println("\n******************************\nДемонстрация методов объекта Hunter");
        Hunter hunter = new Hunter(1,"Aloy");
        hunter.swimStart();      // напишет что персонаж уже и так плывет
        hunter.swimStart();
        hunter.swimStop();
        hunter.highJump();
        hunter.longJump();
        hunter.showInfo();
        hunter.getId();

    }
}
