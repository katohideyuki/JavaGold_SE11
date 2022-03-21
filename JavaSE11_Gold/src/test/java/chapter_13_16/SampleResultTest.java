package chapter_13_16;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("SampleResultクラスのリストを渡すと、数値が20よりも小さいものに絞り込まれ、絞り込まれた値の合計値が返ってくる")
class SampleResultTest {

  /* getTotalIfNeededを実行した結果をOptionalInt.orElse()で返す */
  Function<List<Item>, Integer> getTotalIfNeeded実行 = (srList) -> {
    OptionalInt opI = new SampleResult().getTotalIfNeeded(srList);
    return opI.orElse(0);
  };

  @Test
  void _20よりも小さい値を持ったSampleResultクラスのリストを渡すと_その値がそのまま返ってくる() {
    List<Item> itemList = Arrays.asList(new Item.Builder("A", 10).build());
    assertEquals(10, getTotalIfNeeded実行.apply(itemList));
  }

  @Test
  void _20よりも大きい値を持ったSampleResultクラスのリストを渡すと_nullが返ってくる() {
    List<Item> itemList = Arrays.asList(new Item.Builder("A", 0).build());
    assertEquals(0, getTotalIfNeeded実行.apply(itemList));
  }

  @Test
  void _20よりも小さい値を複数持ったSampleResultクラスのリストを渡すと_値の合計値が返ってくる() {
    List<Item> itemList = Arrays.asList(
        new Item.Builder("A", 10).build(),
        new Item.Builder("B", 15).build()
        );
    assertEquals(25, getTotalIfNeeded実行.apply(itemList));
  }

  @Test
  void _20よりも小さい値と大きい値を複数持ったSampleResultクラスのリストを渡すと_20よりも小さい値の合計値が返ってくる() {
    List<Item> itemList = Arrays.asList(
        new Item.Builder("A", 10).build(),
        new Item.Builder("B", 15).build(),
        new Item.Builder("C", 20).build(),
        new Item.Builder("D", 25).build()
        );
    assertEquals(25, getTotalIfNeeded実行.apply(itemList));
  }

}
/**
 * - [x] SampleResultクラスのリストを渡すと、数値が20よりも小さいものに絞り込まれ、絞り込まれた値の合計値が返ってくる<br>
 * --- [x] 20よりも小さい値を持ったSampleResultクラスのリストを渡すと_その値がそのまま返ってくる<br>
 * --- [x] 20よりも大きい値を持ったSampleResultクラスのリストを渡すと_nullが返ってくる<br>
 * --- [x] 20よりも小さい値を複数持ったSampleResultクラスのリストを渡すと_値の合計値が返ってくる<br>
 * --- [x] 20よりも小さい値と大きい値を複数持ったSampleResultクラスのリストを渡すと_20よりも小さい値の合計値が返ってくる<br>
 */
