package java_qa.lec_08;

import java.util.*;

public class SortedApp {

  static class ToBeSorted implements Comparable<ToBeSorted> {
    int num1;
    int num2;
    String name;

    public ToBeSorted(int num1, int num2, String name) {
      this.num1 = num1;
      this.num2 = num2;
      this.name = name;
    }

    @Override
    public String toString() {
      return "(" + num1 + ", " + num2 + ", " + "\"" + name + "\")";
    }

    @Override
    public int compareTo(ToBeSorted other) {
      return this.toString().compareTo(other.toString());
    }
  }

  public static class ByNameComparator implements Comparator<ToBeSorted> {
    @Override
    public int compare(ToBeSorted o1, ToBeSorted o2) {
      return o1.name.compareTo(o2.name);
    }
  }

  public static class ByNum1Comparator implements Comparator<ToBeSorted> {
    @Override
    public int compare(ToBeSorted o1, ToBeSorted o2) {
      return o1.num1 - o2.num1;
    }
  }

  public static class ByNum2Comparator implements Comparator<ToBeSorted> {
    @Override
    public int compare(ToBeSorted o1, ToBeSorted o2) {
      return o1.num2 - o2.num2;
    }
  }

  public static class CombinedComparator implements Comparator<ToBeSorted> {
    @Override
    public int compare(ToBeSorted o1, ToBeSorted o2) {
      int firstPriority = o1.num2 - o2.num2;
      if (firstPriority == 0) {
        return o1.name.compareTo(o2.name);
      } else {
        return firstPriority;
      }
    }
  }

  public static class SuperCombinedComparator implements Comparator<ToBeSorted> {
    Comparator<ToBeSorted> firstPriorityComparator;
    Comparator<ToBeSorted> secondPriorityComparator;

    public SuperCombinedComparator(Comparator<ToBeSorted> firstPriorityComparator, Comparator<ToBeSorted> secondPriorityComparator) {
      this.firstPriorityComparator = firstPriorityComparator;
      this.secondPriorityComparator = secondPriorityComparator;
    }

    @Override
    public int compare(ToBeSorted o1, ToBeSorted o2) {
      int firstPriority = firstPriorityComparator.compare(o1, o2);
      if (firstPriority == 0) {
        return secondPriorityComparator.compare(o1, o2);
      } else {
        return firstPriority;
      }
    }
  }

  public static void main(String[] args) {
    Set<ToBeSorted> sorted = new TreeSet<>(); // был HashSet

    sorted.add(new ToBeSorted(200, 7, "Paris"));
    sorted.add(new ToBeSorted(700, 7, "Amsterdam"));
    sorted.add(new ToBeSorted(200, 12, "New York"));
    sorted.add(new ToBeSorted(500, 3, "Yokohama"));

    for(ToBeSorted v: sorted) {
      System.out.println(v);
    }

    System.out.println("---------");

    Set<ToBeSorted> sortedByName = new TreeSet<>(
        new SuperCombinedComparator(new ByNum2Comparator(), new ByNum2Comparator()));
    sortedByName.addAll(sorted);

    for(ToBeSorted v: sortedByName) {
      System.out.println(v);
    }

    System.out.println("---------");

    ArrayList<ToBeSorted> array = new ArrayList<>(sorted);

    System.out.println(array);

    array.sort(new ByNameComparator());

    System.out.println(array);

    array.sort(new ByNum1Comparator());

    System.out.println(array);
  }
}
