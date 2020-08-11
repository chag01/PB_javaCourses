import Interfaces.*;

public class Warrior extends Character implements Run, Info, Fight{

    private int maxRunSpeed;
    private boolean running;
    private String typeWeapon;

    public Warrior(int id, String name, int maxRunSpeed, String typeWeapon) {
        this.name = name;
        this.id = id;
        this.maxRunSpeed = maxRunSpeed;
        this.typeWeapon = typeWeapon;

    }

    public void runStart (){
        if (running){                   // running = true присваевается если был вызов метода runStart(), и сбрасывается на false при вызове runStop()
            System.out.println("Warrior " + name + " уже и так в режеме бега");
        }else {
            running = true;
            System.out.println("Warrior " + name + " начал бежать");
        }
    }

    public void runStop (){
        System.out.println("Warrior " + name + " остановился");
        running = false;
    }

    public void showInfo(){
        System.out.println("Свойства персонажа " + name + ": ID = " + id + ", maxRunSpeed = " + maxRunSpeed + ", typeWeapon: " + typeWeapon);
    }


    public void hit(){
        if (typeWeapon.equalsIgnoreCase("меч")){
            System.out.println("Warrior " + name + " нанёс удар мечом");
        } else {
            System.out.println("Warrior " + name + " не смог нанести урар. Причина: неопознанный тип оружия");
        }

    }


}
