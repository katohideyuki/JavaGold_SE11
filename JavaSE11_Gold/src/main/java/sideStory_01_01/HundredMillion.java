package sideStory_01_01;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class HundredMillion {
  private static Optional<Integer> result; // カウントアップの結果
  private static List<Integer> countList = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0); // 10個の並列に分ける
  private static Function<Integer, Integer> countUp = (count) -> { /* 10,000,000のカウントアップ */
    for (int i = 0; i < 100_00_000; i++) count++;
    return count;
  };

  public static Integer getNum() {
    result = countList.parallelStream().map(countUp).reduce((y, z) -> y + z);
    return result.orElse(0);
  }

}
