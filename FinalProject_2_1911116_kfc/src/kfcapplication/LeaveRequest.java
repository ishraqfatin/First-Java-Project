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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

public class LeaveRequest implements Serializable {

    private String reqName, reqBranch, reqDes, reason, typeOfLeave;
    private LocalDate fromDate, toDate;
    private String leaveFormat;
    private int reqId;
    private Boolean istrue;

    public LeaveRequest(String reqName, String reqBranch, String reqDes, String reason, String typeOfLeave, LocalDate fromDate, LocalDate toDate, int reqId, Boolean istrue) {
        this.reqName = reqName;
        this.reqBranch = reqBranch;
        this.reqDes = reqDes;
        this.reason = reason;
        this.typeOfLeave = typeOfLeave;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.reqId = reqId;
        this.istrue = istrue;
    }

    public void sendRequest() {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("LeaveRequest.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(this);

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

    public void removeRequest(ObservableList<LeaveRequest> i) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("LeaveRequest.bin");

            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);

            for (LeaveRequest a : i) {
                oos.writeObject(a);
            }

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

    public void approvedRequests() {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("ApprovedLeaveRequest.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(this);

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

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName;
    }

    public String getReqBranch() {
        return reqBranch;
    }

    public void setReqBranch(String reqBranch) {
        this.reqBranch = reqBranch;
    }

    public String getReqDes() {
        return reqDes;
    }

    public void setReqDes(String reqDes) {
        this.reqDes = reqDes;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTypeOfLeave() {
        return typeOfLeave;
    }

    public void setTypeOfLeave(String typeOfLeave) {
        this.typeOfLeave = typeOfLeave;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getLeaveFormat() {
        return leaveFormat;
    }

    public void setLeaveFormat(String leaveFormat) {
        this.leaveFormat = leaveFormat;
    }

    public int getReqId() {
        return reqId;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public Boolean getIstrue() {
        return istrue;
    }

    public void setIstrue(Boolean istrue) {
        this.istrue = istrue;
    }

    public String makeFormat() {
        leaveFormat = "I, " + reqName + ", ID:" + reqId + ", Branch: " + reqBranch + "\n" + reqDes
                + ",\nwish to apply for " + typeOfLeave + " leave because of " + reason
                + "\nfrom " + fromDate + " to " + toDate + ".";

        return leaveFormat;
    }
}
