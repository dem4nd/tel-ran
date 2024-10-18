package java_qa.lec_06;

public class RefExampleApp {

  static class RefExample {
    String name;

    public RefExample(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return "RefExample{" +
          "'" + name + '\'' +
          '}';
    }
  }

  public static void main(String[] args) {
    RefExample r1 = new RefExample("N1"); // @3
    RefExample r2; //

    RefExample r3 = new RefExample("N1"); // @4

    System.out.println("r1: " + r1);
    System.out.println("r3: " + r3);
                                     // @3 == @4
    System.out.println("r1 == r3 : " + (r1 == r3));

    r2 = r1; // @3

    System.out.println("r2: " + r2);
                                     // @3 == @3
    System.out.println("r1 == r2 : " + (r1 == r2)); // true

    r3 = r1;
    // @3 == @3
    System.out.println("r1 == r3 : " + (r1 == r3)); // true

    r3.name = "K5";

    System.out.println(r1);
  }
}
