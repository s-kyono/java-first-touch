/**
 * 型判定と値の取り出しを同時に行うパターンマッチングを示します。
 */
public class PatternMatching {
    /** このサンプルクラスのインスタンス化を防ぎます。 */
    private PatternMatching() {
    }

    /**
     * 複数種類のInputをパターンマッチングへ渡し、型ごとの説明を表示します。
     *
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        Object value = "Java 21";

        // instanceof のパターン変数により、明示的なキャストが不要になる
        if (value instanceof String text) {
            System.out.println("文字数: " + text.length());
        }

        printDescription(new Point(3, 4));
        printDescription(25);
        printDescription(null);
    }

    /**
     * Inputの型と値を判定し、人が読める説明へ変換して表示します。
     *
     * @param value nullを含む任意のInput
     */
    static void printDescription(Object value) {
        String description = switch (value) {
            case null -> "nullです";
            case Point(int x, int y) -> "点(%d, %d)です".formatted(x, y);
            case Integer number when number > 0 -> "正の整数です: " + number;
            case Integer number -> "0以下の整数です: " + number;
            case String text -> "文字列です: " + text;
            default -> "その他の型です: " + value.getClass().getSimpleName();
        };
        System.out.println(description);
    }
}

/**
 * 二次元座標を不変データとして表します。
 *
 * @param x X座標
 * @param y Y座標
 */
record Point(int x, int y) {
}
