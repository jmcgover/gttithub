public class Teacher implements Comparable<Teacher> {
   private String last;
   private String first;
   private int classroom; 

   public Teacher (String last, String first, int classroom) {
      this.last = last;
      this.first = first;
      this.classroom = classroom;
   }

   public Teacher (String[] inputLine) {
      this.last = inputLine[0];
      this.first = inputLine[1];
      this.classroom = Integer.parseInt(inputLine[2]);
   }

   public String getLast(){
      return this.last;
   }
   public String getFirst(){
      return this.first;
   }
   public int getClassroom(){
      return this.classroom;
   }

   public boolean equals(Object other){
      if (other == null) return false;
      if (other.getClass() != this.getClass()) return false;
      if (!this.last.equals(((Teacher)other).last)) return false;
      if (!this.first.equals(((Teacher)other).first)) return false;
      if (this.classroom != ((Teacher)other).classroom) return false;
      return true;
   }

    // Overloaded compareTo method for Student object.
    public int compareTo(Teacher other){
        int comp = this.last.compareTo(other.last);
        if (comp == 0) {
            comp = this.first.compareTo(other.first);
            if (comp == 0) {
                comp = this.classroom - other.classroom;
                return comp;
            }
            return comp;
        }
        return comp;
    }
}
