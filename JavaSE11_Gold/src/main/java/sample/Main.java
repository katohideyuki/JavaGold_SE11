package sample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
  /* 処理前のdebug */
  static final Consumer<Object> beforeDebug = obj -> System.out.printf(" ▼ 処理される前のリスト %n %s %n", obj);
  /* 処理結果のdebug */
  static final Consumer<Object> resultDebug = obj -> System.out.printf(" ▼ 今回取得したItem %n %s", obj);

  public static void main(String[] args) {
    resultDebug.accept(serchItems(createItemList()));
  }

  /**
   * <pre>
   * とあるファイルに定義してある情報を記述された順番で取得
   * 今回はサンプルとして、取得した商品をリストで取得したと想定する
   * ※ 既存処理のため、ソースを変更できないとする
   * ※ priceフィールド値は乱数で設定する。検証のため
   * </pre>
   * @return 商品リスト
   */
  private static List<Item> createItemList() {
    Supplier<Integer> random = () -> new Random().nextInt(200);
    List<Item> list = Arrays.asList(
        new Item("ITEM-001", "apple", random.get(), 2),
        new Item("ITEM-100", "banana", random.get(), 1),
        new Item("ITEM-999", "grape", random.get(), 3));
    beforeDebug.accept(list);
    return list;
  }

  /**
   * <pre>
   * 商品リストから、条件にマッチした最も優先度の高い商品を決定する
   * 条件にマッチした商品が取得できなかったら、デフォルト商品とする
   * </pre>
   * @param itemList 商品リスト
   * @return 条件にマッチした最優先の商品 OR デフォルト商品
   * @throws RuntimeException
   */
  private static Item serchItems(List<Item> itemList) throws RuntimeException {
    String defaultCode = "ITEM-999";  // デフォルト商品コード

    /* Itemクラスのリストを優先度順に並び替えたあと、最初に条件にマッチした商品を取得 */
    Optional<Item> resultItemOp = itemList.stream()
        .sorted(Comparator.comparing(Item::getPriority))
        .filter(item -> item.getPrice() >= 100).findFirst();

    /* デフォルト商品を取得し、取得できなかった場合は任意の例外をスロー */
    Item defaultItem = itemList.stream()
        .filter(item -> item.getCode().equals(defaultCode))
        .findFirst().orElseThrow(RuntimeException::new);

    // 条件にマッチした商品を取得できなかった場合、デフォルト商品を返却
    if (!resultItemOp.isEmpty()) {
      return resultItemOp.get();
    }
    return defaultItem;
  }
}
