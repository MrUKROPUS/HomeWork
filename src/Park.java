public class Park {
    public static void main(String[] args) {
        Attraction attraction1 = new Attraction("Чёртово колесо", "С 8:00 до 18:00", 500);
        attraction1.info();
        Attraction attraction2 = new Attraction("Машинки", "С 10:00 до 16:00", 300);
        attraction2.info();
        Attraction attraction3 = new Attraction("Качели", "Круглосуточно", 100);
        attraction3.info();
    }

    public static class Attraction {
        private String name;
        private String time;
        private int cost;

        public Attraction(String name, String time, int cost) {
            this.name = name;
            this.time = time;
            this.cost = cost;
        }

        public void info() {
            System.out.println("Название аттракциона: " + name + ", Расписание: " + time + ", Стоимость: " + cost);
        }
    }
}