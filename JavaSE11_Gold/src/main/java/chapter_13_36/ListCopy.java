package chapter_13_36;

import java.util.ArrayList;
import java.util.List;

public class ListCopy {
  public static void main(String[] a) {
    exe();
  }

  /* コピーしたリストに対して、中身を変更することはできない */
  private static void exe() {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);

    try {
      List copyList = List.copyOf(list);
      copyList.add(3); // 実行時に例外発生。コピーしたリストに対して、要素を追加しているため
    } catch (Exception e) {
      System.out.println(e);
      System.out.println("リストに追加できません。コピーしたリストは、変更不可能なリストです。");
    }
  }
}

/**
 * List.copyOfメソッドで生成したリストは「変更不可能なリスト」であり 要素に変更を加えた場合、実行時に例外が発生する -
 * UnsupportedOperationException
 */
