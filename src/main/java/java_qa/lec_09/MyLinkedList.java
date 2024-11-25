package java_qa.lec_09;

import java.util.Iterator;

public class MyLinkedList<E> {
  static class Node<E> {
    E payload;
    Node<E> next;

    public Node(E payload, Node<E> next) {
      this.payload = payload; // -->  -->  -->
      this.next = next;       // main push Node()
    }

    public boolean isLast() {
      return next == null;
    }
  }

  private Node<E> head;

  private int count;

  public MyLinkedList() {
    this.head = null;
    count = 0;
  }

  public int size() {
    return count;
  }

  public void push(E v) {
    Node<E> newNode = new Node<E>(v, head); // -->   -->
    head = newNode;                         // main  push
    count++;
  }

  public E pull() {
    if (head != null) {
      Node<E> current = head;
      head = current.next;
      count--;
      return current.payload;
    } else {
      return null;
    }
  }

  void clean() {
    head = null;
    count = 0;
  }

  @Override
  public String toString() {
    Node<E> currentNode = head;
    String s = "";
    while (currentNode != null) {
      if (!s.isEmpty()) {
        s += ", ";
      }
      s = s + currentNode.payload.toString();
      currentNode = currentNode.next;
    }
    return "[" + s + "]";
  }

  static class MyLinkedListIterator<E> implements Iterator<E> {

    Node<E> currentState;

    public MyLinkedListIterator(Node<E> currentState) {
      this.currentState = currentState;
    }

    @Override
    public boolean hasNext() {
      return currentState != null;
    }

    @Override
    public E next() {
      E ret = currentState.payload;
      currentState = currentState.next;
      return ret;
    }
  }

  public Iterator<E> iterator() {
    return new MyLinkedListIterator<E>(this.head);
  }
}
