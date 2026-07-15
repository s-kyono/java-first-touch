/**
 * 条件分岐と繰り返しによる処理の流れを示します。
 */
public class ControlFlow {
    /** このサンプルクラスのインスタンス化を防ぎます。 */
    private ControlFlow() {
    }

    /**
     * 点数や月を条件分岐で変換し、代表的なループを順に実行します。
     *
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        int score = 82;

        if (score >= 90) {
            System.out.println("評価: A");
        } else if (score >= 70) {
            System.out.println("評価: B");
        } else {
            System.out.println("評価: C");
        }

        int month = 7;
        String season = switch (month) {
            case 3, 4, 5 -> "春";
            case 6, 7, 8 -> "夏";
            case 9, 10, 11 -> "秋";
            case 12, 1, 2 -> "冬";
            default -> throw new IllegalArgumentException("不正な月: " + month);
        };
        System.out.println("季節: " + season);

        for (int i = 0; i < 3; i++) {
            System.out.println("for: " + i);
        }

        for (String color : new String[] {"red", "green", "blue"}) {
            System.out.println("拡張for: " + color);
        }

        int count = 2;
        while (count > 0) {
            System.out.println("while: " + count--);
        }

        int value = 0;
        do {
            value++;
        } while (value < 1);
        System.out.println("do-while: " + value);
    }
}
