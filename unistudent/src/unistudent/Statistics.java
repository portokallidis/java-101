package unistudent;

import java.util.List;
import java.util.HashMap;

public class Statistics {
    
    /**
     * 
     * @param students
     * @param studentCourses
     */
    static public List calculateMeanGradePerStudent(List<Student> students, List<StudentCourse> studentCourses){
        
        List<String> output;
        // Map<StudentId,GradeSum> 
        HashMap<Int,Int> CourseGradeSumPerStudent;
        // Map<StudentId,GradeCounter>
        HashMap<Int,Int> CourseCountPerStudent;
        Int curSum, curCount;
        Float mean;

        for (int i = 0; i < studentCourses.size(); i++) { 
            StudentCourse sc = studentCourses.get(i);
            
            if(CourseGradeSumPerStudent.containsKey(sc.getStudentId())) {
                curSum = CourseGradeSumPerStudent.get(sc.getStudentId());
                CourseGradeSumPerStudent.set(sc.getStudentId(), curSum + sc.getGrade());

                // CourseCountPerStudent<studentId,count> should also exist
                curCount = CourseCountPerStudent.get(sc.getStudentId());
                CourseCountPerStudent.set(sc.getStudentId(), curCount+1);
            } else {
                CourseGradeSumPerStudent.set(sc.getStudentId(),sc.getGrade());
                CourseCountPerStudent.set(sc.getStudentId(),1);
            }
        }

        for (int i = 0; i < students.size(); i++) { 
            Student s = students.get(i);
            mean = CourseGradeSumPerStudent.get(s.getId()) / CourseCountPerStudent.get(s.getId());
            output.push(s.getName()+" "+ mean.toString());
        }

        return output;

    }

    /**
     * 
     * @param courses
     * @param studentCourses
     */
    static public List calculateMeanGradePerCourse(List<Course> courses, List<StudentCourse> studentCourses){

        List<String> output;
        // Map<CourseId,GradeSum> 
        HashMap<Int,Int> StudentGradeSumPerCourse;
        // Map<CourseId,GradeCounter>
        HashMap<Int,Int> StudentCountPerCourse;
        Int curSum, curCount;
        Float mean;

        for (int i = 0; i < studentCourses.size(); i++) { 
            StudentCourse sc = studentCourses.get(i);
            
            if(StudentGradeSumPerCourse.containsKey(sc.getStudentId())) {
                curSum = StudentGradeSumPerCourse.get(sc.getStudentId());
                StudentGradeSumPerCourse.set(sc.getStudentId(), curSum + sc.getGrade());

                // StudentCountPerCourse<studentId,count> should also exist
                curCount = StudentCountPerCourse.get(sc.getStudentId());
                StudentCountPerCourse.set(sc.getStudentId(), curCount+1);
            } else {
                StudentGradeSumPerCourse.set(sc.getStudentId(),sc.getGrade());
                StudentCountPerCourse.set(sc.getStudentId(),1);
            }
        }

        for (int i = 0; i < students.size(); i++) { 
            Student s = students.get(i);
            mean = StudentGradeSumPerCourse.get(s.getId()) / StudentCountPerCourse.get(s.getId());
            output.push(s.getName()+" "+ mean.toString());
        }

        return output;
    }

    

}
