package java_qa.basic;

public class Cat extends Pet {

  public Cat(String name, int height) {
    super(name, height);
  }

  @Override
  public String sound() {
    return "meu-meu";
  }
}
