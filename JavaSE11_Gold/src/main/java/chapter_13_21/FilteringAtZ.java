package chapter_13_21;

import java.util.Arrays;
import java.util.Optional;

/**
 * Optional.ifPresent<br>
 */
public class FilteringAtZ {
  public static void main(String[] args) {
    exe();
  }

  /* Optional.ifPrezentは、空のOptionalの場合、何も実行しない */
  private static void exe() {
    var list = Arrays.asList("apple", "banana", "orange", "melon");
    Optional<String> optional = list.stream().filter(x -> x.contains("z"))
        .reduce((a, b) -> String.format("%s , %s", a, b));

    optional.ifPresent(x -> System.out.println(x)); // 空のOptionalだから何も実行（表示)されない
    optional.ifPresentOrElse(x -> System.out.println(x), () -> System.out.println("空のOptionalだから何も表示しない")); // 空のOptionalの場合、第二引数が実行(表示)される
  }
}
