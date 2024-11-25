package java_qa.lec_09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IteratorApp {

  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
    names.add("Oleg");
    names.add("Max");
    names.add("Peter");
    names.add("Aleksander");

    StringBuffer sb = new StringBuffer();

    Iterator<String> iter = names.iterator();
    while (iter.hasNext()) {
      String name = iter.next();
      sb.append(name).append(" ");
    }
    System.out.println(sb);

    MyLinkedList<String> namesLinked = new MyLinkedList<>();
    namesLinked.push("Oleg");
    namesLinked.push("Max");
    namesLinked.push("Peter");
    namesLinked.push("Aleksander");

    StringBuffer sbLinked = new StringBuffer();

    Iterator<String> iterLinked = namesLinked.iterator();
    while (iterLinked.hasNext()) {
      String name = iterLinked.next();
      sbLinked.append(name).append(" ");
    }

    System.out.println(sbLinked);

    // Заполнить ArrayList значениями из нашего MyLinkedList
    List<String> actualList = new ArrayList<String>();
    namesLinked.iterator().forEachRemaining(actualList::add);

    System.out.println(actualList);
  }
}
