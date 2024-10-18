package java_qa.lec_05;

import java.util.*;

public class CompanyWithSetApp {

  public static void printEmployees (ArrayList<Employee> listEmployee){
    for (Employee e: listEmployee) {
      System.out.println(e.name + " " + e.surName + "(" + e.position + ") : " + e.year);
    }
  }

  public static class Employee {
    String name;
    String surName;
    String position;
    int year;

    public Employee(String name, String surName, String position, int year) {
      this.name = name;
      this.surName = surName;
      this.position = position;
      this.year = year;
    }

    // Если два объекта equals(), то hashCode ДОЛЖНЫ быть равны
    // Если hashCode у двух объектов равны, то объекты МОГУТ НЕ БЫТЬ equals()
    // Если объекты не equals(), то hashCode МОЖЕТ совпадать
    // https://medium.com/@ghoshsiddharth25/java-equals-and-hashcode-contract-656d481f86da

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Employee employee = (Employee) o;
      return Objects.equals(name, employee.name) && Objects.equals(surName, employee.surName);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, surName);
    }

    @Override
    public String toString() {
      return "Employee{" +
          "name='" + name + '\'' +
          ", surName='" + surName + '\'' +
          ", position='" + position + '\'' +
          ", year=" + year +
          '}';
    }
  }

  public static class Company {
    String name;
    Set<Employee> employees = new HashSet<>();

    public Company(String name) {
      this.name = name;
    }

    public void add(Employee e) {
      employees.add(e);
    }

    public Employee remove(String name) {
      return null;
    }

    public void printEmployees() {
      for (Employee e : employees) {
        System.out.println(e.name + " " + e.surName + " (" + e.position + ") : " + e.year);
      }
    }

    public void printEmployees(String title) {
      System.out.println(title);
      printEmployees();
    }
  }

  public static void main(String[] args) {
    Company c1 = new Company("Happy Train");

    c1.add(new Employee("John", "Silver", "Dev", 2000));
    c1.add(new Employee("Bob", "Watson","QA", 2015));
    c1.add(new Employee("Julia", "Bradley","Dev", 2002));
    c1.add(new Employee("Liz", "Watson","HR", 2007));
    c1.add(new Employee("Liz", "Hakkinen","QA", 2001));
    c1.add(new Employee("John", "Davidson","Dev", 2000));
    c1.add(new Employee("Liz", "Watson","QA", 2007));
    c1.add(new Employee("Julia", "Bradley","Dev", 2007));

//    c1.printEmployees("выводит список сотрудников на экран");

    ArrayList<Employee> empList = new ArrayList<>(Arrays.asList(
      new Employee("John", "Silver", "Dev", 2000),
      new Employee("Bob", "Watson","QA", 2015),
      new Employee("Julia", "Bradley","HR", 2002),
      new Employee("Liz", "Watson","HR", 2007),
      new Employee("John", "Davidson","Dev", 2000),
      new Employee("Liz", "Watson","QA", 2000),
      new Employee("Julia", "Bradley","Dev", 2006)
    ));

    // name -> count of names
    // Подсчитать количество людей с одинаковыми именами
    Map<String, Integer> mapCount = new HashMap<>();
    for (Employee emp: c1.employees) {
      String name = emp.surName;
      if (mapCount.containsKey(name)) {
        Integer count = mapCount.get(name);
        mapCount.put(name, count + 1);
      } else {
        mapCount.put(name, 1);
      }
    }

    System.out.println(mapCount);
  }
}