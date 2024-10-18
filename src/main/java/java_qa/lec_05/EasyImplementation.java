package java_qa.lec_05;

public class EasyImplementation {

  interface AnyData {
    int size();
  }

  public static class OneData implements AnyData {
    @Override
    public int size() {
      return 1;
    }
  }

  public static class LargeData implements AnyData {
    @Override
    public int size() {
      return 1000;
    }
  }

  public static void main(String[] args) {
    AnyData anyData = new LargeData();
    System.out.println(anyData.size());
  }
}
