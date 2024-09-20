package java_qa.collections;

public class ListsApp {

  // Написать функцию которая принимает на вход массив int[] целых чисел и
  // возвращает инвертированный массив
  // Вывести оба массива в консоль в методе main

  // Написать функцию которая принимает на вход два массива int[] целых чисел (Integer) и
  // возвращает массив содержащий суммы соответствующих парных элементов
  // Если массивы имею разную длину, недостающие элементы считать равными нулю

  public static int[] arrReverse(int[] inArr) {
    int[] outArr = new int[inArr.length];// create output array

    for(int i = inArr.length-1, j = 0;
        j < outArr.length;
        i--, j++) {
      outArr[j] = inArr[i];
    }

    return outArr;
  }

  public static void main(String[] args) {
    int[] testArr = new int[]{6};
    int[] testResult = arrReverse(testArr);
    System.out.println(" in:" + java.util.Arrays.toString(testArr));
    System.out.println("res:" + java.util.Arrays.toString(testResult));
  }
}
