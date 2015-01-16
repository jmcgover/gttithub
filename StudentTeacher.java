public class StudentTeacher implements Comparable<StudentTeacher>{

   private Student student;
   private Teacher teacher;
   // Explicit constructor for StudentTeacher object.
   public StudentTeacher (Student student, Teacher teacher) {
      this.student = student;
      this.teacher = teacher;
   }

   // Accessor for Student's last name.
   public String getLast(){
      return this.student.getLast();
   }

   // Accessor for Student's first name.
   public String getFirst(){
      return this.student.getFirst();
   }

   // Accessor for Student's grade.
   public int getGrade(){
      return this.student.getGrade();
   }

   // Accessor for Student's classroom.
   public int getClassroom(){
      return this.student.getClassroom();
   }

   // Accessor for Student's bus.
   public int getBus(){
      return this.student.getBus();
   }

   // Accessor for Student's teacher's last name.
   public String getTeachersLast(){
      return this.teacher.getLast();
   }

   // Accessor for Student's teacher's first name.
   public String getTeachersFirst(){
      return this.teacher.getFirst();
   }

   // Overloaded equals method for Student object.
   public boolean equals(Object other){
      if (other == null) {
         return false;
      }

      if (this.getClass() != other.getClass()) {
         return false;
      }
      return this.student.equals(((StudentTeacher)other).student)
          && this.teacher.equals(((StudentTeacher)other).teacher);
   }

   // Overloaded toString method for Student object.
   public String toString(){
      return String.format("%s %s %d %d %d %s %s",
            this.getLast(),
            this.getFirst(),
            this.getGrade(),
            this.getClassroom(),
            this.getBus(),
            this.getTeachersLast(),
            this.getTeachersFirst());
   }

   // compareTo method for Student object.
   public int compareTo(StudentTeacher other){
      return this.student.compareTo(other.student);
   }

   public Teacher getTeacher(){
      return this.teacher;
   }
   public Student getStudent(){
      return this.student;
   }
}
