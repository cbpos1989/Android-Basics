package cbpos1989.com.person;

/**
 * Class to hold state and behaviour for a Person object.
 *
 * Created by Colm O'Sullivan on 07/10/2015.
 */
public class Person {

    private int id;
    private String name;
    private String phoneNumber;
    private String email;

    public Person(){
        this(0,null,null,null);
    }

    public Person(int id, String name, String phoneNumber, String email) {
        setId(id);
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    public Person(String name, String phoneNumber, String email){
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return getName();
    }
}
