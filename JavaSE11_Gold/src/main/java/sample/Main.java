package sample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    System.out.println(serchItems());
  }

  /**
   * <pre>
   * とあるファイルに定義してある情報を記述された順番で取得
   * 今回はサンプルとして、取得した商品をリストで取得したと想定する
   * ※既存処理のため、ソースを変更できないとする
   * </pre>
   * @return 商品リスト
   */
  private static List<Item> createItemList() {
    List<Item> list = Arrays.asList(
        new Item("ITEM-001", "apple", 50, 2),
        new Item("ITEM-100", "banana", 200, 1),
        new Item("ITEM-999", "grape", 300, 3));
    return list;
  }

  /**
   * <pre>
   * 商品リストから、条件にマッチした最も優先度の高い商品を決定する
   * 条件にマッチした商品が取得できなかったら、デフォルト商品とする
   * </pre>
   * @return 条件にマッチした最優先の商品 OR デフォルト商品
   * @throws RuntimeException
   */
  private static Item serchItems() throws RuntimeException {
    String defaultCode = "ITEM-999";  // デフォルト商品コード
    Item defaultItem ;                // デフォルト商品
    List<Item> itemList ;             // とあるファイルから取得してきた商品リスト
    Optional<Item> itemOp ;           // 条件にマッチした中で、最優先の商品

    /* Itemクラスのリストを受け取り、優先度順に並び替えたリストを生成 */
    itemList = createItemList().stream()
        .sorted(Comparator.comparing(Item::getPriority))
        .collect(Collectors.toList());

    /* 最初に条件にマッチした商品を取得 */
    itemOp = itemList.stream().filter(x -> x.getPrice() >= 100).findFirst();

    /* デフォルト商品を取得し、取得できなかった場合は任意の例外をスロー */
    defaultItem = itemList.stream()
        .filter(item -> item.getCode().equals(defaultCode))
        .findFirst().orElseThrow(RuntimeException::new);

    if (!itemOp.isEmpty()) {
      return itemOp.get();
    } else {
      return defaultItem;
    }
  }
}
