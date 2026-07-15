/**
 * 引数、戻り値、オーバーロード、可変長引数、再帰を小さなメソッドで示します。
 */
public class Methods {
    /** このサンプルクラスのインスタンス化を防ぎます。 */
    private Methods() {
    }

    /**
     * このクラスの各メソッドへサンプルInputを渡し、Outputを表示します。
     *
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        greet("Hanako");
        System.out.println("合計: " + add(2, 3));
        System.out.println("小数の合計: " + add(2.5, 3.2));
        System.out.println("可変長引数の合計: " + sum(1, 2, 3, 4));
        System.out.println("5の階乗: " + factorial(5));
    }

    /**
     * 指定された名前を使って挨拶を表示します。
     *
     * @param name Inputとなる名前
     */
    static void greet(String name) {
        System.out.println("こんにちは、" + name + "さん");
    }

    /**
     * 二つの整数を加算します。
     *
     * @param left 左辺の整数
     * @param right 右辺の整数
     * @return 加算結果
     */
    static int add(int left, int right) {
        return left + right;
    }

    /**
     * 二つの小数を加算します。同じ名前でも引数の型が異なるため、整数版と共存できます。
     *
     * @param left 左辺の小数
     * @param right 右辺の小数
     * @return 加算結果
     */
    static double add(double left, double right) {
        return left + right;
    }

    /**
     * 個数が決まっていない整数をすべて加算します。
     *
     * @param numbers Inputとなる0個以上の整数
     * @return 合計値。Inputが0個なら0
     */
    static int sum(int... numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }

    /**
     * 指定した整数の階乗を再帰呼び出しで求めます。
     *
     * @param number Inputとなる0以上の整数
     * @return 階乗の計算結果
     */
    static long factorial(int number) {
        if (number <= 1) {
            return 1;
        }
        return number * factorial(number - 1);
    }
}
