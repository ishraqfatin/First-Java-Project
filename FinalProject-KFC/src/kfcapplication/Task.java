/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfcapplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author Ishraq Fatin
 */
public class Task implements Serializable {

    String taskNo, task ;
    LocalDate taskDate;
    int doerId;
    Boolean taskStatus=false;

   
    
    public static void taskToBin(ObservableList<Task> i){
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Tasks.bin");
            
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            for(Task a : i)
            oos.writeObject(a);

        } catch (IOException ex) {
            Logger.getLogger(LeaveRequestController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(LeaveRequestController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    public static void replaceTaskBin(ObservableList<Task> i){
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Tasks.bin");
            
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            
            
            for(Task a : i)
            oos.writeObject(a);

        } catch (IOException ex) {
            Logger.getLogger(LeaveRequestController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(LeaveRequestController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public static void completedTasksToBin(ObservableList<Task> i){
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("TasksCompleted.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            
            for(Task a : i)
            oos.writeObject(a);

        } catch (IOException ex) {
            Logger.getLogger(LeaveRequestController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(LeaveRequestController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }

    public Task(String taskNo, String task, LocalDate taskDate, int doerId) {
        this.taskNo = taskNo;
        this.task = task;
        this.taskDate = taskDate;
        this.doerId = doerId;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDate taskDate) {
        this.taskDate = taskDate;
    }

    public int getDoerId() {
        return doerId;
    }

    public void setDoerId(int doerId) {
        this.doerId = doerId;
    }

    public Boolean getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

}
