package java_qa.lec_06;

public class MyLinkedList {

  // Head -> null
  // Head -> "Olga"|Ref -> null
  // Head -> "Irina"|Ref -> "Olga"|Ref -> null
  // .....
  // Head -> "Mikhail"Ref -> ..... "Irina"|Ref -> "Olga"|Ref -> null

  private static class Node {
    String payload;
    Node next;

    public Node(String payload, Node next) {
      this.payload = payload;
      this.next = next;
    }

    public boolean isLast() {
      return next == null;
    }
  }

  private Node head;

  private int count;

  public MyLinkedList() {
    this.head = null;
    count = 0;
  }

  public int size() {
    return count;
  }

  public void push(String v) {
    Node newNode = new Node(v, head);
    head = newNode;
    count++;
  }

  public String pull() {
    if (head != null) {
      Node current = head;
      head = current.next;
      count--;
      return current.payload;
    } else {
      return null;
    }
  }

  //
  public String look() {
    return "";
  }

  // printAll

  // boolean contains(String)
}
