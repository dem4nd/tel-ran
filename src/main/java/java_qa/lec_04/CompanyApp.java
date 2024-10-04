package java_qa.lec_04;

import java.util.ArrayList;

public class CompanyApp {

// Создать класс c информацией о сотруднике (имя: строка, должность:строка,
// год начала работы: целое)

// Создать класс c информацией о компании (название: строка, список сотрудников

// В классе компании сделать два метода - добавить сотрудника (add)
// и удалить сотрудника (remove)

  public static void printEmployees (ArrayList<Employee> listEmployee){
    for (Employee e: listEmployee) {
      System.out.println(e.name + "(" + e.position + ") : " + e.year);
    }
  }

  public static class Employee {
    String name;
    String position;
    int year;

    public Employee(String name, String position, int year) {
      this.name = name;
      this.position = position;
      this.year = year;
    }
  }

  public static class Company {
    String name;
    ArrayList<Employee> employees = new ArrayList<>();

    public Company(String name) {
      this.name = name;
    }

    public void add(Employee e) {
      employees.add(e);
    }

    public Employee remove(String name) {
      for (int i = 0; i < employees.size(); i++) {
        Employee e = employees.get(i);
        if (name.equals(e.name)) {
          employees.remove(i);
          return e;
        }
      }
      return null;
    }

    public void printEmployees() {
      for (Employee e : employees) {
        System.out.println(e.name + "(" + e.position + ") : " + e.year);
      }
    }

    public void printEmployees(String title) {
      System.out.println(title);
      printEmployees();
    }

    public ArrayList<Employee> findByPosition(String position) {
      ArrayList<Employee> result = new ArrayList<>();

      //

      return result;
    }

    public ArrayList<Employee> findHiredAfter(int year) {
      ArrayList<Employee> result = new ArrayList<>();

      //

      return result;
    }
  }

  public static void main(String[] args) {
    Company c1 = new Company("Happy Train");

    c1.add(new Employee("John", "Dev", 2000));
    c1.add(new Employee("Bob", "QA", 2015));
    c1.add(new Employee("Julia", "Dev", 2002));
    c1.add(new Employee("Liz", "HR", 2007));

    c1.printEmployees("выводит список сотрудников на экран");

    // увольняем "Julia"
    c1.remove("Julia");
    c1.printEmployees("выводит список сотрудников на экран без Julia");

    // берем на работу Rita
    c1.add(new Employee("Rita", "CTO", 2024));
    c1.printEmployees("выводит список сотрудников на экран  с Rita");

    ArrayList<Employee> devs = c1.findByPosition("Dev");
    printEmployees(devs);
    ArrayList<Employee> after2005 = c1.findHiredAfter(2005);
    printEmployees(after2005);
  }
}