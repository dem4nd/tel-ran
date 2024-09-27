package java_qa.collections;

import java.util.*;

public class CollectionsApp {

  public static class Person {
    String name;

    public Person(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }
  }

  public static void main(String[] args) {
    String[] sourceNames = new String[]{"John", "Susan", "Amber", "Peter"};

    ArrayList<String> stringArrayNames = new ArrayList<>();

    ArrayList<Person> personArrayNames = new ArrayList<>();

    System.out.println("Names in ArrayList at the beginning: " + stringArrayNames);

    for(int i = 0; i < sourceNames.length; i++) {
      stringArrayNames.add(sourceNames[i]);
    }

    stringArrayNames.add("Julia");
    System.out.println("Names in ArrayList: " + stringArrayNames);

    System.out.println("Size: " + stringArrayNames.size());

    stringArrayNames.remove(1);

    System.out.println("Names in ArrayList without [1]: " + stringArrayNames);

    stringArrayNames.remove("Peter");

    System.out.println("Names in ArrayList without \"Peter\": " + stringArrayNames);

    stringArrayNames.add(2, "Mary");

    System.out.println("Names in ArrayList with \"Mary\" at [2]: " + stringArrayNames);

    List<String> arr1 = new ArrayList(Arrays.asList("A", "B", "C", "J"));
    List<String> arr2 = new LinkedList(Arrays.asList("G", "J", "K", "B"));

    arr1.retainAll(arr2);

    System.out.println(arr1);
  }
}
