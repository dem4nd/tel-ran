package java_qa.lec_09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortApp {

  public static class Person implements Comparable<Person> {
    String name;

    public Person(String name) {
      this.name = name;
    }

    @Override
    public int compareTo(Person o) {
      return this.name.length() - o.name.length();
    }

    @Override
    public String toString() {
      return name;
    }
  }

  static class PersonByLengthComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
      return o1.compareTo(o2);
    }
  }

  static class StringByLengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
      return Integer.compare(o1.length(), o2.length());
    }
  }

  // Написать Comparator, который принимает другой компаратор как параметр конструктора и
  // сравнивает элементы в противоположном направлении

  static class StringAbcComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
      return o1.compareTo(o2);
    }
  }

  static class ReverseComparator<T> implements Comparator<T> {

    Comparator<T> straightComparator;

    public ReverseComparator(Comparator<T> straightComparator) {
      this.straightComparator = straightComparator;
    }

    @Override
    public int compare(T o1, T o2) {
      return -straightComparator.compare(o1, o2);
    }
  }

  public static void main(String[] args) {
    ArrayList<Person> persons = new ArrayList<>();
    persons.add(new Person("Alexander"));
    persons.add(new Person("Max"));
    persons.add(new Person("Oleg"));
    persons.add(new Person("Artem"));

    Person olga = new Person("Olga");
    Person maria = new Person("Maria");

    System.out.println(olga.compareTo(maria));

    System.out.println(persons);
    Collections.sort(persons);
    System.out.println(persons);
    Collections.sort(persons, new ReverseComparator(new PersonByLengthComparator()));
    System.out.println(persons);

    System.out.println("---------");

    ArrayList<String> names = new ArrayList<>();
    names.add("Oleg");
    names.add("Max");
    names.add("Aleksander");

    Collections.sort(names); // Abc sort
    System.out.println(names);
    Comparator<String> lengthComparator= new StringByLengthComparator();
    Comparator<String> abcComparator= new StringAbcComparator();
    Collections.sort(names, lengthComparator); // length sort
    System.out.println(names);
    Collections.sort(names, new ReverseComparator(lengthComparator)); // reverse length sort
    System.out.println(names);
    Collections.sort(names, new ReverseComparator(abcComparator)); // reverse Abc sort
    System.out.println(names);
  }
}
