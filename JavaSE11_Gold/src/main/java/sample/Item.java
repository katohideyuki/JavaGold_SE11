package sample;

 /* 商品を管理するクラス */
public class Item {
  private final String code;  // 商品コード
  private final String name;  // 名前
  private final int price;    // 値段
  private final int priority; // 優先度

  /* コンストラクタ */
  public Item(String code, String name, int price, int priority) {
    this.code = code;
    this.name = name;
    this.price = price;
    this.priority = priority;
  };

  public String getCode()  { return code; }
  public String getName()  { return name; }
  public int getPrice()    { return price; }
  public int getPriority() { return priority;}

  /* debug */
  @Override
  public String toString() {
    return String.format(" code : %s, name : %s, price : %s, priority : %s%n",
        getCode(), getName(), getPrice(), getPriority());
  }

}
