package chapter_13_37;

import java.util.Arrays;


public class UseEnum {

  private enum Type {
    A(1, "A"), B(2, "B"), C(3, "C");

    private final int num;
    private final String name;

    private Type(int num, String name) {
      this.num = num;
      this.name = name;
    } // コンストラクタ

    @Override
    public String toString() {
      return String.valueOf(String.format("%s : %s", name, num));
    }
  }

  public static void main(String[] a) {
    System.out.println(Type.values()[1]); // B : 2
    Arrays.stream(Type.values()).forEach(type -> System.out.println(type)); // A : 1, B : 2,  C : 3
  }
}
/**
 * - enum.valueメソッドは、列挙型が持っている列挙子（定数）の配列を戻す -
 * String.valueOfメソッドは、受け取った参照が持つtoStringメソッドを呼び出す
 */
