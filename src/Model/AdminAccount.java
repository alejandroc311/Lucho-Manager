package Model;

import java.util.HashMap;

/**
 * Created by Alejandro on 7/2/2016.
 */
//this class is the model for the account logbook that relates an administrator to a list of accounts
public class AdminAccount {
    public AdminAccount(){}
    private String mAdminUsername;

    public String getAdminUsername() {
        return mAdminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        mAdminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return mAdminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        mAdminPassword = adminPassword;
    }

    public HashMap<Integer, Account> getAdminAccounts() {
        return mAdminAccounts;
    }

    public void setAdminAccounts(HashMap<Integer, Account> adminAccounts) {
        mAdminAccounts = adminAccounts;
    }

    private String mAdminPassword;
    private HashMap<Integer,Account> mAdminAccounts;
}
