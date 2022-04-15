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

public class Query implements Serializable{

    private String dep, sub, query, queryReply, replierDep;
    private LocalDate date, replyDate;
    private int id, replierId;

    public void saveQueryToFile() {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("Query.bin");

            
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            System.out.println("Saving...");
            oos.writeObject(this);
        } catch (IOException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void saveQueryReplyToFile() {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("QueryReply.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(this);
        } catch (IOException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public void replaceQueryBin(ObservableList<Query> a) {

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Query.bin");
            
            
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            
            try {
                System.out.println("Print hoise");
                for (Query i : a) {
                    oos.writeObject(i);
                }
                oos.close();
            } catch (IOException ex) {
            }
        } catch (Exception ex) {

        }
    }

    public Query(String dep, String sub, LocalDate date, int id, String query) {
        this.dep = dep;
        this.sub = sub;
        this.date = date;
        this.id = id;
        this.query = query;
    }

    public String getReplierDep() {
        return replierDep;
    }

    public void setReplierDep(String replierDep) {
        this.replierDep = replierDep;
    }

    public int getReplierId() {
        return replierId;
    }

    public void setReplierId(int replierId) {
        this.replierId = replierId;
    }

    public LocalDate getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(LocalDate replyDate) {
        this.replyDate = replyDate;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQueryReply() {
        return queryReply;
    }

    public void setQueryReply(String queryReply) {
        this.queryReply = queryReply;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String toStringReply() {
        String t = "Reply on Subject: " + sub + "\n"
                
                + "Date: " + replyDate + "\n"
                + "From " + replierId + ", " + replierDep + "\n"
                + "Replying to: " + id + ", " + dep + "\n"
                +"[ Query: "+query+" ] \n"
                + "Reply: " + queryReply;
        
        return t;
    }
    
    public String toStringQuery() {
        String t = "Subject: " + sub + "\n"
                + "Date: " + date + "\n"
                +"ID: "+id+", "+dep+"\n"
                + "To Human Resources"+ "\n"
                + "\n" + query;
        
        return t;
    }

}
