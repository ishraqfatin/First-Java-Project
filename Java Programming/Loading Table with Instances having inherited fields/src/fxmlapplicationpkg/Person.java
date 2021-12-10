package fxmlapplicationpkg;

import java.io.Serializable;
import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

public class Person implements Serializable{
    protected String name;
    protected LocalDate birthday;

    public Person(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    } 
    
    public String getName() {
        //return firstName;
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
