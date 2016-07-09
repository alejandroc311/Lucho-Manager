package SerializationUtilities;

import Model.Account;

import java.io.*;
import java.util.HashMap;

/**
 * Created by Alejandro on 7/2/2016.
 */
// this class declares the object that will serialize the account logbook(a map where the key is the account#
// and the value will be the account)
// this map will be related to some administrator account which will have some number.
public class AccountSerializationIUtil {
    // this returns a hashmap with an integer as a key and an account object from the model folder as a value
    //from the specified file.
    public static HashMap<Integer, Account> deserializeAccount(File accountFilename)throws IOException, ClassNotFoundException{
        HashMap<Integer,Account> hashMap = null;FileInputStream fis = null;ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(accountFilename);
            ois = new ObjectInputStream(fis);
            hashMap = (HashMap<Integer,Account>) ois.readObject();
            ois.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return hashMap;
    }

    public static void serializeAccount(HashMap<Integer,Account> hashMap, File accountFilename) throws IOException {
        FileOutputStream fos = null;
        ObjectOutput oos = null;
        try{
            fos = new FileOutputStream(accountFilename);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(hashMap);
            oos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
