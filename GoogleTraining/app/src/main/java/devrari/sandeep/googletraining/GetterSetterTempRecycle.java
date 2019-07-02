package devrari.sandeep.googletraining;

/**
 * Created by user on 30/3/18.
 */

class GetterSetterTempRecycle {
    private int image;
    private String name;

    GetterSetterTempRecycle(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
