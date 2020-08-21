import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Person <T> {
    private List<T> persons;
    private int id = 0;
    private String name;
    private String phone;
    private String dateOfBirth;
    private String editTimeStamp;


    public Person() {
       // incrementId();
        changed();
    }

    public Person(String name, String phone, String dateOfBirth) {
        this.name = name;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
      //  incrementId();
        changed();
    }

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
       // incrementId();
        changed();

    }



    public void add (T t){
        persons.add(t);
    }
//    // Person search
//    public static void findPerson(String searchType, String searchString) {
//
//        for (Person person: ekstensja) {
//
//
//            switch (searchType) {
//
//                case "1":
//                    if (searchType == "1" && person.name == searchString)
//                        System.out.println(person);
//                    //FIND BY NAME
//                    break;
//                case "2":
//                    if (searchType == "2" && person.phone == searchString)
//                        System.out.println(person);
//                    //FIND BY PHONE
//                    break;
//                case "3":
//                    if (searchType == "3" && person.email == searchString)
//                        System.out.println(person);
//                    //FIND BY EMAIL
//                    break;
//            }
//
//        }
//    }


    public String getEditTimeStamp() {
        return editTimeStamp;
    }

    public void setEditTimeStamp(String editTimeStamp) {
        this.editTimeStamp = editTimeStamp;
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

    public String getDateOfBirth() {
        return dateOfBirth;
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

    private void incrementId() {
        this.id++;
    }

    public int getCurrentId(){
        return id;
    }

    public void  setId(int id){
        this.id = id;
    }

     private void changed() {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        this.editTimeStamp = format.format(new GregorianCalendar().getTime());
    }
      }


