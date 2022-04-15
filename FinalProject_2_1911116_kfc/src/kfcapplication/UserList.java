/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfcapplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;

public class UserList {

    public void addUser(int id, String name, String userType, String email, String password, String branch, String phone) {
        if (null != userType) {
            switch (userType) {
                case "Franchise Manager": {
                    FranchiseManager tempUser = new FranchiseManager(id, name, userType, email, password, branch, phone);
                    addToUserBin(tempUser);
                    break;
                }
                case "Branch Manager": {
                    BranchManager tempUser = new BranchManager(id, name, userType, email, password, branch, phone);
                    addToUserBin(tempUser);
                    System.out.println("Branch Manager Created");

                    break;
                }
                case "Human Resources": {
                    HumanResources tempUser = new HumanResources(id, name, userType, email, password, branch, phone);
                    addToUserBin(tempUser);
                    System.out.println("Human Resources Created");

                    break;
                }
                case "Customer Service Representative": {
                    CustomerServiceRepresentative tempUser = new CustomerServiceRepresentative(id, name, userType, email, password, branch, phone);
                    addToUserBin(tempUser);
                    System.out.println("CSR Created");

                    break;
                }
                case "Procurement Manager": {
                    ProcurementManager tempUser = new ProcurementManager(id, name, userType, email, password, branch, phone);
                    addToUserBin(tempUser);
                    System.out.println("Procurement Manager Created");

                    break;
                }
                default:
                    break;
            }
        }
    }

    public void addToUserBin(User u) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("UserList.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {

                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(u);
            System.out.println("Successful");

        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static ArrayList<User> userListBin() {
        ArrayList<User> u = new ArrayList<>();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("UserList.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            User i;
            while (true) {
                i = (User) ois.readObject();
                u.add(i);
            }
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(UserList.class.getName()).log(Level.SEVERE, null, e);
        }

        return u;

    }

}
