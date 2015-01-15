public class Student implements Comparable<Student> {
   private String last;
   private String first;
   private int grade;
   private int classroom;
   private int bus;

   // Explicit constructor for Student object.
   public Student (String last, String first, int grade, int classroom, 
         int bus, String teaLast, String teaFirst) {

      this.last = last;
      this.first = first;
      this.grade = grade;
      this.classroom = classroom;
      this.bus = bus;
   }

   // Compact constructor for Student object.
   public Student (String[] inputLine) {
      this.last = inputLine[0];
      this.first = inputLine[1];
      this.grade = Integer.parseInt(inputLine[2]);
      this.classroom = Integer.parseInt(inputLine[3]);
      this.bus = Integer.parseInt(inputLine[4]);
   }

   // Accessor for Student's last name.
   public String getLast(){
      return this.last;
   }

   // Accessor for Student's first name.
   public String getFirst(){
      return this.first;
   }

   // Accessor for Student's grade.
   public int getGrade(){
      return this.grade;
   }

   // Accessor for Student's classroom.
   public int getClassroom(){
      return this.classroom;
   }

   // Accessor for Student's bus.
   public int getBus(){
      return this.bus;
   }

   // Overloaded equals method for Student object.
   public boolean equals(Object other){
      if (other == null) {
         return false;
      }

      if (this.getClass() != other.getClass()) {
         return false;
      }

      if (!this.last.equals(((Student)other).last)) return false;
      if (!this.first.equals(((Student)other).first)) return false;
      if (this.grade != ((Student)other).grade) return false;
      if (this.classroom != ((Student)other).classroom) return false;      
      if (this.bus != ((Student)other).bus) return false;

      return true;
   }

   // Overloaded toString method for Student object.
   public String toString(){
      return String.format("%s %s %d %d %d %s %s",
            this.last,
            this.first,
            this.grade,
            this.classroom,
            this.bus);
   }

   // Overloaded compareTo method for Student object.
   public int compareTo(Student other){
      int comp = this.last.compareTo(other.last);
      if (comp == 0) {
         comp = this.first.compareTo(other.first);
         if (comp == 0) {
            comp = this.grade - other.grade;
            return comp;
         }
         return comp;
      }
      return comp;
   }
}
