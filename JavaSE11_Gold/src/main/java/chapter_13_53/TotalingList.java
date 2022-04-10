package chapter_13_53;

import java.util.List;
import java.util.function.BinaryOperator;

/* ストリーム内の要素の累積値を取得する方法 */
public class TotalingList {
  public static void main(String[] a) {
    exe();
  }

  private static void exe() {
    final List<Item> itemList = List.of(
        new Item("apple", 100),
        new Item("banana", 80));
    BinaryOperator<Integer> operator = (a, b) -> a + b; // reduceメソッドに渡す
    int total_A = itemList.stream().map(item -> item.getPrice() * 10).reduce(operator).orElse(0);  // Item.priceを合算
    int total_B = itemList.stream().map(item -> item.getPrice() * 10).reduce(0, operator);         // Item.priceを合算
    int total_C = itemList.stream().mapToInt(item -> item.getPrice() * 10).sum();                  // Item.priceを合算
    System.out.printf(" total_A : %s%n total_B : %s%n total_C : %s%n", total_A, total_B, total_C);

    /* 以下、コンパイルエラーとなる */
//    int result = itemList.stream()
//        .map(Item::getPrice * 10)      // Function型をのラムダを受け取るmapメソッドに対して、getPriceのメソッド参照はできない
//        .reduce(operator)
//        .orElse(0);

//    int result = itemList.stream()
//        .map(item -> item.getPrice() * 10)
//        .reduce(operator)
//        .ifPresent(p -> p.intValue()); // Optional.ifPresentメソッドは戻り値を戻さないため

//    int result = itemList.stream()
//        .mapToInt(item -> item.getPrice() * 10)
//        .reduce(0, operator);          // reduceメソッドはIntStreamに存在しないため

  }
}
/**
 * Stream.reduceメソッド
 *  - BinaryOperator型のみ渡した場合は、Optional型が返ってくる
 *  - 戻り値を指定したい場合は、第一引数に戻り値型を指定する
 *
 * IntStream.sumメソッド
 */
