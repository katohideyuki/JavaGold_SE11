package chapter_13_60;

import java.util.Arrays;
import java.util.Comparator;

public class Ascending {

  /* ネストしたstaticなクラス */
  static class Item implements Comparable<Item>{
    private String name;  // 商品名
    private int price;    // 値段

    /* コンストラクタ */
    public Item(String name, int price) {
      this.name = name;
      this.price = price;
    }

    public int getPrice()              { return price; }
    public int compareTo(Item item)    { return name.compareTo(item.name); }                            // nameを比較
    @Override public String toString() { return String.format(" name : %s, price : %s", name, price); } // debug用
  }

  public static void main(String[] args) {
    exe();
  }

  /* 配列の中身を並べ替える */
  private static void exe() {
    Item[] beforeItems = {
        new Item("apple", 200), new Item("orange", 100), new Item("banana", 400),
        new Item("peach", 500), new Item("grape", 300)};
    Item[] afterItems = Arrays.stream(beforeItems)   /* 並び替えのため、配列からストリームに変換。最後にまた配列に戻す */
        .sorted()
        .toArray(Item[]::new);
    Item[] anotherItems = Arrays.stream(beforeItems) /* sort内容をStream内で定義するパターン */
        .sorted(Comparator.comparing(Item::getPrice))
        .toArray(Item[]::new);

    Arrays.stream(beforeItems).forEach(System.out::println);    // apple, orange, banana, peach, grape
    System.out.println("-------------------------- 名前順にソート --------------------------");
    Arrays.stream(afterItems).forEach(System.out::println);     // apple, banana, grape, orange, peach
    System.out.println("-------------------------- 値段順にソート --------------------------");
    Arrays.stream(anotherItems).forEach(System.out::println);   // orange, apple, grape, banana, peach
  }
}
/**
 * Comparable.compareToメソッド
 * Comparetor.compareメソッド
 * Comparetor.comparingメソッド
 */