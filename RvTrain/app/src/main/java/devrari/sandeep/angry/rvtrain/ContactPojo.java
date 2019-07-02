package devrari.sandeep.angry.rvtrain;

/**
 * Created by Angry on 4/10/2018.
 */

public class ContactPojo {
    private int Id;
    private String name,number;

    public ContactPojo(int id, String name, String number) {
        Id = id;
        this.name = name;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
