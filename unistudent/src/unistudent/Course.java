package unistudent;

import java.io.Serializable;

public class Course implements Serializable {

    private int id;
    private String title;
    private String semester;

   /**
     * We set the parameters for public class Course
     * @param id
     * @param title
     * @param semester
     */
    
    public Course(int id, String title, String semester) {
        this.title = title;
        this.semester = semester;
        this.id = id;
    }
        
    public String show(){
        return this.id + " " + this.title + " " + this.semester;
    }

    public int getId(){ 
        return this.id; 
    }
    public String getTitle(){ 
        return this.title; 
    }
    public String getSemester(){ 
        return this.semester; 
    }
    
    public int setId(int id){ 
        this.id = id; 
        return this.id; 
    }
    public String setTitle(String title){ 
        this.title = title; 
        return this.title; 
    }
    public String setSemester(String semester){ 
        this.semester = semester; 
        return this.semester; 
    }
    
}
