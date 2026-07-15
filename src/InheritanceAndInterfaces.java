/**
 * 継承、抽象クラス、インターフェースを通じた共通処理の呼び出しを示します。
 */
public class InheritanceAndInterfaces {
    /** このサンプルクラスのインスタンス化を防ぎます。 */
    private InheritanceAndInterfaces() {
    }

    /**
     * 異なる動物をAnimalとしてまとめ、実際の型に応じた振る舞いを実行します。
     *
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        Animal[] animals = {new Dog("Pochi"), new Cat("Tama")};

        for (Animal animal : animals) {
            animal.introduce();
            animal.speak();

            if (animal instanceof Pet pet) {
                pet.play();
            }
        }
    }
}

/**
 * すべての動物に共通する名前と振る舞いを定義する基底クラスです。
 */
abstract class Animal {
    private final String name;

    /**
     * 名前を持つ動物を生成します。
     *
     * @param name 動物の名前
     */
    protected Animal(String name) {
        this.name = name;
    }

    /**
     * 共通フィールドである名前を使って自己紹介します。
     */
    void introduce() {
        System.out.println("名前は" + name + "です");
    }

    /**
     * 動物ごとの鳴き声を出力します。具体的な処理はサブクラスが決定します。
     */
    abstract void speak();
}

/**
 * ペットとして遊べることを表すインターフェースです。
 */
interface Pet {
    /**
     * ペット固有の遊び方を出力します。
     */
    void play();
}

/**
 * Animalを継承し、Petとしても扱える犬を表します。
 */
class Dog extends Animal implements Pet {
    /**
     * 名前を持つ犬を生成します。
     *
     * @param name 犬の名前
     */
    Dog(String name) {
        super(name);
    }

    /**
     * 犬の鳴き声を出力します。
     */
    @Override
    void speak() {
        System.out.println("ワン");
    }

    /**
     * 犬の遊び方を出力します。
     */
    @Override
    public void play() {
        System.out.println("ボールで遊びます");
    }
}

/**
 * Animalを継承し、Petとしても扱える猫を表します。
 */
class Cat extends Animal implements Pet {
    /**
     * 名前を持つ猫を生成します。
     *
     * @param name 猫の名前
     */
    Cat(String name) {
        super(name);
    }

    /**
     * 猫の鳴き声を出力します。
     */
    @Override
    void speak() {
        System.out.println("ニャー");
    }

    /**
     * 猫の遊び方を出力します。
     */
    @Override
    public void play() {
        System.out.println("猫じゃらしで遊びます");
    }
}
