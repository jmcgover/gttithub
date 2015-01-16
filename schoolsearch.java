import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class schoolsearch {
   private static String studentFilename = "list.txt";
   private static String teacherFilename = "teachers.txt";

   // Prints the splash screen with all of the command information.
   private static void printSplash() {
      System.out.println("\nChoose from the following commands:\n" + 
            "S[tudent]: <lastname> [B[us]]\n" + 
            "T[eacher]: <lastname>\n" + 
            "C[lassroom]: <number>\n" + 
            "G[rade]: <number>\n" +
            "B[us]: <number>\n" + 
            "T[eacher]C[lassroom]: <number>\n" + 
            "T[eacher]G[rade]: <number>\n" + 
            "Q[uit]\n");
   }

   // Compares two values and returns the maximum.
   private static int max(int a, int b) {
      return a > b ? a : b;
   }

   // Prints the time in formatted output.
   private static void printLookupTime(long time) {
      System.out.printf("Query took %.3f seconds.\n",(double)time / 1000);
//      System.out.println("Query took " + ((double)time/ 1000) + 
//            " seconds.");
   }

   // Prints all the information about each StudentTeacher in |list|.
   private static void printEverything(List<StudentTeacher> list) {
      List<StudentTeacher> sorted = new LinkedList<StudentTeacher>(list);
      String format = "";
      int lastChars = 0;
      int firstChars = 0;
      int gradeChars = 0;
      int classChars = 0;
      int busChars = 0;
      int teaChars = 0;

      // Finds max character count for each to print in alignment.
      Collections.sort(sorted);
      for (StudentTeacher kid : sorted) {
         lastChars = max(lastChars, kid.getLast().length());
         firstChars = max(firstChars, kid.getFirst().length());
         gradeChars = 
            max(gradeChars, Integer.toString(kid.getGrade()).length());
         classChars = 
            max(classChars, Integer.toString(kid.getClassroom()).length());
         busChars = max(busChars, Integer.toString(kid.getBus()).length());
         teaChars = max(teaChars, kid.getTeachersLast().length());
      }

      // Builds format string accordingly.
      format = "Student: %" + lastChars + "s, %" + firstChars + 
         "s | Grade: %" + gradeChars + "d | Classroom: %" + classChars + 
         "d | Bus: %" + busChars + "d | Teacher: %" + teaChars + "s, %s\n";

      // Prints formatted output to console.
      System.err.println(format);
      for (StudentTeacher kid : sorted) {
         System.out.printf(format, 
               kid.getLast(),
               kid.getFirst(),
               kid.getGrade(),
               kid.getClassroom(),
               kid.getBus(),
               kid.getTeachersLast(),
               kid.getTeachersFirst());
      }
   }

   // Prints last name, first name, grade and class for each StudentTeacher in |list|.
   private static void printStudentFull(List<StudentTeacher> list) {
      String format = "";
      int lastChars = 0;
      int firstChars = 0;
      int gradeChars = 0;
      int classChars = 0;

      // Finds max character count for each to print in alignment.
      for (StudentTeacher kid : list) {
         lastChars = max(lastChars, kid.getLast().length());
         firstChars = max(firstChars, kid.getFirst().length());
         gradeChars = 
            max(gradeChars, Integer.toString(kid.getGrade()).length());
         classChars = 
            max(classChars, Integer.toString(kid.getClassroom()).length());
      }

      // Builds format string accordingly.
      format = "Student: %" + lastChars + "s, %" + firstChars + 
         "s | Grade: %" + gradeChars + "d | Classroom: %" + classChars + 
         "d | Teacher: %s, %s\n";

      // Prints formatted output to console.
      for (StudentTeacher kid : list) {
         System.out.printf(format, 
               kid.getLast(),
               kid.getFirst(),
               kid.getGrade(),
               kid.getClassroom(),
               kid.getTeachersLast(),
               kid.getTeachersFirst());
      }
   }

   // Prints last name, first name, and bus for each StudentTeacher in |list|.
   private static void printStudentBuses(List<StudentTeacher> list) {
      String format = "";
      int lastChars = 0;
      int firstChars = 0;
      int busChars = 0;

      // Finds max character count for each to print in alignment.
      for (StudentTeacher kid : list) {
         lastChars = max(lastChars, kid.getLast().length());
         firstChars = max(firstChars, kid.getFirst().length());
         busChars = max(busChars, Integer.toString(kid.getBus()).length());
      }

      // Builds format string accordingly.
      format = "Student: %" + lastChars + "s, %" + firstChars + "s | Bus: %" + 
         busChars + "s\n";

      // Prints formatted output to console.
      for (StudentTeacher kid : list) {
         System.out.printf(format, 
               kid.getLast(),
               kid.getFirst(),
               kid.getBus());
      }
   }

   // Prints last name and first name for each StudentTeacher in |list|.
   private static void printStudentNames(List<StudentTeacher> list) {
      String format = "";
      int lastChars = 0;
      int firstChars = 0;

      // Finds max character count for each to print in alignment.
      for (StudentTeacher kid : list) {
         lastChars = max(lastChars, kid.getLast().length());
         firstChars = max(firstChars, kid.getFirst().length());
      }

      // Builds format string accordingly.
      format = "Student: %" + lastChars + "s, %" + firstChars + "s\n";

      // Prints formatted output to console.
      for (StudentTeacher kid : list) {
         System.out.printf(format, 
               kid.getLast(),
               kid.getFirst());
      }
   }

   // Prints last name and first name for each Teacher in |list|.
   private static void printTeacherNames(List<Teacher> list) {
      String format = "";
      int lastChars = 0;
      int firstChars = 0;

      // Finds max character count for each to print in alignment.
      for (Teacher teacher : list) {
         lastChars = max(lastChars, teacher.getLast().length());
         firstChars = max(firstChars, teacher.getFirst().length());
      }

      // Builds format string accordingly.
      format = "Teacher: %" + lastChars + "s, %" + firstChars + "s\n";

      // Prints formatted output to console.
      for (Teacher teacher : list) {
         System.out.printf(format, 
               teacher.getLast(),
               teacher.getFirst());
      }
   }

   // Prints last name, first name, and class for each StudentTeacher in |list|.
   private static void printStudentClasses(List<StudentTeacher> list) {
      String format = "";
      int lastChars = 0;
      int firstChars = 0;
      int gradeChars = 0;
      int classChars = 0;

      // Finds max character count for each to print in alignment.
      for (StudentTeacher kid : list) {
         lastChars = max(lastChars, kid.getLast().length());
         firstChars = max(firstChars, kid.getFirst().length());
         gradeChars = 
            max(gradeChars, Integer.toString(kid.getGrade()).length());
         classChars = 
            max(classChars, Integer.toString(kid.getClassroom()).length());
      }

      // Builds format string accordingly.
      format = "Student: %" + lastChars + "s, %" + firstChars + 
         "s | Grade: %" + gradeChars + "d | Classroom: %" + classChars + 
         "d\n";

      // Prints formatted output to console.
      for (StudentTeacher kid : list) {
         System.out.printf(format, 
               kid.getLast(),
               kid.getFirst(),
               kid.getGrade(),
               kid.getClassroom());
      }
   }

   // Main driver for schoolsearch executable.
   public static void main(String[] args) {
      String studentFilename = schoolsearch.studentFilename; 
      String teacherFilename = schoolsearch.teacherFilename; 
      Scanner studentSource = null;
      Scanner teacherSource = null;
      DBMS database = null;

      // Open data csv and setup database.
      try {
         studentSource = new Scanner(new File(studentFilename));
         teacherSource = new Scanner(new File(teacherFilename));
         database = new DBMS(studentSource, teacherSource);
      } 
      catch (IOException e) {
         System.err.println(e.getMessage());
         System.exit(1);
      }

      Scanner in = new Scanner(System.in);
      String line = null;
      String[] inputs = null;
      Boolean quitFlag = false;

      printSplash();

      List<StudentTeacher> results = null;
      List<Teacher> teacherResults = null;
      long startTime = 0;
      long totalTime = 0;

      try {
         // Loop until the user terminates the program
         while (!quitFlag) {
            System.out.print(">>> ");
            line = in.nextLine().trim();
            inputs = line.split("\\s+");
            results = null;
            startTime = 0;
            totalTime = 0;

            try {
               // Set quitFlag high if user chose to quit the application
               if (line.equalsIgnoreCase("q") || 
                     line.equalsIgnoreCase("quit")) {

                  quitFlag = true;       
                  continue;
                     }
               // If the user wanted to lookup by STUDENT
               else if (inputs[0].equalsIgnoreCase("s:") || 
                     inputs[0].equalsIgnoreCase("student:")) {

                  startTime = System.currentTimeMillis();
                  results = database.studentSearch(inputs[1]);
                  totalTime = System.currentTimeMillis() - startTime;

                  // If the user wanted to lookup STUDENT BUS information
                  if (inputs.length == 3) { 
                     if (inputs[2].equalsIgnoreCase("b") || 
                           inputs[2].equalsIgnoreCase("bus")) {

                        printStudentBuses(results);
                           }
                     else {
                        // Invalid Input
                        System.err.println("Argument '" + inputs[2] 
                              + "' unrecognized.");
                        continue;
                     }
                  }
                  // If the user wanted to lookup by CLASS information
                  else if (inputs.length == 2) {
                     printStudentFull(results);
                  }
                     }
               // If the user wanted to lookup all students by TEACHER
               else if (inputs[0].equalsIgnoreCase("t:") || 
                     inputs[0].equalsIgnoreCase("teacher:")) {

                  startTime = System.currentTimeMillis();
                  results = database.teacherSearch(inputs[1]);
                  totalTime = System.currentTimeMillis() - startTime;
                  printStudentNames(results);
                     }
               // If the user wanted to lookup all students by CLASSROOM
               else if (inputs[0].equalsIgnoreCase("c:") || 
                     inputs[0].equalsIgnoreCase("classroom:")) {

                  startTime = System.currentTimeMillis();
                  results = 
                     database.classSearch(Integer.parseInt(inputs[1]));
                  totalTime = System.currentTimeMillis() - startTime;
                  printStudentNames(results);
                     }
               // If the user wanted to lookup all students by BUS
               else if (inputs[0].equalsIgnoreCase("b:") || 
                     inputs[0].equalsIgnoreCase("bus:")) {

                  startTime = System.currentTimeMillis();
                  results = 
                     database.busSearch(Integer.parseInt(inputs[1])) ;
                  totalTime = System.currentTimeMillis() - startTime;
                  printStudentClasses(results);
                     }
               // If a user wanted to lookup all students by GRADE 
               else if (inputs[0].equalsIgnoreCase("g:") || 
                     inputs[0].equalsIgnoreCase("grade:")) {

                  startTime = System.currentTimeMillis();
                  results = 
                     database.gradeSearch(Integer.parseInt(inputs[1]));
                  totalTime = System.currentTimeMillis() - startTime;
                  printStudentNames(results);
                     }
               // If a user wanted to lookup all TEACHERS by CLASSROOM 
               else if (inputs[0].equalsIgnoreCase("TC:") || 
                     inputs[0].equalsIgnoreCase("TeacherC:") ||
                     inputs[0].equalsIgnoreCase("TClassroom:") ||
                     inputs[0].equalsIgnoreCase("TeacherClassroom:")) {

                  startTime = System.currentTimeMillis();
                  teacherResults = 
                     database.teacherRoomSearch(Integer.parseInt(inputs[1]));
                  totalTime = System.currentTimeMillis() - startTime;
                  printTeacherNames(teacherResults);
                     }
               // If a user wanted to lookup all TEACHERS by GRADE 
               else if (inputs[0].equalsIgnoreCase("TG:") || 
                     inputs[0].equalsIgnoreCase("TeacherG:") ||
                     inputs[0].equalsIgnoreCase("TGrade:") ||
                     inputs[0].equalsIgnoreCase("TeacherGrade:")) {

                  startTime = System.currentTimeMillis();
                  teacherResults = 
                     database.teacherGradeSearch(Integer.parseInt(inputs[1]));
                  totalTime = System.currentTimeMillis() - startTime;
                  printTeacherNames(teacherResults);
                     }
               // Secret
               else if (inputs[0].equalsIgnoreCase("a") || 
                     inputs[0].equalsIgnoreCase("all")) {

                  startTime = System.currentTimeMillis();
                  results = database.getMerged();
                  totalTime = System.currentTimeMillis() - startTime;
                  printEverything(results);
                     }
               else {
                  System.out.println("Command '" + line + 
                        "' unrecognized.");
                  continue;
               }
               printLookupTime(totalTime);
            } 
            catch (NumberFormatException e) {
               // Gracefully handling incorrect argument format.
               System.err.println("Please use number for argument.");
            } 
         }
      }
      catch (NoSuchElementException e) {
         // Because I keep pressing Ctrl+D
         System.err.println("No more lines read.");
      }
      System.out.println("Goodbye!");
   }
}
