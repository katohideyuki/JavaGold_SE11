package chapter_13_35;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class DosProtection {
  private static final String FILE_NAME = "src/main/resources/chapter_13_35/FruitListPath.txt";

  public static void main(String[] a) {
    exe();
  }

  /**
   * FruitListPath.txtには、FruitList.txtへのパスが記載されている<br>
   * - FruitListPath.txtを読み込み -> FruitList.txtを読み込み、一行出力<br>
   */
  private static void exe() {
    List<Reader> list = new ArrayList<>();
    File file = new File(FILE_NAME);
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      /* FruitListPath.txtを読み込んだ一行がnullじゃなければ処理を行い、次の一行を読み込む */
      for (String fileName = br.readLine(); fileName != null; fileName = br.readLine()) {
        /* 読み込んだ一行に記載されたファイルが存在すれば処理を行う */
        try (BufferedReader br2 = new BufferedReader(new FileReader(fileName))) {
          list.add(br2);
          process(br2); // 「acerola」が出力(FruitList.txtの一行目）
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      for (Reader reader : list) {
        try {
          reader.close();
        } catch (IOException e2) {
          throw new RuntimeException(e2);
        }
      }
    }
  }

  private static void process(BufferedReader br2) throws IOException {
    System.out.println(br2.readLine());
  }

}
