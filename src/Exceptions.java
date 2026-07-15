import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * 例外の送出・捕捉と、リソースを確実に閉じる方法を示します。
 */
public class Exceptions {
    /** このサンプルクラスのインスタンス化を防ぎます。 */
    private Exceptions() {
    }

    /**
     * 0除算の失敗を処理し、try-with-resourcesで文字列を読み込みます。
     *
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        try {
            System.out.println("結果: " + divide(10, 0));
        } catch (DivisionByZeroException e) {
            System.err.println("計算エラー: " + e.getMessage());
        } finally {
            System.out.println("計算処理を終了します");
        }

        // AutoCloseable なリソースを自動的に閉じる
        try (var reader = new BufferedReader(new StringReader("Java 21"))) {
            System.out.println("読み込み: " + reader.readLine());
        } catch (IOException e) {
            System.err.println("入出力エラー: " + e.getMessage());
        }
    }

    /**
     * 二つの整数を除算します。
     *
     * @param left 割られる整数
     * @param right 割る整数
     * @return 整数の除算結果
     * @throws DivisionByZeroException rightが0の場合
     */
    static int divide(int left, int right) throws DivisionByZeroException {
        if (right == 0) {
            throw new DivisionByZeroException("0では割れません");
        }
        return left / right;
    }
}

/**
 * 0除算という業務上区別したい失敗を呼び出し元へ伝える検査例外です。
 */
class DivisionByZeroException extends Exception {
    /**
     * エラー理由を持つ例外を生成します。
     *
     * @param message 呼び出し元へ伝えるエラーメッセージ
     */
    DivisionByZeroException(String message) {
        super(message);
    }
}
