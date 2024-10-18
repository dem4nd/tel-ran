package java_qa.lec_06;

import java.util.HashSet;
import java.util.Objects;

public class Review05App {

  // 1. Заполните класс Person полями name и lastName
  // 2. Создайте для этого класса методы equals и hashCode, которые учитывают оба поля
  // 3. Заполните в методе main коллекцию HashSet значениями Person и включите несколько
  // одинаковых значений
  //
  // 4. Вызвав метод size убедитесь, что одинаковые значения не попали в коллекцию несколько раз

  public static class Person {
    String name;
    String  lastName;

    public Person(String name, String lastName) {
      this.name = name;
      this.lastName = lastName;
    }

    String normalizedName() {
      return name != null ? name.toLowerCase() : null;
    }

    String normalizedLastName() {
      return lastName != null ? lastName.toLowerCase() : null;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;

      if (o == null) return false;

      if(this.getClass() != o.getClass()) return false;

      Person person = (Person) o;

      return Objects.equals(normalizedName(), person.normalizedName()) && Objects.equals(normalizedLastName(), person.normalizedLastName());
    }

    @Override
    public int hashCode() {
      return Objects.hash(normalizedName(), normalizedLastName());
    }

    @Override
    public String toString() {
      return "Person{" + "'" + name + '\'' +
          ", '" + lastName + '\'' +
          '}';
    }
  }

  public static void main(String[] args) {
    HashSet<Person> people = new HashSet<>();

    Person p1 = new Person("Olga", "Muller");   // создать экземпляр (инстанс) Person и присвоить перменной p1

    Person p2 = new Person("Irina", "Schmidt"); // @3 -> |0.....|1......|2.....|3 Person()|4......|
    Person p3 = new Person("IRINA", "schmidt"); // @4 -> |0.....|1......|2.....|3 Person()|4 Person()|

    people.add(p1);
    people.add(p2);
    people.add(p3);

    System.out.println("People: " + people);

    System.out.println("equals(): " + (p3.equals(p2))); // p3.equals(p2): true => p2.equals(p3): true
  }
}
