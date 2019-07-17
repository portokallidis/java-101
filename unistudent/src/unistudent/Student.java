package unistudent;
import java.io.Serializable;

public class Student implements Serializable {

    private int id;
    private String name;
    private String phone;
    private String email;
    private String semester;

    /**
     * We set the Student's parameters
     * @param id
     * @param name
     * @param phone
     * @param email
     * @param semester
     */
    public Student( int id, String name, String phone, String email, String semester){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.semester = semester;
    }
    
    public String show(){
        return this.id + " " + this.name + " " + this.phone + " " + this.email + " " + this.semester;
    }

    /**
     * We ask for the Student's parameters
     * @param id
     * @param name
     * @param phone
     * @param email
     * @param semester
     */

    public int getId(){ 
        return this.id; 
    }
    public String getName(){ 
        return this.name; 
    }
    public String getPhone(){ 
        return this.phone; 
    }
    public String getEmail(){ 
        return this.email; 
    }
    public String getSemester(){ 
        return this.semester; 
    }
    
    /**
     * We take back the asked Student's parameters
     * @return id
     * @return name
     * @return phone
     * @return email
     * @return semester
     */

    public int setId(int id){ 
        this.id = id; 
        return this.id; 
    }
    public String setName(String name){ 
        this.name = name; 
        return this.name; 
    }
    public String setPhone(String phone){ 
        this.phone = phone; 
        return this.phone; 
    }
    public String setEmail(String email){ 
        this.email = email; 
        return this.email; 
    }
    public String setSemester(String semester){ 
        this.semester = semester; 
        return this.semester; 
    }
    
}
