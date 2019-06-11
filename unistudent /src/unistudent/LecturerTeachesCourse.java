package unistudent;

public class Lecturer {

    private String name;
    private String phone;
    private String email;
    private String id;

    public Lecturer( String n, String p, String e, String a) {
        this.name = n;
        this.phone = p;
        this.email = e;
        this.id = a;
    }

    public String show () {
        return this.name + " " + this.phone + " " + this.email + " " + this.id;
    }
    public String getPhone () {
        return this.phone;
    }
    public String getName () {
        return this.name;
    }


    public void editName (String data) {
        this.name = data;
    }
    public void editPhone (String data) {
        this.phone = data;
    }
    public void editEmail (String data) {
        this.email = data;
    }
    public void editAddress (String data) {
        this.id = data;
    }

}
