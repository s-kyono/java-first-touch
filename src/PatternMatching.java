public class PatternMatching {
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

record Point(int x, int y) {
}
