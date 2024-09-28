package java_qa.hw_03;

import java.util.Arrays;

public class ArraySwapPairsApp {

  public static int[] swapPairs(int[] input) {
    if (input == null || input.length < 2) {
      return input;
    }

    int[] result = new int[input.length];

    for (int i = 0; i < input.length - 1; i += 2) {
      result[i] = input[i + 1];
      result[i + 1] = input[i];
    }
    return result;
  }

  public static void main(String[] args) {
    int[] result;
    int[] array = {1, 2, 3, 4, 5, 6, 7};

    result = swapPairs(array);

    System.out.println(Arrays.toString(result));
  }
}
