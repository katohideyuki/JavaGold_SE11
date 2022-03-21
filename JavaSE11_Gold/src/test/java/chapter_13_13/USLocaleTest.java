package chapter_13_13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("USLocaleは、アメリカのロケールで2021/4/1の日付を、FormatStyle.MEDIUM/SHORTの書式で提供する食うｓ")
class USLocaleTest {

  @Test
  void 実行したらアメリカのロケールで4月1日の日付がMEDIUMフォーマットで返ってくる() {
    assertEquals("Apr 1, 2021", new USLocale().getDayM());
  }

  @Test
  void 実行したらアメリカのロケールで4月1日の日付がSHORTフォーマットで返ってくる() {
    assertEquals("4/1/21", new USLocale().getDayS());
  }

}

/**
 * - [x] 実行したらアメリカのロケールで4月1日の日付がMEDIUMフォーマットで返ってくる<br>
 * - [x] 実行したらアメリカのロケールで4月1日の日付がSHORTフォーマットで返ってくる<br>
 */
