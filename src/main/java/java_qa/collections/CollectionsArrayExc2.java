package java_qa.collections;

import java.util.Arrays;

public class CollectionsArrayExc2 {

  // Написать функцию, которая принимает на вход массив целых чисел
  // и возвращает массив в котором  каждые два соседних элемента
  // переставлены друг с другом

  // Пример 1: {2, 7, 17, 56, 9, -5} -> {7, 2, 56, 17, -5, 9}
  // Пример 2: {2, 7, 17, 56, 9} -> {7, 2, 56, 17, 9}
  // Пример 3: {} -> {}


  public static int[] swapPairs(int[] input) {
    if (input == null || input.length < 2) {
      return input;
    }

    int[] result = new int[input.length];

    for (int i = 0; i < input.length - 1; i += 2) {
      result[i] = input[i + 1];
      result[i + 1] = input[i];
    }
    return result;
  }

  public static void main(String[] args) {
    int[] result;
    int[] array = {1, 2, 3, 4, 5, 6, 7};

    result = swapPairs(array);

    System.out.println(Arrays.toString(result));


  }
}
