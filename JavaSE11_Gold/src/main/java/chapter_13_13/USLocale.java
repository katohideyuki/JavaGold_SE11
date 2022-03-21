package chapter_13_13;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * FormatStyle.MEDIUM/SHORT/DateTimeFormatterクラス/fLocalizedDate/withLocale<br>
 */
public class USLocale {
  private static final Locale LOCALE = new Locale("en", "US");
  private static final LocalDate DAY = LocalDate.of(2021, 4, 1);

  /* ofLocalizedDateメソッドは、ロケール固有の日付フォーマットを使用するフォーマッタを提供 */
  public String getDayM() {
    return DAY.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(LOCALE));
  } // Apr 1, 2021

  /* withLocaleは、ロケールをオーバーライドする */
  public String getDayS() {
    return DAY.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(LOCALE));
  } // 4/1/21
}
