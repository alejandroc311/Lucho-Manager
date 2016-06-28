package Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Alejandro on 6/9/2016.
 */
public class Account {
    public Account(){}

    public boolean isDidAdministratorConfirm() {
        return didAdministratorConfirm;
    }

    public void setDidAdministratorConfirm(boolean didAdministratorConfirm) {
        this.didAdministratorConfirm = didAdministratorConfirm;
    }

    public boolean isDidOwnerConfirm() {
        return didOwnerConfirm;
    }

    public void setDidOwnerConfirm(boolean didOwnerConfirm) {
        this.didOwnerConfirm = didOwnerConfirm;
    }

    private boolean didOwnerConfirm = false;
    private boolean didAdministratorConfirm = false;
    private String mAccountOwner;
    private int mAccountNumber;
    private double mMoneyInvested;
    private double mMoneyWonOrLost;
    private Date mDateCreated = new Date();
    private Date mDateClosed;
    private Calendar mCalendar = Calendar.getInstance();
    private java.sql.Date mDateCreatedSQL = new java.sql.Date(mCalendar.getTime().getTime());
    private SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd HH:mm:ss");

    public java.sql.Date getDateCreatedSQL(){
        return mDateCreatedSQL  ;
    }

    public String getAccountOwner() {
        return mAccountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        mAccountOwner = accountOwner;
    }

    public int getAccountNumber() {
        return mAccountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        mAccountNumber = accountNumber;
    }

    public double getMoneyInvested() {
        return mMoneyInvested;
    }

    public void setMoneyInvested(double moneyInvested) {
        mMoneyInvested = moneyInvested;
    }

    public double getMoneyWonOrLost() {
        return mMoneyWonOrLost;
    }

    public void setMoneyWonOrLost(double moneyWonOrLost) {
        mMoneyWonOrLost = moneyWonOrLost;
    }

    public Date getDateCreated() {
        return mDateCreated;
    }

    public String getDateCreationString() {

        return sdf.format(getDateCreated());
    }



    public Date getDateClosed() {
        return mDateClosed;
    }

    public void setDateClosed(Date dateClosed) {
        mDateClosed = dateClosed;
    }

    public String getDateClosedString(){
        return sdf.format(getDateClosed());
    }
}
