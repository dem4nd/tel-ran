package java_qa.lec_08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class LimitedCollection<T> implements Iterable<T> {

  private final int maxSize;
  private final ArrayList<T> collection;
  private final Random random = new Random();

  public LimitedCollection(int maxSize) {
    this.maxSize = maxSize;
    this.collection = new ArrayList<>();
  }

  public void removeAny() { // удаляем любой єемент из колекции
    if (collection.isEmpty()) return;
    int index = random.nextInt(collection.size());
    collection.remove(index);
  }

  public void removeLeastRecent() { // удаляем элемент, который добавлен раньше остальных
    if (collection.isEmpty()) return;
    collection.remove(collection.size() - 1);
  }

  public void add(T element) {
    collection.add(0, element);
    if (collection.size() > maxSize) {
      collection.remove(collection.size() - 1);
    }
  }

  public int size() {
    return collection.size();
  }

  public int getMaxSize() {
    return maxSize;
  }

  public void print (){
    System.out.println(collection);
  }

  @Override
  public Iterator<T> iterator() {
    return collection.iterator();
  }

  public static void main(String[] args) {
    LimitedCollection<Integer> limColl = new LimitedCollection<>(4);
    limColl.add(5);
    limColl.add(9);
    limColl.add(15);
    limColl.add(-1);

    for(Integer v: limColl) {
      System.out.println("> " + v);
    }
  }

}
