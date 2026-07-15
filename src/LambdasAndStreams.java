import java.util.List;
import java.util.Optional;

/**
 * ラムダ式、メソッド参照、Stream API、Optionalによる一覧処理を示します。
 */
public class LambdasAndStreams {
    /** このサンプルクラスのインスタンス化を防ぎます。 */
    private LambdasAndStreams() {
    }

    /**
     * 名前一覧をInputとして抽出・変換・集計・検索し、そのOutputを表示します。
     *
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        List<String> names = List.of("Taro", "Hanako", "Jiro", "Nanami");

        names.forEach(name -> System.out.println("名前: " + name));

        List<String> longNames = names.stream()
                .filter(name -> name.length() >= 5)
                .map(String::toUpperCase)
                .sorted()
                .toList();
        System.out.println("5文字以上: " + longNames);

        int totalLength = names.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("文字数の合計: " + totalLength);

        Optional<String> found = names.stream()
                .filter(name -> name.startsWith("H"))
                .findFirst();
        System.out.println("検索結果: " + found.orElse("見つかりません"));
    }
}
