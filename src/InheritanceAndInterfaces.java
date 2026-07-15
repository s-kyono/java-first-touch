public class InheritanceAndInterfaces {
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

abstract class Animal {
    private final String name;

    protected Animal(String name) {
        this.name = name;
    }

    void introduce() {
        System.out.println("名前は" + name + "です");
    }

    abstract void speak();
}

interface Pet {
    void play();
}

class Dog extends Animal implements Pet {
    Dog(String name) {
        super(name);
    }

    @Override
    void speak() {
        System.out.println("ワン");
    }

    @Override
    public void play() {
        System.out.println("ボールで遊びます");
    }
}

class Cat extends Animal implements Pet {
    Cat(String name) {
        super(name);
    }

    @Override
    void speak() {
        System.out.println("ニャー");
    }

    @Override
    public void play() {
        System.out.println("猫じゃらしで遊びます");
    }
}
