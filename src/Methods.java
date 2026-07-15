public class Methods {
    public static void main(String[] args) {
        greet("Hanako");
        System.out.println("合計: " + add(2, 3));
        System.out.println("小数の合計: " + add(2.5, 3.2));
        System.out.println("可変長引数の合計: " + sum(1, 2, 3, 4));
        System.out.println("5の階乗: " + factorial(5));
    }

    static void greet(String name) {
        System.out.println("こんにちは、" + name + "さん");
    }

    static int add(int left, int right) {
        return left + right;
    }

    // 同じメソッド名でも、引数の型や数が異なれば定義できる
    static double add(double left, double right) {
        return left + right;
    }

    static int sum(int... numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }

    static long factorial(int number) {
        if (number <= 1) {
            return 1;
        }
        return number * factorial(number - 1);
    }
}
