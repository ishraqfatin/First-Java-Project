/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfcapplication;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ishraq Fatin
 */
public abstract class User implements Serializable {
    
    protected int id;
    protected String name,userType,email,password,branch, phone;

    public User(int id, String name, String userType, String email, String password, String branch,String phone) {
        this.id = id;
        this.name = name;
        this.userType = userType;
        this.email = email;
        this.password = password;
        this.branch = branch;
        this.phone = phone;
    }
 
    public static User verifyLogin(int id, String password, String userType, String branch){
       ArrayList<User> u = UserList.userListBin();
       for(User i: u)
       {
           if(i.getId()==id && i.getPassword().equals(password) && i.getUserType().equals(userType) && i.getBranch().equals(branch)){
               return i;
           }
       }
        return null;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
    
    @Override
    public  String toString() {
            return "id=" + id + ", name=" + name + ", pass="+password 
                    +", desig=" + userType
                    +", email="+email
                    + ", branch=" + branch
                    +"\n";
    }
}
