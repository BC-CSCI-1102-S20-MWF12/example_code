import java.util.*;

public class ComparatorTest {

  ArrayList<Student> students;


  // inner Student class
  public class Student {
    String name;
    Integer year;
    Double gpa;

    public Student (String name, Integer year, Double gpa) {
      this.name = name;
      this.year = year;
      this.gpa = gpa;
    }
  }

  // inner Comparator classes
  public class NameComp implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
      return s1.name.compareTo(s2.name);
    }
  }

  public class YearComp implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
      return s1.year.compareTo(s2.year);
    }
  }

  public class GPAComp implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
      return s1.gpa.compareTo(s2.gpa);
    }
  }

  // intance methods and variables for the ComparatorTest class

  public ComparatorTest(String s) {
    students = new ArrayList<Student>();
  }

  public void sortMyStudents(String s) {
    if (s.equals("year")) {
      students.sort(new YearComp());
    } else if (s.equals("gpa")) {
      students.sort(new GPAComp());
    } else {
      students.sort(new NameComp());
    }

  }

  public void addStudent(String name, Integer year, Double gpa) {
    Student s = new Student(name, year, gpa);
    students.add(s);
  }

  public void printStudents() {
    for (Student q : students) {
      System.out.println(q.name + " " + q.year + " " + q.gpa);
    }
  }

  public static void main(String[] args) {
    ComparatorTest ct1 = new ComparatorTest("name");
    ct1.addStudent("Maya", 2021, 4.0);
    ct1.addStudent("Nadia", 2022, 3.3);
    ct1.addStudent("Jie", 2020, 3.6);
    ct1.addStudent("Jackson", 2023, 3.0);
    ct1.sortMyStudents("year");
    ct1.printStudents();
    System.out.println();
    ct1.sortMyStudents("gpa");
    ct1.printStudents();
    System.out.println();
    ct1.sortMyStudents("name");
    ct1.printStudents();
    System.out.println();

  }

}
