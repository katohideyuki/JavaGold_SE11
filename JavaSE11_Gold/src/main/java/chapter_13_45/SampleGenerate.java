package chapter_13_45;

import java.util.Random;
import java.util.stream.IntStream;

public class SampleGenerate {
  public static void main(String[] a) {
    exe();
  }

  private static void exe() {
    var random = new Random();
    IntStream.generate(() -> random.nextInt(100)).limit(10).forEach(System.out::println);
  }
}
/**
 * generate()
 * - int型の値を戻すIntSupplier型の引数を受け取り、引数のラムダ式が戻す値を含むランダムな整数のストリームを生成するメソッド
 *
 */
