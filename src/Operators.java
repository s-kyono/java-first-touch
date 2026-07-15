/**
 * 算術、比較、論理、代入、三項演算子の使い方を示します。
 */
public class Operators {
    /** このサンプルクラスのインスタンス化を防ぎます。 */
    private Operators() {
    }

    /**
     * 二つの整数をInputとして各演算を行い、その結果を表示します。
     *
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        System.out.println("加算: " + (a + b));
        System.out.println("減算: " + (a - b));
        System.out.println("乗算: " + (a * b));
        System.out.println("整数の除算: " + (a / b));
        System.out.println("剰余: " + (a % b));

        System.out.println("等しい: " + (a == b));
        System.out.println("a は b より大きい: " + (a > b));

        boolean inRange = a >= 1 && a <= 100;
        boolean isSpecial = a == 0 || b == 0;
        System.out.println("範囲内: " + inRange);
        System.out.println("どちらかが0: " + isSpecial);
        System.out.println("範囲外: " + !inRange);

        a += 5;
        a++;
        String result = a % 2 == 0 ? "偶数" : "奇数";
        System.out.println("a=" + a + " は " + result);
    }
}
