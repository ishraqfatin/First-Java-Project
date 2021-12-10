package fxmlapplicationpkg;

import java.io.Serializable;
import java.time.LocalDate;

public class Student extends Person implements Serializable{  
    int id;  
    String dept;
    float cgpa;
    public Student(int id, String name, LocalDate birthday, String dept, float cgpa) {  
        super(name, birthday);
        this.id = id;  
        this.dept = dept;
        this.cgpa = cgpa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
    
    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }
        
    public int getId() {
        return id;
    }

    public String getDept() {
        return dept;
    }
    
    public float getCgpa() {
        return cgpa;
    }
    
    @Override
    public String toString(){
        return "Id="+id+", Name="+name+", DoB="+birthday+", Dept="+dept+", Cgpa="+cgpa;
    }
    
    public void display(){
        System.out.println("Id="+id+", Name="+name+", DoB="+birthday+", Dept="+dept+", Cgpa="+cgpa);
    }
} 