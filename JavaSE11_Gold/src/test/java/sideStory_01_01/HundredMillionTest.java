package sideStory_01_01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("実行したら整数で1億の値が返ってくる")
class HundredMillionTest {
  private final static int num = 100_000_000; // 1億

  @Test
  void 実行したら整数で1億の値が返ってくる() {
    assertEquals(num, HundredMillion.getNum());
  }
}

/**
 * - [x] 実行したら整数で1億の値が返ってくる<br>
 */