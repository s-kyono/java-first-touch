import java.util.List;
import java.util.concurrent.Executors;

/**
 * Java 8からJava 21までの「知っていると便利」な機能を、
 * 小さなInput/Outputメソッドとして確認するチートシートです。
 *
 * <p>言語機能と標準APIは別物ですが、実務では組み合わせて使います。
 * 各メソッドのDocコメントに、導入バージョンと導入背景を記載しています。</p>
 */
public class ModernJavaCheatSheet {
    private ModernJavaCheatSheet() {
    }

    /**
     * チートシート内のメソッドをサンプルデータで実行します。
     *
     * @param args コマンドライン引数（未使用）
     * @throws Exception 仮想スレッド上の処理に失敗した場合
     */
    public static void main(String[] args) throws Exception {
        // List.of: Java 9 / var: Java 10
        var tasks = List.of(
                new WorkItem("見積書を作成", TaskStatus.DOING),
                new WorkItem("請求書を送付", TaskStatus.DONE),
                new WorkItem("問い合わせに返信", TaskStatus.TODO));

        System.out.println("未完了: " + findIncompleteTitles(tasks));
        System.out.println("先頭: " + getFirstTitle(tasks));
        System.out.println("状態: " + describe(tasks.getFirst()));
        System.out.println(createReport(tasks));
        System.out.println("別スレッドで処理: " + processInVirtualThread("monthly-report"));
    }

    /**
     * 未完了タスクのタイトルを返します。
     *
     * <ul>
     *   <li>使用機能: Stream APIはJava 8で導入</li>
     *   <li>使用メソッド: {@link java.util.stream.Stream#toList()}はJava 16で導入</li>
     *   <li>背景: ループの手順ではなく、抽出・変換という意図を宣言的に表現するため</li>
     * </ul>
     *
     * @param tasks Inputとなるタスク一覧
     * @return Outputとなる未完了タスク名の変更不可List
     */
    static List<String> findIncompleteTitles(List<WorkItem> tasks) {
        return tasks.stream()
                .filter(task -> task.status() != TaskStatus.DONE)
                .map(WorkItem::title)
                .toList();
    }

    /**
     * 一覧の先頭にあるタスク名を返します。
     *
     * <ul>
     *   <li>使用メソッド: {@link List#getFirst()}はJava 21で導入</li>
     *   <li>背景: ListやDequeなど、順序を持つコレクションの先頭・末尾操作を統一するため</li>
     *   <li>注意: 空のListでは{@link java.util.NoSuchElementException}が発生</li>
     * </ul>
     *
     * @param tasks Inputとなるタスク一覧
     * @return Outputとなる先頭タスク名
     * @see <a href="https://openjdk.org/jeps/431">JEP 431: Sequenced Collections</a>
     */
    static String getFirstTitle(List<WorkItem> tasks) {
        return tasks.getFirst().title();
    }

    /**
     * 値の型と中身に応じた説明を返します。
     *
     * <ul>
     *   <li>switch式はJava 14で正式導入</li>
     *   <li>recordはJava 16で正式導入</li>
     *   <li>record patternとswitchのパターンマッチングはJava 21で正式導入</li>
     *   <li>背景: 型判定・キャスト・値の取り出しを、安全で網羅的に記述するため</li>
     * </ul>
     *
     * @param value Inputとなる任意の値
     * @return Outputとなる値の説明
     * @see <a href="https://openjdk.org/jeps/361">JEP 361: Switch Expressions</a>
     * @see <a href="https://openjdk.org/jeps/395">JEP 395: Records</a>
     * @see <a href="https://openjdk.org/jeps/440">JEP 440: Record Patterns</a>
     * @see <a href="https://openjdk.org/jeps/441">JEP 441: Pattern Matching for switch</a>
     */
    static String describe(Object value) {
        return switch (value) {
            case null -> "データなし";
            case WorkItem(String title, TaskStatus status) ->
                    "%s（%s）".formatted(title, toJapaneseLabel(status));
            case String text -> "文字列: " + text;
            default -> "その他: " + value.getClass().getSimpleName();
        };
    }

    /**
     * ステータスを日本語表示へ変換します。
     *
     * <ul>
     *   <li>使用機能: 値を返すswitch式はJava 14で正式導入</li>
     *   <li>背景: break忘れによるフォールスルーを防ぎ、変換処理を一つの式として書くため</li>
     * </ul>
     *
     * @param status Inputとなるステータス
     * @return Outputとなる表示名
     * @see <a href="https://openjdk.org/jeps/361">JEP 361: Switch Expressions</a>
     */
    static String toJapaneseLabel(TaskStatus status) {
        return switch (status) {
            case TODO -> "未着手";
            case DOING -> "対応中";
            case DONE -> "完了";
        };
    }

    /**
     * タスク件数を複数行のレポートにします。
     *
     * <ul>
     *   <li>使用機能: テキストブロックはJava 15で正式導入</li>
     *   <li>使用メソッド: {@link String#formatted(Object...)}はJava 15で導入</li>
     *   <li>背景: JSON、SQL、帳票などの複数行文字列から過剰なエスケープを減らすため</li>
     * </ul>
     *
     * @param tasks Inputとなるタスク一覧
     * @return Outputとなる複数行レポート
     * @see <a href="https://openjdk.org/jeps/378">JEP 378: Text Blocks</a>
     */
    static String createReport(List<WorkItem> tasks) {
        long completed = tasks.stream()
                .filter(task -> task.status() == TaskStatus.DONE)
                .count();

        return """
                --- タスク集計 ---
                全件: %d
                完了: %d
                """.formatted(tasks.size(), completed);
    }

    /**
     * 一つの処理を仮想スレッドへ渡し、その結果を返します。
     *
     * <ul>
     *   <li>使用メソッド: {@link Executors#newVirtualThreadPerTaskExecutor()}はJava 21で正式導入</li>
     *   <li>背景: ブロッキングI/Oを含む大量の独立タスクを、読みやすいthread-per-task形式で扱うため</li>
     *   <li>注意: CPU負荷の高い計算を速くする機能ではない</li>
     * </ul>
     *
     * @param input Inputとなる処理名
     * @return Outputとなる処理結果
     * @throws Exception タスクの待機または実行に失敗した場合
     * @see <a href="https://openjdk.org/jeps/444">JEP 444: Virtual Threads</a>
     */
    static String processInVirtualThread(String input) throws Exception {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var future = executor.submit(() -> input.toUpperCase());
            return future.get();
        }
    }
}

/**
 * タスクのInput/Outputに使う不変データです。
 * recordは、データを運ぶクラスの定型コードを減らす目的でJava 16に正式導入されました。
 *
 * @param title タスク名
 * @param status ステータス
 * @see <a href="https://openjdk.org/jeps/395">JEP 395: Records</a>
 */
record WorkItem(String title, TaskStatus status) {
}

enum TaskStatus {
    TODO,
    DOING,
    DONE
}
