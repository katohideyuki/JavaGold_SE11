package chapter_13_12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger型/incrementAndGetメソッド/
 *
 */
public class CountUp {
  private AtomicInteger countNum;

  public static void main(String[] a) {

  }

  /**
   * スレッドプールを10生成して、10000 * 10回インクリメントする<br>
   * - スレッドセーフにしているはずだが、セーフになっていない。。。<br>
   *
   * @param num
   * @return 引数に10万プラスした整数値
   */
  private int countUpExe(int num) {
    countNum = new AtomicInteger(num);
    ExecutorService service = Executors.newFixedThreadPool(10);

    for (int i = 0; i < 10; i++) {
      service.submit(() -> {
        for (int j = 0; j < 10000; j++) {
//          synchronized (this) { /* 自分自身(CountUpインスタンス)をロック */
            countNum.incrementAndGet(); // Atomic用のインクリメント
//          }
        }
      });
    }
    service.shutdown();
    return countNum.intValue();
  }
}
