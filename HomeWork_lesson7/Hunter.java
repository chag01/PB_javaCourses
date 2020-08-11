
import Interfaces.Info;
import Interfaces.Jump;
import Interfaces.Swim;

public class Hunter extends Character implements Jump, Swim, Info {

    private boolean swiming;

    public Hunter(int id, String name) {
        this.id  = id;
        this.name = name;
    }

    public void longJump(){
        System.out.println("Hunter " + name + " совершил прыжок в длину");
    }

    public void highJump(){
        System.out.println("Hunter " + name + " совершил прыжок в высоту");
    }

    public void swimStart() {
        if (swiming){           // swiming = true присваевается если был вызов метода swimStart(), и сбрасывается на false при вызове swimStop()
            System.out.println("Hunter " + name + " уже и так плывет");
        }else {
            swiming = true;
            System.out.println("Hunter " + name + " начал плыть");
        }
    }

    public void swimStop() {
        swiming = false;
        System.out.println("Hunter " + name + " перестал плыть");
    }

    public void showInfo(){
        System.out.println("Свойства персонажа Hunter " + name + ": ID = " + id );
    }
}
