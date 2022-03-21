package chapter_13_16;

import java.util.List;
import java.util.OptionalInt;

/**
 * IntStream.reduce<br>
 */
public class SampleResult {

  /**
   * @param Itemリスト
   * @return 合計値の入ったOptionaIntまたは空のOptionalInt
   */
  public OptionalInt getTotalIfNeeded(List<Item> srList) {
    return srList.stream().mapToInt(sr -> sr.getNum()).filter(num -> num < 20).reduce((a, b) -> a + b);
  }

}
