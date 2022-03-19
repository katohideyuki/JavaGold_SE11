package chapter_13_05;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("CreateAvarageTestは、りんごの価格の平均を返す")
class ItemTest {

  private List<Item> list; // 果物リスト
  private Item item; // りんご 1
  private Item item2; // りんご 2
  private Double expectedNum; // りんごの平均価格

  @BeforeEach
  void 前準備() {
    list = Arrays.asList(new Item("apple", 100), new Item("apple", 500), new Item("banana", 800),
        new Item("grape", 900));
    item = list.get(0);
    item2 = list.get(1);
    expectedNum = (item.getPrice() + item2.getPrice()) / 2;
  }

  @Nested
  class りんごのみが入ったリストを渡したら_りんごの価格の平均を返す {
    @Test
    void _1つのりんごのみが入ったリストを渡したら_りんごの価格の平均を返す() {
      List<Item> appleList_1st = Arrays.asList(item);
      assertEquals(item.getPrice(), item.getAvarage(appleList_1st), "平均値の取得 : 失敗"); // 100, 100
    }

    @Test
    void _2つのりんごのみが入ったリストを渡したら_りんごの価格の平均を返す() { /* 三角測量 */
      List<Item> appleList_2nd = Arrays.asList(item, item2);
      assertEquals(expectedNum, item.getAvarage(appleList_2nd), "平均値の取得 : 失敗"); // 250, 250
    }
  }

  @Test
  void 複数の果物が入ったリストを渡しても_りんごの価格の平均を返す() {
    assertEquals(expectedNum, item.getAvarage(list), "平均値の取得 : 失敗"); // 250, 250
  }

}

/**
 * TODOリスト<br>
 * - [x] 渡されたItem型のリストに入っているappleの価格の平均を返す<br>
 * --- [ ] Item型のリストを渡したら、appleの価格を返す<br>
 * ----- [x] りんごの価格が100になっているインスタンスが一つ入ったリストを渡したら_りんごの価格の100を返す() --- [ ]
 * Item型を渡したら、aplleの価格の平均を返す<br>
 *
 * ※ assertなんちゃらのメッセージ（第三引数）の必要性がいまだ不明。。。<br>
 */
