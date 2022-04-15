/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfcapplication;

import java.io.Serializable;

/**
 *
 * @author Ishraq Fatin
 */
public class HumanResources extends User implements Serializable {
    
    public HumanResources(int id, String name, String userType, String email, String password, String branch,String phone) {
        super(id, name, userType, email, password, branch, phone);
    
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
