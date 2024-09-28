package java_qa.hw_03;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionsHw03App {

  public static void insertSorted(ArrayList<Integer> arr, Integer inserted) {

    // add code

  }

  public static ArrayList<Integer> convertToSorted(ArrayList<Integer> unsorted) {
    ArrayList<Integer> sorted = new ArrayList<>();

    // add code

    return sorted;
  }

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 9, 17, 18, 23));

    System.out.println("Source array:           " + arr);

    insertSorted(arr, 14);
    System.out.println("Array with inserted 14: " + arr);

  }
}
