package java_qa.basic;

public class Dog extends Pet {

  public Dog(String name) {
    this(name, 0);
  }

  public Dog(String prefix, String owner) {
    this(prefix + "#" + owner);
  }

  public Dog(String name, int height) {
    super(name, height);

    if (height <= 0)
      System.out.println("Warning: unknown height " + name);
  }

  @Override
  public String sound() {
    return "gau-gau";
  }
}
