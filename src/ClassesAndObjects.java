public class ClassesAndObjects {
    public static void main(String[] args) {
        Person taro = new Person("Taro", 20);
        Person hanako = new Person("Hanako");

        taro.introduce();
        hanako.setAge(25);
        hanako.introduce();
        System.out.println("作成した人数: " + Person.getCount());
    }
}

class Person {
    private final String name;
    private int age;
    private static int count;

    Person(String name, int age) {
        this.name = name;
        setAge(age);
        count++;
    }

    Person(String name) {
        this(name, 0);
    }

    void introduce() {
        System.out.printf("私は%s、%d歳です。%n", name, age);
    }

    void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("年齢は0以上にしてください");
        }
        this.age = age;
    }

    static int getCount() {
        return count;
    }
}
