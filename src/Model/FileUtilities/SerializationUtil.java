package Model.FileUtilities;

import Model.Account;

import java.io.*;

/**
 * Created by Alejandro on 7/30/2016.
 */
public class SerializationUtil {
    public static Account deserializeAccount (File filname)throws IOException,ClassNotFoundException{
        FileInputStream fis = null;BufferedInputStream bis = null;ObjectInputStream ois = null;Account account = null;
        try{
            fis = new FileInputStream(filname);
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);
            account = (Account) ois.readObject();
        }catch(Exception e){
            e.printStackTrace();
        }
        return account;
    }
    public static void serializeAccount(Account account, File filename){
        FileOutputStream fos = null; BufferedOutputStream bos = null; ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(filename);
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);
            oos.writeObject(account);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
