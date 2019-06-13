package unistudent;

import java.io.Serializable;

public class LecturerCourse implements Serializable {

    private int lecturerId;
    private int courseId;

    /**
     * @
     * @param lecturerId
     * @param courseId
     */
    public LecturerCourse( int lecturerId, int courseId) {
        this.lecturerId = lecturerId;
        this.courseId = courseId;
    }

    /**
     * Gettters
     * 
     */

    public int getLecturerId(){ 
        return this.lecturerId; 
    }
    public int getCourseId(){ 
        return this.courseId; 
    }
    
}
