package chapter_13_12;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("整数を渡したら、10万回インクリメントして返す")
class CountUpTest {

  @Test
  void 整数1を渡したら10万1の値を返す() {
    CountUp countUp = new CountUp();
    Method method = null;
    int result = 0; // countExeメソッドの結果
    try {
      method = CountUp.class.getDeclaredMethod("countUpExe", int.class); // メソッド取得 (メソッド名, 引数)
    } catch (NoSuchMethodException | SecurityException e) {
      throw new RuntimeException(e);
    }
    method.setAccessible(true); // privateメソッドへのアクセス許可

    try {
      result = (int) method.invoke(countUp, 1); // メソッド実行 (インスタンス, 引数)
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
    assertEquals(100001, result);
  }

}
/**
 * - [ ] 整数を渡したら、10万回インクリメントして返す<br>
 * --- [ ] 整数1を渡したら10万1の値を返す<br>
 * --- [ ] 整数2を渡したら10万2の値を返す<br>
 * --- [ ] nullを渡したら10万の値を返す<br>
 *
 * スレッドセーフになっていないため、テスト失敗<br>
 * - 解決の目処がたたないため、一旦スルー<br>
 */
