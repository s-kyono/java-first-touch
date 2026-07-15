import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * List、Set、Mapと、型を安全に再利用するジェネリクスを示します。
 */
public class CollectionsAndGenerics {
    /** このサンプルクラスのインスタンス化を防ぎます。 */
    private CollectionsAndGenerics() {
    }

    /**
     * 複数のコレクションへ値を格納し、検索や走査の結果を表示します。
     *
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Taro");
        names.add("Hanako");
        names.add("Jiro");
        System.out.println("List: " + names);

        Set<Integer> uniqueNumbers = new HashSet<>(List.of(1, 2, 2, 3));
        System.out.println("Set: " + uniqueNumbers);

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Taro", 80);
        scores.put("Hanako", 95);
        scores.forEach((name, score) -> System.out.println(name + ": " + score));

        Box<String> box = new Box<>("Java");
        System.out.println("Box: " + box.get());
        System.out.println("Listの先頭: " + first(names));
    }

    /**
     * 任意の型のListから先頭要素を取得します。
     *
     * @param values Inputとなる空でないList
     * @param <T> List要素の型
     * @return 先頭要素
     * @throws IllegalArgumentException Listが空の場合
     */
    static <T> T first(List<T> values) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("空のListです");
        }
        return values.getFirst(); // Java 21 の SequencedCollection API
    }
}

/**
 * 任意の型の値を一つ保持する、最小構成のジェネリッククラスです。
 *
 * @param <T> 保持する値の型
 */
class Box<T> {
    private final T value;

    /**
     * 指定された値を保持するBoxを生成します。
     *
     * @param value 保持する値
     */
    Box(T value) {
        this.value = value;
    }

    /**
     * Boxが保持している値を返します。
     *
     * @return 型が保証された保持値
     */
    T get() {
        return value;
    }
}
