package chapter_13_55;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class DatePattern {
  public static void main(String[] args) {
    exe();
  }

  private static void exe() {
    final var day = LocalDate.of(2022, 4, 1);
    final var dateList = Arrays.asList(
        DateTimeFormatter.ofPattern("yyyy'年' MMM dd'日' eeee"),  // 2022年 4月 01日 金曜日
        DateTimeFormatter.ofPattern("yyyy'年' MM d'日' eee"),     // 2022年 04 1日 金
        DateTimeFormatter.ofPattern("yyyy'年' M d'日' ee"));      // 2022年 4 1日 06
    dateList.stream().map(date -> date.format(day)).forEach(x -> System.out.printf("%s%n", x));
  }
}
/**
 * クラスDateTimeFormatter
 * https://docs.oracle.com/javase/jp/8/docs/api/java/time/format/DateTimeFormatter.html
 */
