package chapter_13_48;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ChangeList {
  public static void main(String[] args) {
    exe();
  }

  private static void exe() {
    List<Item> itemList = new ArrayList<>(List.of(
        new Item("banana", 100),
        new Item("apple", 80),
        new Item("orange", 80)));

    /* アイテムリストを並べ替える */
    itemList.sort(
        Comparator.comparing(Item::getPrice)
        .thenComparing(item -> item.getName())
        .reversed());

    itemList.forEach(item -> System.out.printf(" %s%n", item.getName())); // banana, orange, apple
  }
}
/**
 * comparing(並べ替えで利用するキー)
 *  - 並べ替えで利用するキーを受け取り、そのキーを使って並べ変えるCompation型オブジェクトを戻す
 *
 * thenComparing(並べ替えで利用するキー)
 *  - 直前のcomparingメソッドの結果、比較対象が等しいとき、別の条件で並べ替えるComparator型のオブジェクトを戻す
 *
 */

