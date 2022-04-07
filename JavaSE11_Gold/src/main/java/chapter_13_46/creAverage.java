package chapter_13_46;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class creAverage {
  public static void main(String[] a) {
    exe();
  }

  private static void exe() {
    final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    double a = list.stream().collect(Collectors.averagingDouble(n -> n));      // 5.5
    double b = list.parallelStream().mapToInt(n -> n).average().getAsDouble(); // 5.5
  }
}
/**
 * Collectors.averagingXXX()
 *  - ストリームの要素をXXX型に変換し、平均値を戻す
 *  - XXXは、int, double, long
 *
 * XXXStream.average()
 *  - ストリーム内の数値の平均値を、OptionalXXX型で戻す
 *    - OptionalXXX.getAsXXX()
 *      - OptionalXXXの値をXXXで戻す
 *      - XXXは、int, double, long
 */
