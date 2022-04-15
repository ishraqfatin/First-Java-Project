/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfcapplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Branch implements Serializable {

    private String branchName = null, branchAddress = null, branchPhone = null, branchEmail = null;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getBranchPhone() {
        return branchPhone;
    }

    public void setBranchPhone(String branchPhone) {
        this.branchPhone = branchPhone;
    }

    public String getBranchEmail() {
        return branchEmail;
    }

    public void setBranchEmail(String branchEmail) {
        this.branchEmail = branchEmail;
    }

    public Branch(String branchName, String branchAddress, String branchPhone, String branchEmail) {
        this.branchName = branchName;
        this.branchAddress = branchAddress;
        this.branchPhone = branchPhone;
        this.branchEmail = branchEmail;
    }

    public void addBranchObjectToBin() {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        if ("".equals(branchName) || "".equals(branchAddress) || "".equals(branchPhone) || "".equals(branchEmail)) {
            System.out.println("Null Fields");
        } else {

            try {
                f = new File("Branch.bin");
                if (f.exists()) {
                    fos = new FileOutputStream(f, true);
                    oos = new AppendableObjectOutputStream(fos);
                } else {
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                }
                try {
                    oos.writeObject(this);
                    oos.close();
                } catch (IOException ex) {
                    System.out.println("ERRrrr");
                }

            } catch (Exception ex) {
                System.out.println("File Saved");
            }
        }

    }

    @Override
    public String toString() {
        return "name=" + branchName + ", address=" + branchAddress
                + ", email=" + branchEmail
                + ", phone=" + branchPhone
                + "\n";
    }

}
