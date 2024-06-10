public abstract class Animal {
    abstract void run(int distance);
    abstract void swim(int distance);
}
class Dog extends Animal {
    private static int count = 0;
    @Override
    void run(int distance) {
        if (distance <= 500) {
            System.out.println("Собачка пробежала " + distance + " метров ");
        } else {
            System.out.println("Собачка не может пробежать такое расстояние");
        }
    }
    @Override
    void swim(int distance) {
        if (distance <= 10) {
            System.out.println("Собачка проплыла " + distance + " метров");
        } else {
            System.out.println("Собачка не может проплыть такое расстояние");
        }
    }
    public Dog() {
        count++;
    }
    public static int getCount() {
        return count;
    }
}
class Cat extends Animal {
    private static int count = 0;
    private boolean isFull = false;
    @Override
    void run(int distance) {
        if (distance <= 200) {
            System.out.println("Котик пробежал " + distance + " м.");
        } else {
            System.out.println("Котик не может пробежать такое расстояние");
        }
    }
    @Override
    void swim(int distance) {
        System.out.println("Котик не умеет плавать");
    }
    public Cat() {
        count++;
    }
    public static int getCount() {
        return count;
    }
    public void eat(int amount) {
        if (amount > 0) {
            isFull = true;
            System.out.println("Котик поел");
        } else {
            System.out.println("В миске нет столько еды");
        }
    }
    public boolean isFull() {
        return isFull;
    }
}
class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[3];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat();
            cats[i].eat(1000);
        }
        for (Cat cat : cats) {
            System.out.println("Котик сыт: " + cat.isFull());
        }
        Dog dog = new Dog();
        dog.run(300);
        dog.swim(10);
        System.out.println("Количество созданных котиков: " + Cat.getCount());
        System.out.println("Количество созданных собачек: " + Dog.getCount());
        System.out.println("Количество созданных животных: " + (Cat.getCount() + Dog.getCount()));
    }
}