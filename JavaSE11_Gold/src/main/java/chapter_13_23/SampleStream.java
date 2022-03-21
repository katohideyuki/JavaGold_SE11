package chapter_13_23;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream.count<br>
 */
public class SampleStream {
  public static void main(String[] args) {
    exe();
  }

  private static void exe() {
    int array[][] = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
    long count = Stream.of(array).flatMapToInt(x -> IntStream.of(x)).map(num -> num * 2)
        .peek(x -> System.out.println(x)).filter(num -> num % 3 == 0).count(); // countは要素数を数える
    System.out.printf("要素数は : %s", count);

    long ほげ = Stream.of(array).flatMapToInt(x -> IntStream.of(x)).map(num -> num * 2).peek(x -> System.out.println(x))
        .filter(num -> num % 3 == 0).count(); // countは要素数を数える
    System.out.printf("要素数は : %s", count);
  }
}
