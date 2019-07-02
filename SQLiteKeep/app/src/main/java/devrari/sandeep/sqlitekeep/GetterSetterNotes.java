package devrari.sandeep.sqlitekeep;

/**
 * Created by user on 5/4/18.
 */

class GetterSetterNotes {
    private int id;
    private String title,msg,time;

    public GetterSetterNotes(){
        super();
    }
    public GetterSetterNotes(int id, String title, String msg, String time) {
        this.id = id;
        this.title = title;
        this.msg = msg;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
