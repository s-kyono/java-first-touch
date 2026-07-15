import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class Exceptions {
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

    static int divide(int left, int right) throws DivisionByZeroException {
        if (right == 0) {
            throw new DivisionByZeroException("0では割れません");
        }
        return left / right;
    }
}

class DivisionByZeroException extends Exception {
    DivisionByZeroException(String message) {
        super(message);
    }
}
