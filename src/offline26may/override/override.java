package offline26may.override;

abstract class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void eat() {
        System.out.println(name + " is eating.");
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    void speak() {
        System.out.println(name + " says Woof!");
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    void speak() {
        System.out.println(name + " says Meow!");
    }
}

public class override {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy");
        Animal dog2 = new Dog("Buddy");
        Cat cat = new Cat("Whiskers");

        //dog2.speak();  // Buddy says Woof! -  compile error: can't resolve method 'speak' to 'Animal'
        cat.speak();  // Whiskers says Meow!

        dog.eat();    // Buddy is eating.
        cat.eat();    // Whiskers is eating.
    }
}
