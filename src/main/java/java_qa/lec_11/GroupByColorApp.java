package java_qa.lec_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class GroupByColorApp {

  static class ColoredPoint {
    int x;
    int y;

    String color;

    public ColoredPoint(int x, int y, String color) {
      this.x = x;
      this.y = y;
      this.color = color;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }

    public String getColor() {
      return color;
    }

    @Override
    public String toString() {
      return "ColoredPoint{" +
          "x=" + x +
          ", y=" + y +
          ", color='" + color + '\'' +
          '}';
    }
  }

  static HashMap<String, ArrayList<ColoredPoint>> groupByColor(ArrayList<ColoredPoint> pointsList) {
    HashMap<String, ArrayList<ColoredPoint>> resultDictionary = new HashMap<>();

    for (ColoredPoint point: pointsList) {
      String colorKey = point.getColor();

      ArrayList<ColoredPoint> colorGroupedPoints = resultDictionary.get(colorKey);

//      if (colorGroupedPoints == null) {
//        ArrayList<ColoredPoint> initialPointArray = new ArrayList<>();
//        initialPointArray.add(point);
//        resultDictionary.put(colorKey, initialPointArray);
//      } else {
//        colorGroupedPoints.add(point);
//      }

      if (colorGroupedPoints == null) {
        colorGroupedPoints = new ArrayList<>();
        resultDictionary.put(colorKey, colorGroupedPoints);
      }
      colorGroupedPoints.add(point);
    }

    return resultDictionary;
  }

  public static void main(String[] args) {
    ArrayList<ColoredPoint> input = new ArrayList<>();
    input.add(new ColoredPoint(1, 2, "Red"));
    input.add(new ColoredPoint(3, 3, "Green"));
    input.add(new ColoredPoint(4, 5, "Yellow"));
    input.add(new ColoredPoint(4, 8, "Red"));
    input.add(new ColoredPoint(9, 11, "Yellow"));
    input.add(new ColoredPoint(-5, 20, "Yellow"));

    HashMap<String, ArrayList<ColoredPoint>> groupedPoints = groupByColor(input);

    Set<String> colors = groupedPoints.keySet();
    for (String color: colors) {
      ArrayList<ColoredPoint> pointsForColor = groupedPoints.get(color);
      System.out.println(color + " [" + pointsForColor.size() + "]");
      for (ColoredPoint p: pointsForColor) {
        System.out.println("    " + p);
      }
    }
  }
}
