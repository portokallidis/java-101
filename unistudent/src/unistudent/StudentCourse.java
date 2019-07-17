package unistudent;

import java.io.Serializable;

public class StudentCourse implements Serializable {

    private int studentId;
    private int courseId;
    private int grade;

    /**
     * We set StudentCourse's parameters
     * @param studentId
     * @param courseId
     */
    public StudentCourse( int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
        // this.grade = null;
    }

    /**
     * We ask for StudentCourse's parameters
     * @param studentId
     * @param courseId
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
     * We set StudentCourse's grade
     * @return grade
     */
    public void setGrade (int grade) {
        this.grade = grade;
    }

}
