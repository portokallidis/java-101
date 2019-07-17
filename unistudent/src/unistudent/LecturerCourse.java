package unistudent;

import java.io.Serializable;

public class LecturerCourse implements Serializable {

    private int lecturerId;
    private int courseId;

    /**
     * We set LecturerCourse's parameters
     * @param lecturerId
     * @param courseId
     */
    public LecturerCourse( int lecturerId, int courseId) {
        this.lecturerId = lecturerId;
        this.courseId = courseId;
    }

    /**
     * We ask for the LecturerCourse's parameters
     * @param lecturerId
     * @param courseId
     */

    public int getLecturerId(){ 
        return this.lecturerId; 
    }
    public int getCourseId(){ 
        return this.courseId; 
    }
    
}
