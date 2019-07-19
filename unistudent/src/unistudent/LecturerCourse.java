package unistudent;

import java.io.Serializable;

public class LecturerCourse implements Serializable {

    private int lecturerId;
    private int courseId;

    /**
     * We set the parameters for public class LecturerCourse
     * @param lecturerId
     * @param courseId
     */
    public LecturerCourse( int lecturerId, int courseId) {
        this.lecturerId = lecturerId;
        this.courseId = courseId;
    }

    public int getLecturerId(){ 
        return this.lecturerId; 
    }
    public int getCourseId(){ 
        return this.courseId; 
    }
    
}
