package Model;

import Model.FileUtilities.DirManager;

import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by Alejandro on 6/9/2016.
 */
public class Account {
    public Account(){
    }
    //shitton of cache
    Random rng = new Random();
    private Path mAccountDirectory = null;
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
    private String mAccountCode = null;

    //method for setting up random unique code for each account
    public void setAccountCode(){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String accountCode = "";
        for(int i = 0;i<6;i++){
            accountCode+= alphabet.charAt(rng.nextInt(alphabet.length()));
        }
        mAccountCode = accountCode;
    }
    public String getAccountCode(){
        if(mAccountCode==null){
            setAccountCode();
        }
        return mAccountCode;
    }
    public void setAccountDirectory(Path accountDirectoryPath){
        mAccountDirectory = accountDirectoryPath;
    }
    public Path getAccountDirectory(){
        return mAccountDirectory;
    }
    private String mAccountAdmin;
    public String getAccountAdmin() {return mAccountAdmin;}

    public void setAccountAdmin(String accountAdmin) {mAccountAdmin = accountAdmin;}

    public boolean isDidAdministratorConfirm() {
        return didAdministratorConfirm;
    }

    public void setDidAdministratorConfirm(boolean didAdministratorConfirm) {this.didAdministratorConfirm = didAdministratorConfirm;}

    public boolean isDidOwnerConfirm() {
        return didOwnerConfirm;
    }

    public void setDidOwnerConfirm(boolean didOwnerConfirm) {
        this.didOwnerConfirm = didOwnerConfirm;
    }
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
