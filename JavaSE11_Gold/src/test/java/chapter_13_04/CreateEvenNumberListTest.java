package chapter_13_04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("CreateEvenNumberListTestクラスは、偶数のリストを作って返す")
class CreateEvenNumberListTest {
  private CreateEvenNumberList createEvenNumberList;

  @BeforeEach
  void 前準備() {
    createEvenNumberList = new CreateEvenNumberList();
  }

  @Test
  void 偶数のみで集まったリストを渡したら_何も変わらずリストが返ってくる() {
    List<Integer> list = Arrays.asList(2, 4, 6, 8, 10);
    assertIterableEquals(list, createEvenNumberList.execute(list));
  }

  @Nested // ネストしたクラスもテストさせるとき
  class テスト観点の大項目 { /* ネストしている意味は、テストケースをグループに分けて可読性をあげている */

    @Test
    void 奇数のみで集まったリストを渡したら_中身が空っぽのリストが返ってくる() {
      List<Integer> list = Arrays.asList(1, 3, 5, 7, 9);
      assertTrue(createEvenNumberList.execute(list).isEmpty());
    }

    /* something TestCode */

    /* something TestCode */
  }
}

/**
 * TODOリスト<br>
 * - [x] 偶数のみで集まったリストを渡したら、何も変わらずリストが返ってくる<br>
 * - [x] 奇数のみで集まったリストを渡したら、中身が空っぽのリストが返ってくる<br>
 */
