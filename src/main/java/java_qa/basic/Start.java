package java_qa.basic;


public class Start {

  public static void printSound(Pet pet) {
    System.out.println(pet.sound());
  }

  public static void main(String[] args) {
    Pet dog10 = new Dog("Boo 10", 10);
    Pet dog0 = new Dog("Boo 0", "Andrey");
    Pet dogDef = new Dog("Boo def");

    System.out.println(dog0.getName());
  }
}
