public class Person {

    public Person(String name, String position, String email, String number, int age, int salary) {
    }

    public static void main(String[] args) {

        Person[] persArray = new Person[5];
        persArray[0] = new Person("Сергей Иванов", "Старший Инженер", "SergeyIvanov@gmail.com", "88005553535", 30000, 40);
        persArray[1] = new Person("Петя Васечкин", "Аналитик", "PetyaVasechkin@gmail.com", "1-111-111", 25000, 35);
        persArray[2] = new Person("Артем Корочкин", "DevOps", "ArtemKorockin@gmail.com", "+73533520503", 28000, 28);
        persArray[3] = new Person("Алекс Мерсер", "Вирусолог", "AlexMerser@gmail.com", "5-555-555", 40000, 25);
        persArray[4] = new Person("Крис Редфилд", "Уничтожитель камней", "CrhisRedfield@gmail.com", "545-654", 50000, 35);
    }
}
