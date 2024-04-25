public class MyLinkedList {

  private static class Link {
    private final int value;
    private Link next;

    public Link(int value) {
      this.value = value;
      this.next = null;
    }

    public Link(int value, Link next) {
      this.value = value;
      this.next = next;
    }

    public int getValue() {
      return value;
    }

    public Link getNext() {
      return next;
    }

    public boolean hasNext() {
      return next != null;
    }

    public void setNext(Link p) {
      this.next = p;
    }
  }

  private Link head = null;

  public void pushToHead(int v) {
    Link nextHead = new Link(v, head);
    head = nextHead;
  }

  public void pushToTail(int value) {
    if (head == null) {
      pushToHead(value);
    } else {
      Link curLink = head;

      while (curLink.getNext() != null)
        curLink = curLink.getNext();

      curLink.setNext(new Link(value, null));
    }
  }

  public void pushToIndex(int index, int value) {
    // реализовать
  }

  public void removeFirst() {
    // реализовать
  }

  public void removeLast() {
    // реализовать
  }

  public void removeAtIndex(int index) {
    // реализовать
  }

  public int getByIndex(int index) {
    Link curLink = head;

    int i = 0;
    for (; i < index; i++) {
      curLink = curLink.getNext();
    }

    return curLink.getValue();
  }

  public int getIndexByValue(int value) {
    int index = 0;
    Link curLink = head;

    while (curLink != null) {
      if (curLink.getValue() == value)
        return index;
      curLink = curLink.getNext();
      index++;
    }
    // не нашли
    return -1;
  }

  public int size() {
    int i = 0;
    Link curLink = head;
    while (curLink != null) {
      i++;
      curLink = curLink.getNext();
    }
    return i;
  }

  public String print() {
    StringBuilder result = new StringBuilder();
    if (size() == 0) {
      result.append("<empty>");
    } else {
      result.append("|-> ").append(head.value);
      Link current = head.getNext();
      while (current != null) {
        result.append(", ").append(current.getValue());
        current = current.getNext();
      }
    }
    return result.toString();
  }

  public static void main(String[] args) {
    MyLinkedList list = new MyLinkedList();

    System.out.println(list.print());

    list.pushToHead(10);
    list.pushToHead(20);
    list.pushToHead(30);
    list.pushToTail(40);

    System.out.println(list.print());

    System.out.println("15 at: " + list.getIndexByValue(15));
    System.out.println("20 at: " + list.getIndexByValue(20));
  }
}
