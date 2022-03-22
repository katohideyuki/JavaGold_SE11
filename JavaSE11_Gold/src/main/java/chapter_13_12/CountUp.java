package chapter_13_12;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger型/incrementAndGetメソッド/
 *
 */
public class CountUp {
  private AtomicInteger countNum;
  private Future<?> future;

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
      future = service.submit(() -> {
        for (int j = 0; j < 10000; j++) {
          countNum.incrementAndGet(); // Atomic用のインクリメント
        }
      });
    }
    try {
      if ((future.get(10, TimeUnit.SECONDS) == null))
        service.shutdown(); // 処理が終わるのを待つ
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      e.printStackTrace();
    }
    return countNum.intValue(); // 処理が終わる前にcountNumを返してしまうため、Future.getで待機する
  }
}
