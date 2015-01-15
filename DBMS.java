import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class DBMS {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<StudentTeacher> mergedRecords;
    private Scanner studentSource;
    private Scanner teacherSource;

    public DBMS(Scanner studentSource, Scanner teacherSource) throws IOException {
        this.studentSource = studentSource; 
        this.teacherSource = teacherSource; 
        this.students = new LinkedList<Student>();  //Potentially unnceessary (keep for debug)
        this.teachers = new LinkedList<Teacher>();  //Potentially unnecessary (keep for debug)
        this.mergedRecords = new LinkedList<StudentTeacher>();
        this.parseSource();
    }

    // Parses all the content in Scanner |source|.
    private void parseSource() throws IOException {
        int lineCount = 0;
        String[] line = null;
        // Read in Students
        while (studentSource.hasNext()) {
            line = studentSource.nextLine().split(",");
            ++lineCount;

            for (int i = 0; i < line.length; i++) {
               line[i] = line[i].trim();
            }

            if (line.length == 5) {
                students.add(new Student(line)); 
            } 
            else {
                throw new IOException("Improper STUDENT record at line " + 
                    lineCount + ", exiting.");
            }
        }
        lineCount = 0;
        line = null;
        // Read in Teachers
        while (teacherSource.hasNext()) {
            line = teacherSource.nextLine().split(",");
            ++lineCount;

            for (int i = 0; i < line.length; i++) {
               line[i] = line[i].trim();
            }

            if (line.length == 3) {
                teachers.add(new Teacher(line)); 
            } 
            else {
                throw new IOException("Improper TEACHER record at line " + 
                    lineCount + ", exiting.");
            }
        }
        boolean notFound = true;
        for (Student kid : this.students) {
           for (int i = 0; i < teachers.size() && notFound; i++) {
              if (teachers.get(i).getClassroom() == kid.getClassroom()) {
                 notFound = false;
                 mergedRecords.add(new StudentTeacher(kid, teachers.get(i)));
              }
           }
           notFound = true;
        }
    }

    // Returns a copy of the List |students|.
    public List<Student> getStudents(){
       return new LinkedList<Student>(this.students);
    }

    // Returns a copy of the List |teachers|.
    public List<Teacher> getTeachers(){
       return new LinkedList<Teacher>(this.teachers);
    }

    // Returns a copy of the List |mergedRecords|.
    public List<StudentTeacher> getMerged(){
       return new LinkedList<StudentTeacher>(this.mergedRecords);
    }

    // Returns a List of records of students who's last name equals |lastName|.
    public List<StudentTeacher> studentSearch(String lastName) {
        List<StudentTeacher> rtn = new LinkedList<StudentTeacher>();
        for (StudentTeacher kid : this.mergedRecords) {
            if (kid.getLast().equalsIgnoreCase(lastName)) {
                rtn.add(kid); 
            }
        }
        return rtn; 
    }

    // Returns a List of records of students who are in |lastName|'s class.
    public List<StudentTeacher> teacherSearch(String lastName) {
        List<StudentTeacher> rtn = new LinkedList<StudentTeacher>();
        for (StudentTeacher kid : this.mergedRecords) {
            if (kid.getTeachersLast().equalsIgnoreCase(lastName)) {
                rtn.add(kid); 
            }
        }
        return rtn; 
    }

    // Returns a List of records of students who are in class |classNumber|.
    public List<StudentTeacher> classSearch(int classNumber) {
        List<StudentTeacher> rtn = new LinkedList<StudentTeacher>();
        for (StudentTeacher kid : this.mergedRecords) {
            if (kid.getClassroom() == classNumber) {
                rtn.add(kid); 
            }
        }
        return rtn; 
    }

    // Returns a List of records of students who ride bus |busNumber|.
    public List<StudentTeacher> busSearch(int busNumber) {
        List<StudentTeacher> rtn = new LinkedList<StudentTeacher>();
        for (StudentTeacher kid : this.mergedRecords) {
            if (kid.getBus() == busNumber) {
                rtn.add(kid); 
            }
        }
        return rtn; 
    }

    // Returns a List of records of students who are in grade |gradeNumber|.
    public List<StudentTeacher> gradeSearch(int gradeNumber) {
        List<StudentTeacher> rtn = new LinkedList<StudentTeacher>();
        for (StudentTeacher kid : this.mergedRecords) {
            if (kid.getGrade() == gradeNumber) {
                rtn.add(kid); 
            }
        }
        return rtn; 
    }
}
