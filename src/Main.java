import students.StudentService;
import students.Student;

public class Main {

    public static void main(String[] args) {
	    StudentService studentService = new StudentService();
	    //TODO refactor this code to use encapsulation inside studentsService
      studentService.addStudent( new Student( "Carlos", "1030", 31 ) );
      studentService.addStudent( new Student( "Ian", "1020", 28 ) );
      studentService.addStudent( new Student( "Elise", "1021", 26 ) );
      studentService.addStudent( new Student( "Santiago", "1020", 33 ) );

      try {
        studentService.enrollStudents( "Chemistry", "1030" );
        studentService.enrollStudents( "Math", "1020" );
        studentService.enrollStudents( "Math", "1021" );
      } catch (Exception e) {
        System.out.println("Sucedió un error..." + e);
      }

      studentService.showEnrolledStudents("Math");
      studentService.showAllCourses();
    }
}