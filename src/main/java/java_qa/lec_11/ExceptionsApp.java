package java_qa.lec_11;

import java.util.ArrayList;

public class ExceptionsApp {

  public static class DividerHolder {
    int divider;

    public DividerHolder(int divider) {
      this.divider = divider;
    }

    public int getDivider() {
      return divider;
    }
  }

  public static class IllegalDividerHolderException extends RuntimeException {
    public IllegalDividerHolderException(String message) {
      super(message);
    }
  }

  public static class NegativeDividerHolderException extends Exception {
    public NegativeDividerHolderException(String message) {
      super(message);
    }
  }

  public static DividerHolder getDividerHolder() {
    return new DividerHolder(11);
  }

  public static DividerHolder getLessDividerHolder() {
    return new DividerHolder(3);
  }

  public static DividerHolder getNullDividerHolder() {
    return null;
  }

  public static int divideBy(int sourceValue, DividerHolder divHolder) throws NegativeDividerHolderException {
    if (divHolder.getDivider() > 10) {
      throw new IllegalDividerHolderException("Divider value is greater than 10 (" + divHolder.getDivider() + ")");
    }
    if (divHolder.getDivider() < 0) {
      throw new NegativeDividerHolderException("Divider value is negative");
    }

    // check divHolder value
    return sourceValue / divHolder.getDivider();
  }

  public static void divideAll(ArrayList<Integer> array, DividerHolder divHolder) throws NegativeDividerHolderException {
    for (int i = 0; i < array.size(); i++) {
      int divided = divideBy(array.get(i), divHolder);
      array.set(i, divided);
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> input = new ArrayList<>();
    input.add(9);
    input.add(27);
    input.add(12);
    input.add(33);

    System.out.println(input);

    DividerHolder divHolder = getNullDividerHolder();
//    DividerHolder divHolder = getDividerHolder();

    try {
      divideAll(input, divHolder); // основное действие
      System.out.println(input);
//    } catch (NegativeDividerHolderException x) {
//      //
    } catch (IllegalDividerHolderException x) {

      System.out.println("Try other div holder");
      DividerHolder divHolder2 = getLessDividerHolder();
      try {
        divideAll(input, divHolder2); // основное действие
        System.out.println(input);
      } catch (NegativeDividerHolderException xx) {
        //
      }
    } catch (RuntimeException x) {
      String s = x.getMessage();
      System.out.println("Illegal divider by the following reason: " + s + " : " + x.getClass().getName());
    } catch (Exception xxx) {

    }

    System.out.println("Final");
  }
}
