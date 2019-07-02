package devrari.sandeep.ocrapp.pojo_classes;

import java.util.TreeSet;

/**
 * Created by Angry on 4/15/2018.
 */

public class FoldersWithImagesGETSET {
    private TreeSet<String> folderImages;
    private String folderName;

    public FoldersWithImagesGETSET(){
        folderImages=new TreeSet<>();
    }
    public TreeSet<String> getFolderImages() {
        return folderImages;
    }

    public void setFolderImages(TreeSet<String> folderImages) {
        this.folderImages = folderImages;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

}
