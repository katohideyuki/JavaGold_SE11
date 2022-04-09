package chapter_13_48;

/* 商品情報 */
public class Item {
  private String name;   // 商品名
  private int price;     // 値段

  public Item(String name, int price) {
    super();
    this.name = name;
    this.price = price;
  }

  public String getName() { return name; }
  public int getPrice() { return price; }
}
