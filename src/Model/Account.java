package Model;

import java.util.Date;

/**
 * Created by Alejandro on 6/9/2016.
 */
public class Account {
    public Account(){}
    private String mAccountOwner;
    private int mAccountNumber;
    private double mMoneyInvested;
    private double mMoneyWonOrLost;
    private Date mDateCreated;
    private Date mDateClosed;

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

    public void setDateCreated(Date dateCreated) {
        mDateCreated = dateCreated;
    }

    public Date getDateClosed() {
        return mDateClosed;
    }

    public void setDateClosed(Date dateClosed) {
        mDateClosed = dateClosed;
    }
}
