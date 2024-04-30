package org.example.recursion;

public class FindMax {

  public static int findMaxTailRec(int[] arr) {
    if (arr.length > 0)
     return findMaxTailRecMain(arr, 1, arr[0]);
    else
      return -1;
  }

  private static int findMaxTailRecMain(int[] arr, int index, int maxValue) {
    if (index < arr.length) {
      // не дошли до конца массива и пробуем найти максимальный элемент в остатке массива
      return findMaxTailRecMain(arr, index + 1, Math.max(maxValue, arr[index]));
    } else {
      // массив закончился, возвращаем то, что нашли на предыдущих итерациях
      return maxValue;
    }
  }

  public static int findMaxNonTailRec(int[] arr) {
    if (arr.length > 0)
      return findMaxNonTailRecMain(arr, 1);
    else
      return -1;
  }

  private static int findMaxNonTailRecMain(int[] arr, int index) {
    if (index == arr.length - 1) {
      return arr[index];
    } else {
      // нехвостовая рекурсия - вызываем функцию сравнения после того, как получили результат рекурсивного
      // вызова findMaxNonTailRecMain
      return Math.max(arr[index],  findMaxNonTailRecMain(arr, index + 1));
    }
  }

  public static void main(String[] args) {
    int[] exampleArray = {4, 7, 9, 2, 15, 14};

    System.out.println("Хвостовая рекурсия: " + findMaxTailRec(exampleArray));
    System.out.println("Нехвостовая рекурсия: " + findMaxNonTailRec(exampleArray));
  }
}