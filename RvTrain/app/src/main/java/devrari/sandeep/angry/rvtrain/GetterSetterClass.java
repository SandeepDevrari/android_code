package devrari.sandeep.angry.rvtrain;

/**
 * Created by Angry on 3/29/2018.
 */

class GetterSetterClass {
    private int image;
    private String name;

    GetterSetterClass(int image, String name) {
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
