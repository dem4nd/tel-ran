package java_qa.basic;

public class Pig extends Pet {

  public Pig(String name, int height) {
    super(name, height);
  }

  @Override
  public String sound() {
    return "hru-hru";
  }
}
