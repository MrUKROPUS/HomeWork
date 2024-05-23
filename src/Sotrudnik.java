public class Sotrudnik {

    public static void main(String[] args) {
        User user1 = new User(1, "Вдовин Данил Валерьевич", "Стажёр AQA Java", 28, "mrukropus@gmail.com", 5555555, 30000);
        user1.info();
    }
    public static class User {

        private int id;
        private String name;
        private String position;
        private int age;
        private String email;
        private int phone;
        private int salary;

        public User(int id, String name, String position, int age, String email, int phone, int salary) {
            this.id = id;
            this.name = name;
            this.position = position;
            this.age = age;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
        }
        public void info() {
            System.out.println("id: " + id + ", ФИО: " + name + ", Должность: " + position + ", Возраст: " + age + ", Электронная почта: " + email + ", Телефон: " + phone + ", Зарплата: " + salary);
        }
    }
}
