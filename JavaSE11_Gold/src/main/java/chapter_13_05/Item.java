package chapter_13_05;

import java.util.List;

/**
tream.mapToDouble/IntStream.average/OptionalDouble.getAsDouble
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
   * ※ このメソッドをItem型で実装してしまったのは設計ミス<br>
   * - mapTo[整数型], mapToInt, mapToDoubleとか<br>
   * --- Function型の中間操作のやつ。averageとかMaxとかに使ったりする<br>
   *
   * @param itemList
   * @return りんごの平均価格(double)
   */
  public double getAvarage(List<Item> itemList) {
    return itemList.stream().filter(item -> item.getName().equals("apple")).mapToDouble(item -> item.getPrice())
        .average().getAsDouble();
  }

}
