package unistudent;

import java.io.Serializable;

public class StudentCourse implements Serializable {

    private int studentId;
    private int courseId;
    private int grade;

    /**
     * 
     * @param studentId
     * @param courseId
     */
    public StudentCourse( int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
        // this.grade = null;
    }

    /**
     * Gettters
     * 
     */

    public int getStudentId(){ 
        return this.studentId; 
    }
    public int getCourseId(){ 
        return this.courseId; 
    }
    public int getGrade(){ 
        return this.grade; 
    }
    
    /**
     * 
     * Settters
     */
    public void setGrade (int grade) {
        this.grade = grade;
    }

}
