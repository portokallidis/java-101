package unistudent;

import java.io.Serializable;

public class StudentCourse implements Serializable {

    private int studentId;
    private int courseId;
    private int grade;

    /**
     * We set the parameters for public class StudentCourse
     * @param studentId
     * @param courseId
     * @param grade
     */
    public StudentCourse( int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
        // this.grade = null;
    }


    public int getStudentId(){ 
        return this.studentId; 
    }
    public int getCourseId(){ 
        return this.courseId; 
    }
    public int getGrade(){ 
        return this.grade; 
    }
    
   
    public void setGrade (int grade) {
        this.grade = grade;
    }

}
