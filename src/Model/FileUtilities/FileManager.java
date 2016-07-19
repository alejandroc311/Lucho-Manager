package Model.FileUtilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Alejandro on 7/12/2016.
 */
public class FileManager {
    private Path mRootDirectoryPath;
    private Path mRootDirectory;

    public FileManager(){
        mRootDirectoryPath = Paths.get(System.getProperty("user.home"),"FiMan");
        try{
            if(Files.notExists(mRootDirectoryPath)){
                mRootDirectory = Files.createDirectory(mRootDirectoryPath);
            }
            if(Files.exists(mRootDirectoryPath)){
                System.out.println("File already exists");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public Path getRootDirectoryPath() {
        return mRootDirectoryPath;
    }

    public Path getRootDirectory() {
        return mRootDirectory;
    }

    public void addAccountDirectory(){
        Path accountDirectory;Path accountDirectoryPath;
        
    }
}












