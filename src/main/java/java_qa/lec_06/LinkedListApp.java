package java_qa.lec_06;

public class LinkedListApp {

  public static void main(String[] args) {
    MyLinkedList list = new MyLinkedList();

    // --------- список создан и пуст

    list.push("Olga");
    list.push("Irina");

    System.out.println("size: " + list.size());

    // --------- список заполнен, извлекаем значения

    String v1 = list.pull();
    System.out.println(v1);

    String v2 = list.pull();
    System.out.println(v2);

    // --------- список снова пустой
  }
}
