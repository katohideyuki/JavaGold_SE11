package chapter_13_47;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class SampleStream {
    public static void main(String[] args) {
      exe();
    }

    private static void exe() {
      final var alphabet = List.of("ABC", "DEF", "GHI", "JKL");

      Boolean resultMatch = alphabet.stream().anyMatch(str -> str.contains("G"));               // 一つでもマッチしていればtrueを戻す
      Stream<String> resultStream = alphabet.stream().filter(str -> str.contains("G"));         // マッチした要素ををStreamで戻す
      Optional<String> resultOp = alphabet.stream().filter(str -> str.contains("G")).findAny(); // マッチした要素をOptionalで戻す
      alphabet.stream().filter(str -> str.contains("G"))
          .forEachOrdered(str -> System.out.printf("そのまま出力 : %s %n", str)); // GHI

      System.out.printf("resultMatch : %b %n", resultMatch);                       // true
      resultStream.forEach(str -> System.out.printf("resultStream : %s %n", str)); // GHI
      System.out.printf("resultOp : %s %n", resultOp.orElse("値がありません"));      // GHI
    }
  }
  /**
   * Stream.anyMatch
   * - ストリーム内のいずれかの要素が引数に一致していればtrueを戻す
   *
   * Stream.findAny
   * - ストリーム内の要素を一つ持つOptional型の結果を戻す
   */
