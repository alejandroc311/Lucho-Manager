package Model.FileUtilities;

import Model.Account;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alejandro on 7/12/2016.
 */
public class DirManager {
    //abstract class that will deal with directory creation and management of a each account.

    //cached variables for the creation of the programs root directory
    private Path mRootDirectoryPath;
    private Path mRootDirectory;
    //cachedc variables for the creation of the account directory where the info will be stored
    private Path mAccountDirectoryPath;
    private Path mAccountDirectory;
    private Path mAccountDirectoryChildPath;
    private Path mAccountDirectoryChild;

    public Path getAccountDirectoryChildPath() {
        return mAccountDirectoryChildPath;
    }

    public Path getAccountDirectoryChild(Account account) {
        if(mAccountDirectoryChild == null){
            mAccountDirectoryChild = account.getAccountDirectory();
        }
        return mAccountDirectoryChild;
    }

    public SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");



    // the constructor, when the object is declared it creates the root directory, if there is none.
    // the object has methods for setting the directories of the account and fetching the directories.

    public DirManager(){
        mRootDirectoryPath = Paths.get(System.getProperty("user.home"),"FiMan");
        try{
            if(Files.exists(mRootDirectoryPath)){
                System.out.println("Folder already exists");

            }
            if(Files.notExists(mRootDirectoryPath)){
                mRootDirectory = Files.createDirectory(mRootDirectoryPath);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //accessor methods
    //some methods will return simply the path of a directory
    //the other methods return the directory object

    public Path getRootDirectoryPath() {
        return mRootDirectoryPath;
    }
    // the get methods check if the object has a null value, if it does have a null value it will assign the
    //directory object values from the account directory member variable, as seen below
    public Path getRootDirectory(Account account) {
        if(mRootDirectory == null){
            mRootDirectory = account.getAccountDirectory().getParent().getParent();
        }
        return mRootDirectory;
    }

    public Path getAccountDirectoryPath() {return mAccountDirectoryPath;}

    //same as other get method
    public Path getAccountDirectory(Account account) {
        if(mAccountDirectory == null){
            mAccountDirectory = account.getAccountDirectory().getParent();
        }
        return mAccountDirectory;
    }


    //method for setting up the name of the directory where a clients root child directory will be set
    public void setAccountDirectory(Account account){
            mAccountDirectoryPath = Paths.get(getRootDirectoryPath().toString(),account.getAccountOwner());
            try{
                if(Files.exists(mAccountDirectoryPath)) {
                    System.out.println("Folder already exists");
                }
                if(Files.notExists(mAccountDirectoryPath)){
                    mAccountDirectory = Files.createDirectory(mAccountDirectoryPath);
                }

            }catch(IOException e){
                e.printStackTrace();
            }
    }
    //for being able to distinguish accounts with the same owner name, each code is assigned a random code
    //the directory child of the account name directory will be the random unique code
    //for example : C:/users/username/root/lucho/rtewy
    public void setAccountDirectoryChild(Account account){
        mAccountDirectoryChildPath = mAccountDirectoryPath.resolve(account.getAccountCode());
        try{
            if(Files.exists(mAccountDirectoryChildPath)){
                System.out.println("Folder already exists");
            }

            if(Files.notExists(mAccountDirectoryChildPath)){
                mAccountDirectoryChild = Files.createDirectory(mAccountDirectoryChildPath);
                account.setAccountDirectory(mAccountDirectoryChild);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
















