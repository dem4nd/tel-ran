package java_qa.basic;

public abstract class Pet {

  public Pet(String name) {
    this.name = name;
  }

  public Pet(String name, int height) {
    this.name = name;
    this.height = height;
  }

  private final String name;
  private int height;

  public String getName() {
    return name;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public abstract String sound();
}
