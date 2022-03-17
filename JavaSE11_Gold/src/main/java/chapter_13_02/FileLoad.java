package chapter_13_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Q.02<br>
 * - Files.linesメソッドはStreamとして戻す<br>
 * - Files.readAllLinesメソッドはListとして戻す<br>
 */
public class FileLoad {
  private static final String FILE_NAME = "src/main/resources/chapter_13_02/FruitList.txt";

  public static void main(String[] a) {
    getFruit(FILE_NAME, 'g');
  }

  private static void getFruit(String fileName, char c) {
    Stream<String> fruitStream = null;
    try {
      fruitStream = Files.lines(Paths.get(fileName));
      List<String> fruitList = fruitStream.filter(fruit -> fruit.charAt(0) == c).collect(Collectors.toList());
      fruitList.forEach(x -> System.out.println(x));
      fruitStream.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
