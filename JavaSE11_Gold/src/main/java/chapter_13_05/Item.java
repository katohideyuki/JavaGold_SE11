package chapter_13_05;

import java.util.List;

/**
 * Stream.mapToDouble/DoubleStream.average/OptionalDouble.orElseGet<br>
 */
public class Item {

  private final String name;
  private final int price;

  public Item(String string, int price) {
    this.name = string;
    this.price = price;
  }

  public double getPrice() {
    return price;
  }

  public String getName() {
    return name;
  }

  /**
   * Item型のリストを受け取り、りんごのみの平均価格を戻すメソッド<br>
   * ※ このメソッドをItemクラスで実装してしまったのは設計ミス<br>
   * - mapTo[整数型], mapToInt, mapToDoubleとか<br>
   * --- Function型の中間操作のやつ。averageとかMaxとかに使ったりする<br>
   * - average().orElseGet()<br>
   * --- getAsDoubleだと、空のOptionalに対して例外をスローするため、orElseGet()に変更<br>
   * --- 空のOptionalの場合、デフォルト値を返すよう定義<br>
   *
   * @param itemList
   * @return りんごの平均価格(double)
   */
  public double getAvarage(List<Item> itemList) {
    return itemList.stream().filter(item -> item.getName().equals("apple")).mapToDouble(x -> x.getPrice()).average()
        .orElseGet(() -> 0);
  }

}
