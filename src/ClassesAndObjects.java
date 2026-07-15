/**
 * クラスからオブジェクトを生成し、状態と振る舞いを扱う例を示します。
 */
public class ClassesAndObjects {
    /** このサンプルクラスのインスタンス化を防ぎます。 */
    private ClassesAndObjects() {
    }

    /**
     * Personを二人生成し、年齢の更新と生成数の共有を確認します。
     *
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        Person taro = new Person("Taro", 20);
        Person hanako = new Person("Hanako");

        taro.introduce();
        hanako.setAge(25);
        hanako.introduce();
        System.out.println("作成した人数: " + Person.getCount());
    }
}

/**
 * 名前と年齢を持つ人物を表します。フィールドをprivateにして、不正な更新を防ぎます。
 */
class Person {
    private final String name;
    private int age;
    private static int count;

    /**
     * 名前と年齢を指定して人物を生成します。
     *
     * @param name 人物の名前
     * @param age 0以上の年齢
     */
    Person(String name, int age) {
        this.name = name;
        setAge(age);
        count++;
    }

    /**
     * 年齢を0として人物を生成します。
     *
     * @param name 人物の名前
     */
    Person(String name) {
        this(name, 0);
    }

    /**
     * 現在の名前と年齢を使って自己紹介を表示します。
     */
    void introduce() {
        System.out.printf("私は%s、%d歳です。%n", name, age);
    }

    /**
     * 年齢を検証してから更新します。
     *
     * @param age Inputとなる新しい年齢
     * @throws IllegalArgumentException 年齢が負数の場合
     */
    void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("年齢は0以上にしてください");
        }
        this.age = age;
    }

    /**
     * これまでに生成されたPersonの総数を返します。
     *
     * @return 全インスタンスで共有される生成数
     */
    static int getCount() {
        return count;
    }
}
