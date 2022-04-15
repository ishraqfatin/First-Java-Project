package kfcapplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

public class ShortlistEmp implements Serializable {

    private String name, pos, email, phone, remarks, selectedBranch;
    private Boolean status = false;

    public static void saveEmpToBin(ObservableList<ShortlistEmp> a) {

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("ShortlistEmp.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            try {
                System.out.println("Print hoise");
                for (ShortlistEmp i : a) {
                    oos.writeObject(i);
                }
                oos.close();
            } catch (IOException ex) {
            }
        } catch (Exception ex) {

        }
    }

    public static void replaceEmpBin(ObservableList<ShortlistEmp> a) {

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("ShortlistEmp.bin");
            
            
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            
            try {
                System.out.println("Print hoise");
                for (ShortlistEmp i : a) {
                    oos.writeObject(i);
                }
                oos.close();
            } catch (IOException ex) {
            }
        } catch (Exception ex) {

        }
    }

    public ShortlistEmp(String name, String pos, String email, String phone, String remarks, String selectedBranch) {
        this.name = name;
        this.pos = pos;
        this.email = email;
        this.phone = phone;
        this.remarks = remarks;
        this.selectedBranch = selectedBranch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSelectedBranch() {
        return selectedBranch;
    }

    public void setSelectedBranch(String selectedBranch) {
        this.selectedBranch = selectedBranch;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "id=" + name + ", name=" + pos + ", pass=" + email
                + ", desig=" + phone
                + ", email=" + remarks
                + "\n";
    }
}
