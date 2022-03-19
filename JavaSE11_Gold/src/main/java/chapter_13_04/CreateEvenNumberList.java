package chapter_13_04;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream.peekメソッド<br>
 */
public class CreateEvenNumberList {

  /**
   * @param list<Integer>
   * @return 偶数のみのlist<Integer>
   */
  public static List<Integer> execute(List<Integer> list) {
    return list.stream().filter(x -> x % 2 == 0).peek(x -> System.out.println("リスト : " + x))
        .collect(Collectors.toList());
  }
}
