public class Person {

    public Person(String name, String position, String email, String number, int age, int salary) {
    }

    public static void main(String[] args) {

        Person[] persArray = new Person[5];
        persArray[0] = new Person("Сергей Иванов", "Старший Инженер", "SergeyIvanov@gmail.com", "88005553535", 30, 40000);
        persArray[1] = new Person("Петя Васечкин", "Аналитик", "PetyaVasechkin@gmail.com", "1-111-111", 25, 35000);
        persArray[2] = new Person("Артем Корочкин", "DevOps", "ArtemKorockin@gmail.com", "+73533520503", 28, 28000);
        persArray[3] = new Person("Алекс Мерсер", "Вирусолог", "AlexMerser@gmail.com", "5-555-555", 40, 25000);
        persArray[4] = new Person("Крис Редфилд", "Уничтожитель камней", "CrhisRedfield@gmail.com", "545-654", 50, 35000);
    }
}
