package java_qa.lec_08;

public class RecursionExampleApp {

  public static void recursiveCount(int counter) {
    int nextCounter = counter - 1;
    if (nextCounter < 0) return;

    System.out.println("*");
    recursiveCount(nextCounter);
  }

  public static void main(String[] args) {
    System.out.println("-------");
    recursiveCount(4);
  }
}
