package java_qa.lec_12;

import java.util.ArrayList;

public class ExceptionExtApp {

  // RuntimeException
  //  +--GeneralNumericException
  //    +- GeneralFloatException
  //    +- GeneralIntegerException
  //        +- NegativeIntegerException
  //        +- TooLargeIntegerException
  //        +- IllegalIntegerResultException
  //  +-- LogicalErrorException

  public static class Person {
    String name;
    int age;

    public Person(String name, int age) {
      if (age < 0) {
        throw new IllegalArgumentException("Age is negative");
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

//  public static Person createPerson(String name, int age) {
//    if (age >= 0) {
//      return new Person(name, age);
//    } else {
//      return null;
//    }
//  }

  public static class GeneralNumericException extends RuntimeException {
    public GeneralNumericException(String message) {
      super(message);
    }
  }

  public static class GeneralFloatException extends GeneralNumericException {
    public GeneralFloatException(String message) {
      super(message);
    }
  }

  public static class GeneralIntegerException extends GeneralNumericException {
    public GeneralIntegerException(String message) {
      super(message);
    }
  }

  public static class NegativeIntegerException extends GeneralIntegerException {
    public NegativeIntegerException(String message) {
      super(message);
    }
  }

  public static class TooLargeIntegerException extends GeneralIntegerException {
    public TooLargeIntegerException(String message) {
      super(message);
    }
  }

  public static class IllegalIntegerResultException extends GeneralIntegerException {
    public IllegalIntegerResultException(String message) {
      super(message);
    }
  }

  public static class LogicalErrorException extends RuntimeException {
    public LogicalErrorException(String message) {
      super(message);
    }
  }

  public static int sumPositiveInteger(int a, int b) {
    if (a > 1000 || b > 1000) {
      throw new TooLargeIntegerException("Too large");
    }
    if (a < 0 || b < 0) {
      throw new NegativeIntegerException("Negative");
    }
    int sum = a + b;
    if (sum > 1000) {
      throw new IllegalIntegerResultException("Too large result");
    }
    return sum;
  }

  public static void main(String[] args) {

    int[] arr = new int[]{ 5, 17, 200, 500, 170, 165, 456, 75 };
    int[] arrLargeResult = new int[]{ 2000, 50 };
    int[] arrParts = new int[]{ 600, 600 };

    try {
      int sum = 0;
      for(int v: arrLargeResult) {
        sum = sumPositiveInteger(sum, v);
      }
      System.out.println("Sum : " + sum);
    }
    catch (NegativeIntegerException x) {
      System.out.println("N: " + x.getMessage());
    }
    catch (TooLargeIntegerException x) {
      System.out.println("(1) Too large: " + x.getMessage());
    }
    catch (GeneralNumericException x) {
      System.out.println("Exception class: " + x.getClass().getName());
      System.out.println("(2) Other: " + x.getMessage());
    }
    catch (RuntimeException x) {
      System.out.println("Runtime");
    }

    ArrayList<Person> emps = new ArrayList<>();

    try {
      emps.add(new Person("Alisa", 10));
      emps.add(new Person("Mike", 15));
      emps.add(new Person("Peter", -11)); // !!
    }
    catch (RuntimeException x) {
      System.out.println("Error in data");
    }
    System.out.println(emps);
  }
}
