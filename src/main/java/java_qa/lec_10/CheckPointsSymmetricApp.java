package java_qa.lec_10;

import java.util.ArrayList;
import java.util.HashSet;

public class CheckPointsSymmetricApp {

  static boolean checkPointsSymmetric(ArrayList<Point> points) {
    if (points.size() == 0 || points.size() == 1) {
      return true;
    }

    int maxX = points.get(0).x;
    int minX = points.get(0).x;

    for (int i = 1; i < points.size(); i++) {
      maxX = Math.max(maxX, points.get(i).x);
      minX = Math.min(minX, points.get(i).x);
    }

    int middleX = (maxX + minX) / 2;

    HashSet<Point> pointsSet = new HashSet<>();
    pointsSet.addAll(points);

    while (!pointsSet.isEmpty()) {
      Point anyPoint = pointsSet.iterator().next();
      if (anyPoint.x == middleX) {
        pointsSet.remove(anyPoint);
      } else {
        Point oppositePoint = new Point(2*middleX - anyPoint.x, anyPoint.y);
        if (pointsSet.contains(oppositePoint)) {
          pointsSet.remove(anyPoint);
          pointsSet.remove(oppositePoint);
        } else {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    ArrayList<Point> points = new ArrayList<>();
    points.add(new Point(12, 37)); // 1
    points.add(new Point(16, 37)); // 3
    points.add(new Point(8,  38)); // 4
    points.add(new Point(20, 37)); // 6
    points.add(new Point(24, 38)); // 8

    System.out.println(checkPointsSymmetric(points));
  }
}
