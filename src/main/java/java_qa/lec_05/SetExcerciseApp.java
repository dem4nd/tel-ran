package java_qa.lec_05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetExcerciseApp {

  public static void main(String[] args) {
    Set<String> namesSet = new HashSet<>();
    ArrayList<String> namesList = new ArrayList<>();

    String[] names = new String[] {
      "Julia", "Andrew", "Bob", "Peter", "Julia", "Mike", "Bob"
    };

    for(String n : names) {
      namesSet.add(n);
      namesList.add(n);
    }

    System.out.println("Set: " + namesSet);
    System.out.println("List:" + namesList);
  }
}
