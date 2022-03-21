package chapter_13_19;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * List/Setクラス<br>
 *
 */
public class PreDuplication {
  public static void main(String[] a) {
    createList();
  }

  /**
   * 重複許す/許さない は、equalsでtrueを返す/返さないで判定される<br>
   */
  private static void createList() {
    List<String> list = new LinkedList<>();
    Set<String> set = new HashSet<>();
    String[] str = { "a", "b", "c", "d", "a" };
    Arrays.stream(str).forEach(x -> {
      list.add(x);  // 重複も追加される
      set.add(x); // 重複は追加されない
    });
    System.out.printf("setの要素数は : %s, listの要素数は : %s, ", set.size(), list.size());
    Set<String> set_2 = new HashSet<>(list);
    List<String> list_2 = new LinkedList<>(set);
    System.out.printf("set_2の要素数は : %s, list_2の要素数は : %s", set_2.size(), list_2.size());
  }
}
