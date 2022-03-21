package chapter_13_16;

public class Item {

  private final String name;
  private final int num;

  public static class Builder {
    private final String name;
    private final int num;

    public Builder(String name, int num) {
      this.name = name;
      this.num = num;
    }

    public Item build() {
      return new Item(this);
    }
  }

  public Item(Builder builder) {
    this.name = builder.name;
    this.num = builder.num;
  }

  public int getNum() {
    return num;
  }

  public String getName() {
    return name;
  }
}
