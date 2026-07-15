public class StringsAndTextBlocks {
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
