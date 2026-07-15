/**
 * record、enum、sealed型を使って制約のあるデータモデルを表現します。
 */
public class RecordsEnumsAndSealedTypes {
    /** このサンプルクラスのインスタンス化を防ぎます。 */
    private RecordsEnumsAndSealedTypes() {
    }

    /**
     * 各データ型のインスタンスを生成し、保持値と計算結果を表示します。
     *
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        User user = new User(1, "Taro");
        System.out.println(user.name() + ": " + user);

        OrderStatus status = OrderStatus.SHIPPED;
        System.out.println("注文状態: " + status.label());

        Shape circle = new Circle(3.0);
        Shape rectangle = new Rectangle(4.0, 5.0);
        System.out.printf("円の面積: %.2f%n", circle.area());
        System.out.printf("長方形の面積: %.2f%n", rectangle.area());
    }
}

/**
 * IDと名前だけを持つ不変なユーザーデータです。
 *
 * @param id 1以上のユーザーID
 * @param name 空でないユーザー名
 */
record User(int id, String name) {
    /**
     * recordの生成時に、すべてのフィールド値をまとめて検証します。
     *
     * @throws IllegalArgumentException IDまたは名前が不正な場合
     */
    User {
        if (id <= 0 || name == null || name.isBlank()) {
            throw new IllegalArgumentException("idとnameを正しく指定してください");
        }
    }
}

/**
 * 注文で取り得る状態と、その表示名を対応付けます。
 */
enum OrderStatus {
    /** 注文を受け付け、発送を待っている状態です。 */
    PENDING("受付済み"),
    /** 注文を発送し、配達を待っている状態です。 */
    SHIPPED("発送済み"),
    /** 注文の配達が完了した状態です。 */
    DELIVERED("配達済み");

    private final String label;

    /**
     * 状態に対応する日本語表示名を設定します。
     *
     * @param label 表示名
     */
    OrderStatus(String label) {
        this.label = label;
    }

    /**
     * この注文状態の表示名を返します。
     *
     * @return 日本語の表示名
     */
    String label() {
        return label;
    }
}

/**
 * 面積を計算できる図形を表します。実装可能な型を円と長方形に限定します。
 */
sealed interface Shape permits Circle, Rectangle {
    /**
     * 図形固有の計算式で面積を求めます。
     *
     * @return 面積
     */
    double area();
}

/**
 * 半径を持つ円を表します。
 *
 * @param radius 円の半径
 */
record Circle(double radius) implements Shape {
    /**
     * 半径から円の面積を計算します。
     *
     * @return 円周率×半径の二乗
     */
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

/**
 * 幅と高さを持つ長方形を表します。
 *
 * @param width 長方形の幅
 * @param height 長方形の高さ
 */
record Rectangle(double width, double height) implements Shape {
    /**
     * 幅と高さから長方形の面積を計算します。
     *
     * @return 幅×高さ
     */
    @Override
    public double area() {
        return width * height;
    }
}
