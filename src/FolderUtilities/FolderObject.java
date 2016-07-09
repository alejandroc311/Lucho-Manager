package FolderUtilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Alejandro on 7/3/2016.
 */
public class FolderObject {
    private Path mFolderPath = Paths.get("AccountFolders/"+getFolderIdName());
    private Path mAccountAdminFolder;
    private String mFolderIdMark;
    private String mFolderIdName;
    private File mAccountDirectory;

    public Path getFolderPath() {
        return mFolderPath;
    }

    public String getFolderIdName() {
        return mFolderIdName;
    }

    public Path getAccountAdminFolder() {
        return mAccountAdminFolder;
    }

    public String getFolderIdMark() {
        return mFolderIdMark;
    }

    public FolderObject(String folderIdMark){
        mFolderIdMark =folderIdMark;
        try {
            mAccountAdminFolder = Files.createDirectory(getFolderPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
