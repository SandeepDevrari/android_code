package devrari.sandeep.googletraining.gallery;

import java.util.TreeSet;

/**
 * Created by user on 16/4/18.
 */

public class CustomGalleryGETSET {
    private TreeSet<String> folderImages;
    private String folderName;

    public CustomGalleryGETSET(){
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
