package chapter_13_43;

import java.util.Arrays;
import java.util.List;

public class SampleStream {
  private static List<Item> itemList;    // 商品リスト

  static class Item {
    private String name;  // 商品名
    private int type;     // タイプ
    private int price;    // 値段

    public Item(String name, int type, int price) {
      this.name = name;
      this.type = type;
      this.price = price;
    }
    public int getType() { return type; }
  }

  public static void main(String[] args) {
    exe();
  }
  /* 商品リストから、商品の種類がいくつかるのか出力 */
  private static void exe() {
    itemList = Arrays.asList(new Item("apple", 1, 100), new Item("banana", 2, 150), new Item("orange", 1, 200));
    long count = itemList.stream().map( item -> item.getType()).distinct().count();
    System.out.printf("itemListの中のタイプ数 : %s", count); // 2
  }
}
