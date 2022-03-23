package chapter_13_34;

import java.util.ArrayList;

/**
 * 存在しない要素の書き換えで例外発生<br>
 */
public class NonExistingElements {
  public static void main(String[] a) {
    listUpdate();
  }

  private static void listUpdate() {
    try {
      var list = new ArrayList<>();
      list.add("A"); // 0
      list.add(100); // 1
      list.add("B"); // 2
      list.set(1, 200); // 1
      list.remove(2); // 2
      list.set(3, 300); // 3(存在しない要素の書き換えで例外発生)
    } catch (IndexOutOfBoundsException e) {
      throw new RuntimeException(e);
    }

  }
}