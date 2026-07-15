/**
 * Javaプログラムの最小構成と標準出力を示します。
 */
public class HelloWorld {
    /** このサンプルクラスのインスタンス化を防ぎます。 */
    private HelloWorld() {
    }

    /**
     * 挨拶を表示し、コマンドライン引数があれば先頭の値も表示します。
     *
     * @param args Inputとなるコマンドライン引数
     */
    public static void main(String[] args) {
        System.out.println("Hello, Java 21!");

        if (args.length > 0) {
            System.out.println("最初の引数: " + args[0]);
        }
    }
}
