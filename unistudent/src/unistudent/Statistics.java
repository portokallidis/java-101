package unistudent;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class Statistics {
    
    /**
     * 
     * @param students
     * @param studentCourses
     */

    static final String GRAPH_CHAR = "###";
    static final int GRAPH_RULER = 14;

    static public void calculateMeanGradePerStudent(List<Student> students, List<StudentCourse> studentCourses, boolean SHOW_GRAPH){
        
        // List<String> output;
        // Map<StudentId,GradeSum> 
        Map<Integer,Integer> CourseGradeSumPerStudent = new HashMap<>();
        // Map<StudentId,GradeCounter>
        Map<Integer,Integer> CourseCountPerStudent = new HashMap<>();
        int curSum, curCount;
        Float mean;
        String tmp;
        int courseCount;
        boolean availableResults = false;
        int ruler;

        for (int i = 0; i < studentCourses.size(); i++) { 
            StudentCourse sc = studentCourses.get(i);
            
            if(CourseGradeSumPerStudent.containsKey(sc.getStudentId())) {
                curSum = CourseGradeSumPerStudent.get(sc.getStudentId());
                CourseGradeSumPerStudent.put(sc.getStudentId(), curSum + sc.getGrade());

                // CourseCountPerStudent<studentId,count> should also exist
                curCount = CourseCountPerStudent.get(sc.getStudentId());
                CourseCountPerStudent.put(sc.getStudentId(), curCount+1);
            } else {
                CourseGradeSumPerStudent.put(sc.getStudentId(),sc.getGrade());
                CourseCountPerStudent.put(sc.getStudentId(),1);
            }
        }

        for (int i = 0; i < students.size(); i++) { 
            Student s = students.get(i);
            try {
                courseCount = CourseCountPerStudent.get(s.getId());
            } catch(Exception e) {
                courseCount = 0;
            }
            if(courseCount>0) {
                availableResults = true;
                mean = (float) CourseGradeSumPerStudent.get(s.getId()) / courseCount;
                tmp = s.getName() + " ";
                if(SHOW_GRAPH) {
                    tmp += String.join("", Collections.nCopies(GRAPH_RULER-tmp.length()," "))+"|";
                    tmp += String.join("", Collections.nCopies(Math.round(mean), GRAPH_CHAR)); 
                    tmp += " "+mean.toString();
                    // Java 11: GRAPH_CHAR.repeat(mean)
                } else {
                    tmp += mean.toString();
                }
                System.out.println(tmp);
            }
            // output.push(tmp);
        }
        
        if(!availableResults) {
            System.out.println("Not enough data.");
        }

        // return output;

    }

    /**
     * 
     * @param courses
     * @param studentCourses
     */
    static public void calculateMeanGradePerCourse(List<Course> courses, List<StudentCourse> studentCourses, boolean SHOW_GRAPH){

        // List<String> output;
        // Map<CourseId,GradeSum> 
        Map<Integer,Integer> StudentGradeSumPerCourse = new HashMap<>();
        // Map<CourseId,GradeCounter>
        Map<Integer,Integer> StudentCountPerCourse = new HashMap<>();
        int curSum, curCount;
        Float mean;
        String tmp;
        int studentCount;
        boolean availableResults = false;

        for (int i = 0; i < studentCourses.size(); i++) { 
            StudentCourse sc = studentCourses.get(i);
            
            if(StudentGradeSumPerCourse.containsKey(sc.getCourseId())) {
                curSum = StudentGradeSumPerCourse.get(sc.getCourseId());
                StudentGradeSumPerCourse.put(sc.getCourseId(), curSum + sc.getGrade());

                // StudentCountPerCourse<studentId,count> should also exist
                curCount = StudentCountPerCourse.get(sc.getCourseId());
                StudentCountPerCourse.put(sc.getCourseId(), curCount+1);
            } else {
                StudentGradeSumPerCourse.put(sc.getCourseId(),sc.getGrade());
                StudentCountPerCourse.put(sc.getCourseId(),1);
            }
        }

        for (int i = 0; i < courses.size(); i++) { 
            Course c = courses.get(i);
            try {
                studentCount = StudentCountPerCourse.get(c.getId());
            } catch(Exception e) {
                studentCount = 0;
            }
            if(studentCount>0) {
                availableResults = true;
                mean = (float) StudentGradeSumPerCourse.get(c.getId()) / studentCount;
                tmp = c.getTitle() + " ";
                if(SHOW_GRAPH) {
                    tmp += String.join("", Collections.nCopies(GRAPH_RULER-tmp.length()," "))+"|";
                    tmp += String.join("", Collections.nCopies(Math.round(mean), GRAPH_CHAR)); 
                    tmp += " "+mean.toString();
                    // Java 11: "##".repeat(Math.round(mean))
                } else {
                    tmp += mean.toString();
                }
                System.out.println(tmp);
            }
            // output.push(tmp);
        }

        if(!availableResults) {
            System.out.println("Not enough data.");
        }

        // return output;
    }

    

}
