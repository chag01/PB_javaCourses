import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Person {
    private int id = 0;
    private String name;
    private String phone;
    private String dateOfBirth;
    private String editTimeStamp;


    public Person() {
        changed();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        changed();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        changed();
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        changed();
    }

    @Override
    public String toString() {
        return "ID=" + id +
                ", ФИО=" + name  +
                ", Телефон=" + phone +
                ", Дата рождения=" + dateOfBirth +
                ", Дата редактирования=" + editTimeStamp +
                "\n";
    }


    public void  setId(int id){
        this.id = id;
    }

     private void changed() {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        this.editTimeStamp = format.format(new GregorianCalendar().getTime());
    }
      }


