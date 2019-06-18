package unistudent;


import java.io.Serializable;

public class Lecturer implements Serializable {

    private int id;
    private String name;
    private String phone;
    private String email;
    private String scientificField;


    /**
     * 
     * @param id
     * @param name
     * @param phone
     * @param email
     * @param scientificField
     */
    public Lecturer( int id, String name, String phone, String email, String scientificField ){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.scientificField = scientificField;
    }

    public String show(){
        return this.id + " " + this.name + " " + this.phone + " " + this.email + " " + this.scientificField;
    }
    
    /**
     * Gettters
     * 
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
    public String getScientificField(){ 
        return this.scientificField; 
    }
    
    /**
     * Setters
     * 
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
    public String setScientificField(String scientificField){ 
        this.scientificField = scientificField; 
        return this.scientificField; 
    }
    

}
