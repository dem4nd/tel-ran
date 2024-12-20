package java_qa.lec_12;

import java.util.ArrayList;

public class ExceptionExt2App {

  // Создать новый класс NegativeValueException
  // Написать метод printPositive, который печатает значение, если оно >=0 и бросает исключение NegativeValueException,
  // если значение отрицательное
  // В методе main написать цикл, который вызывает метод printPositive, а в слуучае ошибки ловит исключение и
  // накапливает ошибочные значения в ArrayList

  // Доп. условие: если ошибок стало слишком много (>3), прекратить обработку значений и выбросить исключение RuntimeException

  public static class NegativeValueException extends RuntimeException {
    int value;

    public NegativeValueException(String message, int value) {
      super(message);
      this.value = value;
    }
  }

  public static void printPositive(int v) {
    if (v < 0) {
      throw new NegativeValueException("Negative found", v);
    }
    System.out.println("Value: " + v);
  }

  public static void main(String[] args) {
    int[] values = new int[] { 5, 7, -9, -11, 12, -5, -6, 24 };

    ArrayList<Integer> illegalValues = new ArrayList<>();

    for (int i: values) {
      try {
          printPositive(i);

          // задержка, для корректного вывода на консоль
          try {
            Thread.sleep(1000L);
          } catch (Exception x) {}
      }
      catch (NegativeValueException x) {
        illegalValues.add(x.value);
        if (illegalValues.size() > 3) {
          throw new RuntimeException("Too many errors");
        }
      }
    }

    System.out.println("Illegal values found: " + illegalValues);
  }
}
