package pl.sdacademy.adapter;

import java.util.ArrayList;
import java.util.List;

public class AdapterUsage {
  public static void main(String[] args) {
    List<Student> students = new ArrayList<>();
    students.add(new PupilAdapter(new Pupil("Andrzej", "Nowak", "anowak@sda.pl", 19, List.of(3, 4, 5))));
    for (final var student : students) {
      System.out.println(student.getFullName());
      System.out.println(student.getContactDetails());
      System.out.println(student.getResults());
      System.out.println(student.isAdult());
    }
  }
}
