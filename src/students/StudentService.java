package students;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import courses.Course;
import courses.CourseNotFoundException;

public class StudentService
{
    private HashMap<String, Course> courseList = new HashMap<>();

    private HashMap<String, Student> students = new HashMap<>();

    private HashMap<String, List<Course>> coursesEnrolledByStudents = new HashMap<>();


    public StudentService()
    {
        courseList.put( "Math", new Course( "Math", 10, "Aurelio Baldor" ) );
        courseList.put( "Physics", new Course( "Physics", 10, "Albert Einstein" ) );
        courseList.put( "Art", new Course( "Art", 10, "Pablo Picasso" ) );
        courseList.put( "History", new Course( "History", 10, "Sima Qian" ) );
        courseList.put( "Biology", new Course( "Biology", 10, "Charles Darwin" ) );
    }

    public void enrollStudents( String courseName, String studentID ) throws StudentNotFoundException, CourseNotFoundException
    {
        Course course = courseList.get( courseName );
        if (!students.containsKey(studentID)) {
            throw new StudentNotFoundException();
        }
        if (course == null) {
            throw new CourseNotFoundException();
        }

        if ( !coursesEnrolledByStudents.containsKey( studentID ) )
        {
            coursesEnrolledByStudents.put( studentID, new ArrayList<>() );
        }
        coursesEnrolledByStudents.get( studentID ).add( course );
    }

    public void unEnrollStudents( String courseName, String studentID )
    {
        Course course = courseList.get( courseName );

        if ( coursesEnrolledByStudents.containsKey( studentID ) )
        {
            coursesEnrolledByStudents.get( studentID ).remove( course );
        }
    }

    public void showEnrolledStudents(String courseId){
        //TODO implement using collections loops
        Course course = courseList.get(courseId);
        for (String student : coursesEnrolledByStudents.keySet()) {
            if (coursesEnrolledByStudents.get(student).contains(course)) {
                Student studentData = students.get(student);
                System.out.println(studentData.getName());
            }
        }
    }

    public void showAllCourses(){
        //TODO implement using collections loops
        for (Course course : courseList.values()) {
            System.out.println(course.getName());
        }
    }

    public void addStudent(Student student) {
        String studentId = student.getId();
        this.students.put(studentId, student);
    }
}