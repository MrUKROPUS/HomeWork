import java.util.*;

public class Phonebook {

    private Map<String, List<String>> phoneBook;

    public Phonebook() {
        phoneBook = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {

        if (phoneBook.containsKey(lastName)) {
            phoneBook.get(lastName).add(phoneNumber);
        } else {

            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(lastName, phoneNumbers);
        }
    }


    public List<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, new ArrayList<>());
    }

    public static void main(String[] args) {
        Phonebook phoneBook = new Phonebook();


        phoneBook.add("Резнов", "88005553535");
        phoneBook.add("Мэйсон", "89005550005");
        phoneBook.add("Мэйсон", "88003654231");
        phoneBook.add("Вудс", "880832568721");
        phoneBook.add("Хадсон", "89002354123");
        phoneBook.add("Менендес", "89205355535");


        System.out.println("Резнов: " + phoneBook.get("Резнов"));
        System.out.println("Мэйсон: " + phoneBook.get("Мэйсон"));
        System.out.println("Вудс: " + phoneBook.get("Вудс"));
        System.out.println("Хадсон: " + phoneBook.get("Хадсон"));
        System.out.println("Менендес: " + phoneBook.get("Менендес"));
        System.out.println("Норьега: " + phoneBook.get("Норьега"));
    }
}
