package java_qa.collections;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

interface IntElementOp {
  int op(int x, int y);
}

public class ListsApp {

  // Написать функцию которая принимает на вход массив int[] целых чисел и
  // возвращает инвертированный массив
  // Вывести оба массива в консоль в методе main

  // Написать функцию которая принимает на вход два массива int[] целых чисел и
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

  // + * -
  public static int[] arrOp(int[] a1, int[] a2, IntBinaryOperator op) {
    int minLen = Math.min(a1.length, a2.length);
    int maxLen = Math.max(a1.length, a2.length);

    int[] res = new int[maxLen];

    int i = 0;
    for(; i < minLen; i++) {
      res[i] = op.applyAsInt(a1[i], a2[i]);
    }

    for(int j = i; j < a1.length; j++) {
      res[j] = a1[j];
    }

    for(int j = i; j < a2.length; j++) {
      res[j] = a2[j];
    }
    return res;
  }

  public static void main(String[] args) {
    int[] testArr = new int[]{6, 5, -5, 18};
    int[] testResult = arrReverse(testArr);
    System.out.println(" in:" + java.util.Arrays.toString(testArr));
    System.out.println("res:" + java.util.Arrays.toString(testResult));

    System.out.println("--------");
    int[] a1 = new int[]{6, 5, -5, 18};
    int[] a2 = new int[]{4, 5, 7};
    int[] resAdd = arrOp(a1, a2, (x, y) -> x + y);
    int[] resMult = arrOp(a1, a2, (x, y) -> x - y);
    System.out.println(" a1:" + java.util.Arrays.toString(a1));
    System.out.println(" a2:" + java.util.Arrays.toString(a2));
    System.out.println(" r+:" + java.util.Arrays.toString(resAdd));
    System.out.println(" r-:" + java.util.Arrays.toString(resMult));
  }
}
