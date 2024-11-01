package java_qa.lec_07;

public class LinkedListApp {

  public static void main(String[] args) {
    MyLinkedList<String> listOfString = new MyLinkedList();

    // --------- список создан и пуст

    System.out.println("List: " + listOfString);

    listOfString.push("Olga");  // -->
    listOfString.push("Irina"); // -->
    listOfString.push("Liza");  // -->
    listOfString.push("Mikhail");

    System.out.println("size: " + listOfString.size());

    // list.contains(...) вернёт boolean true, если значение есть в списке
//    System.out.println("Test \"Liza\": " + list.contains("Liza"));
//    System.out.println("Test \"Dmitri\": " + list.contains("Dmitri"));

//    System.out.println("Test recursive \"Irina\": " + list.containsRecurive("Irina"));
//    System.out.println("Test recursive \"Dmitri\": " + list.containsRecurive("Dmitri"));


    listOfString.clean();
    listOfString.push("Olga");
    listOfString.push("Irina");
    listOfString.push("Liza");
    listOfString.push("Mikhail");

    System.out.println("List: " + listOfString);

    System.out.println("Inserted Daniel at 2: " + listOfString.insertAt(2, "Daniel"));
    System.out.println("Result: " + listOfString);

    listOfString.clean();
    listOfString.push("Olga");
    listOfString.push("Irina");
    listOfString.push("Liza");
    listOfString.push("Mikhail");

    System.out.println("Inserted Daniel at 4: " + listOfString.insertAt(4, "Daniel"));
    System.out.println("Result: " + listOfString);

    listOfString.clean();
    listOfString.push("Olga");
    listOfString.push("Irina");
    listOfString.push("Liza");
    listOfString.push("Mikhail");

    System.out.println("Inserted Daniel at 7: " + listOfString.insertAt(7, "Daniel"));
    System.out.println("Result: " + listOfString);

    listOfString.clean();
    listOfString.push("Olga");
    listOfString.push("Irina");
    listOfString.push("Liza");
    listOfString.push("Mikhail");

    System.out.println("Inserted Daniel at 0: " + listOfString.insertAt(0, "Daniel"));
    System.out.println("Result: " + listOfString);

    listOfString.clean();
    listOfString.push("Olga");
    listOfString.push("Irina");
    listOfString.push("Liza");
    listOfString.push("Mikhail");

    System.out.println("Inserted Daniel at -4: " + listOfString.insertAt(-4, "Daniel"));
    System.out.println("Result: " + listOfString);
  // -->

    MyLinkedList<Integer> listOfInteger = new MyLinkedList<>();
    listOfInteger.push(5);
    listOfInteger.push(12);
    listOfInteger.push(7);
    listOfInteger.push(-8);

    System.out.println("List of integer: " + listOfInteger);
  }
}
