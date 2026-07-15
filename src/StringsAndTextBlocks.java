/**
 * 文字列操作と複数行テキストを読みやすく表現する方法を示します。
 */
public class StringsAndTextBlocks {
    /** このサンプルクラスのインスタンス化を防ぎます。 */
    private StringsAndTextBlocks() {
    }

    /**
     * 文字列をInputとして変換・判定・整形し、JSON風のテキストも表示します。
     *
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        String language = "Java";
        String version = "21";

        String message = language + " " + version;
        System.out.println(message);
        System.out.println("文字数: " + message.length());
        System.out.println("大文字: " + message.toUpperCase());
        System.out.println("Javaで始まる: " + message.startsWith("Java"));

        // 複数行の文字列を読みやすく記述できる
        String json = """
                {
                  "language": "Java",
                  "version": 21
                }
                """;
        System.out.println(json);

        String formatted = "%s %s".formatted(language, version);
        System.out.println("formatted: " + formatted);
    }
}
