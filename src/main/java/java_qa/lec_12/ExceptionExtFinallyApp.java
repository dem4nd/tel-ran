package java_qa.lec_12;

import java.util.ArrayList;

public class ExceptionExtFinallyApp {

  // RuntimeException
  //  +--GeneralNumericException
  //  +-- LogicalErrorException

  public static class Person {
    String name;
    int age;

    public Person(String name, int age) {
      if (age < 0) {
        throw new NegativeIntegerException("Age is negative");
      }
      if (name == null) {
        throw new NullPointerException("Name is null");
      }
      if (name.isEmpty()) {
        throw new IllegalArgumentException("Name is empty");
      }
      this.name = name;
      this.age = age;
    }

    @Override
    public String toString() {
      return "Person{" +
          "name='" + name + '\'' +
          ", age=" + age +
          '}';
    }
  }

  public static class LogicalException extends RuntimeException {
    public LogicalException(String message) {
      super(message);
    }
  }

  public static class GeneralNumericException extends RuntimeException {
    public GeneralNumericException(String message) {
      super(message);
    }
  }

  public static class NegativeIntegerException extends GeneralNumericException {
    public NegativeIntegerException(String message) {
      super(message);
    }
  }

  public static void main(String[] args) {

    try {
      Person p = new Person("Alisa", -10);
      System.out.println(p);
    }
    catch (NegativeIntegerException x) {
      System.out.println("Error in data");
      throw new LogicalException("No person");
    }
    finally {
      System.out.println("Finally");
    }

    System.out.println("End of program");
  }
}
