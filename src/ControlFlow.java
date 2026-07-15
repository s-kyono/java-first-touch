public class ControlFlow {
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
